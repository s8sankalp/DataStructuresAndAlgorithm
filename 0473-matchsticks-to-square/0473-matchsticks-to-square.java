class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;

        for (int x : matchsticks)
            sum += x;

        if (sum % 4 != 0)
            return false;

        int side = sum / 4;

        Arrays.sort(matchsticks);

        // Reverse to descending order
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }

        int[] sides = new int[4];

        return dfs(matchsticks, 0, sides, side);
    }

    private boolean dfs(int[] matchsticks, int idx,
                        int[] sides, int target) {

        if (idx == matchsticks.length) {
            return sides[0] == target &&
                   sides[1] == target &&
                   sides[2] == target &&
                   sides[3] == target;
        }

        for (int i = 0; i < 4; i++) {
            if (sides[i] + matchsticks[idx] > target)
                continue;

            sides[i] += matchsticks[idx];

            if (dfs(matchsticks, idx + 1, sides, target))
                return true;

            sides[i] -= matchsticks[idx];

            // Symmetry pruning
            if (sides[i] == 0)
                break;
        }

        return false;
    }
}