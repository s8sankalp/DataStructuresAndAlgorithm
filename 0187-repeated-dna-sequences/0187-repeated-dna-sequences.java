class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen=new HashSet<>();
        Set<String> repeat=new HashSet<>();
        for(int i=0;i<=s.length()-10;i++)
        {
            String curr=s.substring(i,i+10);
            if(!seen.add(curr))
            {
                repeat.add(curr);
            }
        }
        return new ArrayList<>(repeat);
    }
}