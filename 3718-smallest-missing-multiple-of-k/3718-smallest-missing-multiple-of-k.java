class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> st=new HashSet<>();
        for(int num:nums)
        {
            st.add(num);
        }
        int x=k;
        for(int i=0;i<=nums.length;i++)
        {
            if(!st.contains(x))
            {
                return x;
            }
            x+=k;
        }
        return -1;
    }
}