public class trionic {
    public boolean isTrionic(int[] nums) {
        int i=0;
        int n=nums.length;
        boolean phase1=false;
        if(n<4) return false;
        while(i<n-1&&nums[i+1]>nums[i])
        {
            phase1=true;
            i++;
        }
        boolean phase2=false;
        while(i<n-1&&nums[i+1]<nums[i])
        {
            phase2=true;
            i++;
        }
        boolean phase3=false;
        while(i<n-1&&nums[i+1]>nums[i])
        {
            phase3=true;
            i++;
        }
        return phase1&&phase2&&phase3&&i==n-1;
    }
    public static void main(String args[])
    {
        trionic sol=new trionic();
        int arr[]={1,3,5,4,2,6};
        System.out.println(sol.isTrionic(arr));
    }
}
