public class max {
        public int nonAdjacent(int[] nums) {
int n=nums.length;
int prev=nums[0];
int prev2=0;
for(int i=1;i<n;i++)
{
    int take=nums[i];
    if(i>1)
    {
        take+=prev2;
    }
    int no=0+prev;
    int curr=Math.max(take,no);
    prev2=prev;
    prev=curr;
}
return prev;

    }
    public static void main(String[] args){
        max m=new max();
        int arr[]={1, 2, 4};
        int result=m.nonAdjacent(arr);
        System.out.println(result);
    }

}
