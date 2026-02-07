public class minimum_deletion_string {
    public int minimumDeletions(String s) {
        if(s.length()==1)return 0;
        int deletion=0;
        int bcount=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='a')
            {
                deletion=Math.min(deletion+1,bcount);
            }
            else{
                bcount++;
            }
        }
        return deletion;

    }
    public static void main(String args[])
    {
        minimum_deletion_string sol=new minimum_deletion_string();
        String s="bbaaaabb";
        System.out.println( "ans: "+sol.minimumDeletions(s));
    }
}
