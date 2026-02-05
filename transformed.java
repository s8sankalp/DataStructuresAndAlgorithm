public class transformed {
    
    public int[] constructTransformedArray(int[] nums) {
        int n=nums.length;
        int[] result=new int[n];
        for(int i=0;i<n;i++)
        {
            if(nums[i]==0)
            {
                result[i]=nums[i];
            }
            else if(nums[i]>0)
            {
                result[i]=nums[(i+nums[i])%n];
            }
            else{
                result[i]=nums[(((i+nums[i])%n)+n)%n];
            }
        }
        return result;
    
}
public static void main(String args[])
{
    transformed sol=new transformed();
    int[] nums={3,-2,1,1};
    int result[]=sol.constructTransformedArray(nums);
    for(int i=0;i<nums.length;i++)
    {
        System.out.println(result[i]);
    }
}
}
