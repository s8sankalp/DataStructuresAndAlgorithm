import java.util.*;

public class duplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> st=new HashSet<>();
        for(int num:nums){
            if(st.contains(num))
            {
                return true;
            }
            st.add(num);
        }
        return false;
    }
    public static void main(String args[])
    {
        duplicate sol=new duplicate();
        int[] nums={1,2,3,1};
        System.out.println("answer -> "+sol.containsDuplicate(nums));
    }
}
