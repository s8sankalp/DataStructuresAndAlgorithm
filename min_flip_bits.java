public class min_flip_bits {public int minFlips(String s) {
        int flip1=0;
        int flip2=0;
        int result=Integer.MAX_VALUE;
        int i=0;
        int j=0;
        int n=s.length();
        while(j<2*n)
        {
            char s1=(j%2==0)?'1':'0';
            char s2=(j%2==0)?'0':'1';
            if(s.charAt(j%n)!=s1)
            {
                flip1++;
            }
            if(s.charAt(j%n)!=s2)
            {
                flip2++;
            }
            if(j-i+1>n)
            {
            s1=(i%2==0)?'1':'0';
            s2=(i%2==0)?'0':'1';
                if(s.charAt(i%n)!=s1)
                {
                    flip1--;
                }
                if(s.charAt(i%n)!=s2)
                {
                    flip2--;
                }
                i++;
            }
            if(j-i+1==n)
            {
                result=Math.min(result,Math.min(flip1,flip2));
            }
j++;
        }
        return result;
    }
    public static void main(String args[])
    {
        String s="111000";
        min_flip_bits sol=new min_flip_bits();
        System.out.println(sol.minFlips(s));
    }
    
}
