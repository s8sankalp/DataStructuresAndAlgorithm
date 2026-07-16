class Solution {
    public int leastBricks(List<List<Integer>> wall) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int maxEdges = 0;

        for (List<Integer> row : wall) {
            int sum = 0;

            // Don't include the last brick
            for (int i = 0; i < row.size() - 1; i++) {
                sum += row.get(i);

                int count = map.getOrDefault(sum, 0) + 1;
                map.put(sum, count);

                maxEdges = Math.max(maxEdges, count);
            }
        }

        return wall.size() - maxEdges;
    }
}