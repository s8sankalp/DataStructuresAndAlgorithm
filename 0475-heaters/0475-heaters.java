class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);

        int radius = 0;

        for (int house : houses) {
            int idx = Arrays.binarySearch(heaters, house);

            if (idx < 0) {
                idx = -idx - 1; // insertion point
            }

            int rightDist = idx < heaters.length
                    ? heaters[idx] - house
                    : Integer.MAX_VALUE;

            int leftDist = idx > 0
                    ? house - heaters[idx - 1]
                    : Integer.MAX_VALUE;

            int nearest = Math.min(leftDist, rightDist);
            radius = Math.max(radius, nearest);
        }

        return radius;
    }
}