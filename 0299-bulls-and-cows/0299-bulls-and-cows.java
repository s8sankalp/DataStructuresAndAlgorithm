class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;

        int[] count = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if (s == g) {
                bulls++;
            } else {
                int sd = s - '0';
                int gd = g - '0';

                if (count[sd] < 0) cows++;
                if (count[gd] > 0) cows++;

                count[sd]++;
                count[gd]--;
            }
        }

        return bulls + "A" + cows + "B";
    }
}