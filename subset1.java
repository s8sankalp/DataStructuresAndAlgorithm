import java.util.ArrayList;
import java.util.List;

public class subset1 {
    public List<Integer> subsetSums(int[] nums) {
       List<Integer> list=new ArrayList<>();
       check(0,list,nums,0);
       return list;
    }
    public void check(int ind,List<Integer> list,int[] nums,int sum)
    {
        if(ind==nums.length){
            list.add(sum);
            return;
        }
        check(ind+1,list,nums,sum);
        check(ind+1,list,nums,sum+nums[ind]);
        
    }
    public static void main(String args[])
    {
        subset1 sol=new subset1();
        int arr[]={1,2,3};
        System.out.println("answer="+sol.subsetSums(arr));
    }
}
