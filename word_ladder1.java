import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

class pair{
    int level;
    String word;
    pair(String word,int level)
    {
         this.word=word;
        this.level=level;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>(wordList);
Queue<pair> queue=new LinkedList<>();
queue.offer(new pair(beginWord,1));
set.remove(beginWord);
while(!queue.isEmpty())
{
    pair p=queue.poll();
    String word=p.word;
    int level=p.level;
    if(word.equals(endWord)==true)
    return level;
    for(int i=0;i<word.length();i++)
    {
        for(char j='a';j<='z';j++)
        {
            char replacedArray[]=word.toCharArray();
            replacedArray[i]=j;
            String replaced=new String(replacedArray);
            if(set.contains(replaced)==true)
            {
                set.remove(replaced);
            queue.offer(new pair(replaced,level+1));
            }
        }
    }
}
     return 0;   
    }
}