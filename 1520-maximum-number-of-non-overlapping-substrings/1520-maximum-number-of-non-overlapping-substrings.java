class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, n);
        Arrays.fill(last, -1);

        
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';

            first[c] = Math.min(first[c], i);
            last[c] = i;
        }

        List<String> ans = new ArrayList<>();

        int prevEnd = -1;

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';

           
            if (first[c] != i) {
                continue;
            }

            int end = last[c];
            boolean valid = true;

            
            for (int j = i; j <= end; j++) {
                int curr = s.charAt(j) - 'a';

               
                if (first[curr] < i) {
                    valid = false;
                    break;
                }

                end = Math.max(end, last[curr]);
            }

            if (!valid) {
                continue;
            }

           
            if (i > prevEnd) {
                ans.add(s.substring(i, end + 1));
            } 
            
            else {
                ans.set(ans.size() - 1, s.substring(i, end + 1));
            }

            prevEnd = end;
        }

        return ans;
    }
}