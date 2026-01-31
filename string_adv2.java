public class string_adv2 {
    public int countRev(String s) {
     int open=0,close=0,n=s.length();
     if(n%2==1)return -1;
     for(int i=0;i<n;i++)
     {
        if(s.charAt(i)=='(')
        open++;
        else{
            if(open>0)open--;
            else close++;
        }
     }
     int count=(open/2)+(open%2)+(close/2)+(close%2);
     return count;
    }
    public static void main(String args[])
    {
        string_adv2 sol =new string_adv2();
        String str=")))()(((";
        System.out.println("answer="+sol.countRev(str));

    }
}