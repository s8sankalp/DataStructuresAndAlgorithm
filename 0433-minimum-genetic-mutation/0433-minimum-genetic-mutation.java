class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {

        Set<String> valid = new HashSet<>(Arrays.asList(bank));

        if (!valid.contains(endGene)) return -1;

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.offer(startGene);
        visited.add(startGene);

        char[] genes = {'A', 'C', 'G', 'T'};
        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String curr = q.poll();

                if (curr.equals(endGene))
                    return steps;

                char[] arr = curr.toCharArray();

                for (int j = 0; j < 8; j++) {
                    char original = arr[j];

                    for (char c : genes) {
                        if (c == original) continue;

                        arr[j] = c;
                        String next = new String(arr);

                        if (valid.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            q.offer(next);
                        }
                    }

                    arr[j] = original;
                }
            }

            steps++;
        }

        return -1;
    }
}