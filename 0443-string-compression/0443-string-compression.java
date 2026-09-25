class Solution {
    public int compress(char[] chars) {
        StringBuilder str=new StringBuilder();
        int i=0,k=0;
        while(i<chars.length)
        {
            char c=chars[i];
            int j=i;
            while(j<chars.length&&chars[j]==c)
            {
                j++;
            }
            chars[k++]=c;
            if(j-i>1)
            {
                String s=String.valueOf(j-i);
                for(char x:s.toCharArray())
                {
                    chars[k++]=x;
                }
            }
            i=j;
        }
        return k;
    }
}