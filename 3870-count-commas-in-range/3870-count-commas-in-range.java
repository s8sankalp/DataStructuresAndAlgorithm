class Solution {
    public int countCommas(int n) {
        if(n<1000)return 0;
        int cnt=0;
        for(int i=1000;i<=100000;i++){
            if(i<=n)
            {
                cnt++;
            }
        }
        return cnt;
    }
}