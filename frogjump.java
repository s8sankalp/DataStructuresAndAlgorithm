public class frogjump {
    public int frogJump(int[] heights) {
        int ind=heights.length;
        int prev2=0;
        int prev1=0;
        for(int i=1;i<ind;i++)
        {
             int left=prev1+Math.abs(heights[i]-heights[i-1]);
             int right=Integer.MAX_VALUE;
             if(i>1)
             {
                right=prev2+Math.abs(heights[i]-heights[i-2]);
             }
             int curr=Math.min(left,right);
             prev2=prev1;
             prev1=curr;
        }
        return prev1;
    }
    public static void main(String[] args){
        frogjump obj=new frogjump();
        int[] heights={2, 1, 3, 5, 4};
        int result=obj.frogJump(heights);
        System.out.println(result);
    }
}
