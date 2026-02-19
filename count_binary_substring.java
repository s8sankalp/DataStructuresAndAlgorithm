public class count_binary_substring {
    public int count(String s)
    {
        int curr=1;
        int prev=0;
        int result=0;
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)==s.charAt(i-1))
            {
                curr++;
            }
            else{
                result+=Math.min(prev,curr);
                prev=curr;
                curr=1;
            }
            }
            result+=Math.min(prev,curr);
            return result;
        }
        public static void main(String[] args)
        {
            count_binary_substring sol=new count_binary_substring();
            String s="00110011";
            System.out.println(sol.count(s));
        }

    }
    

