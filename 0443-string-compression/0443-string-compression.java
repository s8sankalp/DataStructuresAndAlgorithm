class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int write = 0;
        int i = 0;

        while (i < n) {
            char current = chars[i];
            int count = 0;

            // Count consecutive occurrences
            while (i < n && chars[i] == current) {
                i++;
                count++;
            }

            // Write character
            chars[write++] = current;

            // Write count if greater than 1
            if (count > 1) {
                String freq = String.valueOf(count);

                for (char c : freq.toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }
}