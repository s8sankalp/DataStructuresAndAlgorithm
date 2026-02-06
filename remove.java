import java.util.Arrays;

public class remove {
    public int minRemoval(int[] nums, int k) {
       Arrays.sort(nums);
       int n=nums.length;
        int right=0;
        int ans=nums.length;
        for(int left=0;left<n;left++)
        {
            while(right<n&&nums[right]<=(long)nums[left]*k)
            {
                right++;
            }
            ans=Math.min(ans,n-(right-left));
        }
        return ans;
    }
    public static void main(String args[])
    {
        remove sol=new remove();
        int nums[]={4,6};
        int k=2;
        System.out.println("answer -> "+sol.minRemoval(nums,k));
    }
}
