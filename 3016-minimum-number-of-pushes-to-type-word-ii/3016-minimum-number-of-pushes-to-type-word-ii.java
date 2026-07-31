public class Solution {

    public int minimumPushes(String word) {

        int[] freq = new int[26];

        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        Arrays.sort(freq);

        int[] descFreq = new int[26];
        for (int i = 0; i < 26; i++) {
            descFreq[i] = freq[25 - i];
        }

        int pushes = 0;

        for (int i = 0; i < 26; i++) {
            if (descFreq[i] == 0) break;
            pushes += (i / 8 + 1) * descFreq[i];
        }

        return pushes;
    }
}