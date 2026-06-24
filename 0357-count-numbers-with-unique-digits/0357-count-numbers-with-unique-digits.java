class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }

        int count = 10;
        int curr = 9;
        int available = 9;

        for (int i = 2; i <= n && available > 0; i++) {
            curr *= available;
            count += curr;
            available--;
        }

        return count;
    }
}