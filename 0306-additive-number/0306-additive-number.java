import java.math.BigInteger;

class Solution {

    public boolean isAdditiveNumber(String num) {
        int n = num.length();

        for (int i = 1; i <= n / 2; i++) {

            if (num.charAt(0) == '0' && i > 1) break;

            for (int j = i + 1; j < n; j++) {

                if (num.charAt(i) == '0' && j - i > 1) break;

                BigInteger first =
                    new BigInteger(num.substring(0, i));

                BigInteger second =
                    new BigInteger(num.substring(i, j));

                if (check(num, j, first, second)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean check(String num,
                          int start,
                          BigInteger first,
                          BigInteger second) {

        while (start < num.length()) {

            BigInteger sum = first.add(second);
            String s = sum.toString();

            if (!num.startsWith(s, start)) {
                return false;
            }

            start += s.length();
            first = second;
            second = sum;
        }

        return true;
    }
}