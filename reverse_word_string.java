//reverse every word in a given string
public class reverse_word_string {
     private void reverseString(StringBuilder s, int start, int end) {
        while (start < end) {
            char temp = s.charAt(start);
            s.setCharAt(start, s.charAt(end));
            s.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    public String reverseWords(String s) {
        int n = s.length();

        // Reverse the entire string
        StringBuilder sb = new StringBuilder(s);
        reverseString(sb, 0, n - 1);

        int i = 0, j = 0, start = 0, end = 0;

        while (j < n) {
            // Skip spaces
            while (j < n && sb.charAt(j) == ' ') j++;
            if (j == n) break;

            start = i;

            // Copy the word characters forward
            while (j < n && sb.charAt(j) != ' ') {
                if (i < sb.length()) {
                    sb.setCharAt(i++, sb.charAt(j++));
                } else {
                    sb.append(sb.charAt(j++));
                    i++;
                }
            }

            end = i - 1;

            // Reverse the current word using start and end
            reverseString(sb, start, end);

            // Add a space after the word if it's not the last word
            if (j < n) {
                if (i < sb.length()) {
                    sb.setCharAt(i++, ' ');
                } else {
                    sb.append(' ');
                    i++;
                }
            }
        }

        // Remove trailing space if present
        if (i > 0 && sb.charAt(i - 1) == ' ') i--;

        return sb.substring(0, i);
    }
    public static void main(String[] args) {
        String s = " amazing coding skills ";

        // Creating an instance of reverse_word_string class
        reverse_word_string sol = new reverse_word_string();

        // Function call to reverse every word in the given string
        String ans = sol.reverseWords(s);

        // Output
        System.out.println("Input string: " + s);
        System.out.println("After reversing every word: " + ans);
    }

}
