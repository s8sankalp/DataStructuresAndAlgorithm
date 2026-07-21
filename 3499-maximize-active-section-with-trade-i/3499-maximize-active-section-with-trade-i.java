class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ones=0;
        List<Integer> zerogroup=new ArrayList<>();
        int i=0;
        while(i<s.length())
        {
            if(s.charAt(i)=='1')
            {
                ones++;
                i++;
            }
            else{
                int len=0;
                while(i<s.length()&&s.charAt(i)=='0')
                {
                    len++;
                    i++;
                }
                 zerogroup.add(len);
            }
        }
        int max=0;
        for(int j=0;j<zerogroup.size()-1;j++)
        {
            max=Math.max(max,zerogroup.get(j)+zerogroup.get(j+1));
        }
        return max+ones;
    }
}