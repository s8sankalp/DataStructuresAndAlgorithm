class Solution {

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        int[][] data = new int[n][4];

        for (int i = 0; i < n; i++) {
            data[i][0] = intervals.get(i).get(0);
            data[i][1] = intervals.get(i).get(1);
            data[i][2] = intervals.get(i).get(2);
            data[i][3] = i;
        }

        Arrays.sort(data, (a, b) -> Integer.compare(a[1], b[1]));

        long[][] maxWeight = new long[n + 1][5];

        List<Integer>[][] selected = new ArrayList[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int count = 0; count < 5; count++) {
                selected[i][count] = new ArrayList<>();
            }
        }

        for (int i = 0; i < n; i++) {
            int start = data[i][0];
            int weight = data[i][2];
            int originalIndex = data[i][3];

            int previous = findPrevious(data, i, start);

            for (int count = 1; count <= 4; count++) {

                long skip = maxWeight[i][count];
                long take = maxWeight[previous][count - 1] + weight;

                if (skip > take) {
                    maxWeight[i + 1][count] = skip;
                    selected[i + 1][count] =
                        new ArrayList<>(selected[i][count]);
                } else {
                    List<Integer> current =
                        new ArrayList<>(selected[previous][count - 1]);

                    current.add(originalIndex);
                    Collections.sort(current);

                    if (skip == take &&
                        compareLists(selected[i][count], current) < 0) {
                        current = new ArrayList<>(selected[i][count]);
                    }

                    maxWeight[i + 1][count] = take;
                    selected[i + 1][count] = current;
                }
            }
        }

        List<Integer> result = selected[n][4];

        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    private int findPrevious(int[][] data, int end, int start) {
        int left = 0;
        int right = end;

        while (left < right) {
            int mid = (left + right) / 2;

            if (data[mid][1] < start) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private int compareLists(List<Integer> first, List<Integer> second) {
        int length = Math.min(first.size(), second.size());

        for (int i = 0; i < length; i++) {
            if (!first.get(i).equals(second.get(i))) {
                return Integer.compare(first.get(i), second.get(i));
            }
        }

        return Integer.compare(first.size(), second.size());
    }
}