class Solution {
    public int maxProduct(int n) {
        String []num=String.valueOf(n).split("");
        int len=num.length;
        Arrays.sort(num);
        return Integer.valueOf(num[len-1])*Integer.valueOf(num[len-2]);

    }
}