class Solution {
    public String smallestPalindrome(String s) {
        int freq[]=new int[26];
        for(int i=0;i<s.length();i++)
        {
            freq[s.charAt(i)-'a']++;
        }
        StringBuilder first=new StringBuilder();
        StringBuilder mid=new StringBuilder();
        for(char c='a';c<='z';c++)
        {
            for (int i = 0; i < freq[c - 'a'] / 2; i++) {
                first.append(c);
            }
            if(freq[c-'a']%2==1)
            {
                mid.append(c);
            }
        }
        StringBuilder second=new StringBuilder(first).reverse();
        return first.toString()+mid.toString()+second.toString();
    }
}