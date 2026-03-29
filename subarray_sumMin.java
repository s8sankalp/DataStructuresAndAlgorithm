import java.util.Stack;

public class subarray_sumMin {
     public int[] nse(int arr[])
    {
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int ans[]=new int[n];
        for(int i=n-1;i>=0;i--)
        {
            int curr=arr[i];
            while(!st.isEmpty()&&arr[st.peek()]>=arr[i])
            {
                st.pop();
            }
            ans[i]=!st.isEmpty()?st.peek():n;
            st.push(i);
        }
        return ans;
    }
    public int[] pse(int arr[])
    {
        int n=arr.length;
        int ans[]=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty()&&arr[st.peek()]>arr[i])
            {
                st.pop();
            }
            ans[i]=!st.isEmpty()?st.peek():-1;
            st.push(i);
        }
        return ans;

    }
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int mod=(int)1e9+7;
        int pse[]=pse(arr);
        int nse[]=nse(arr);
        int sum=0;
        for(int i=0;i<n;i++)
        {
            int left=i-pse[i];
            int right=nse[i]-i;
            long freq=left*right*1L;
            int val=(int)((arr[i]*freq)%mod);
            sum=(sum+val)%mod;
        }
        return sum;
    }
     public static void main(String[] args) {
       int[] arr = {3, 1, 2, 5};
       
       /* Creating an instance of 
       subarray_sumMin class */
       subarray_sumMin sol = new subarray_sumMin(); 
       
       /* Function call to find the sum of the 
       minimum value in each subarray */
       int ans = sol.sumSubarrayMins(arr);
       
       System.out.println("The sum of minimum value in each subarray is: " + ans);
   }
}
