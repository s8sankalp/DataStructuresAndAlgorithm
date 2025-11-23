public class rob {
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
    public int houseRobber(int[] money) {
        int n=money.length;
        if(n==1)return money[0];
        int [] temp=new int[n];
        int[] temp2=new int[n];
        for(int i=0;i<n;i++)
        {
            if(i!=0)temp[i]=money[i];
            if(i!=n-1)temp2[i]=money[i];
        }
        return Math.max(nonAdjacent(temp),nonAdjacent(temp2));
    }
    public static void main(String[] args){
        rob r=new rob();
        int arr[]={1, 2, 4};
        int result=r.houseRobber(arr);
        System.out.println(result);
    }

}
