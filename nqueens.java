import java.util.ArrayList;
import java.util.List;

public class nqueens {
     public List<List<String>> solveNQueens(int n) {
        List<String> board=new ArrayList<>();
        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            board.add(".".repeat(n));
        }
        func(0,ans,board);
        return ans;
    }
    public void func(int row, List<List<String>> ans,List<String> board)
    {
        if(row==board.size())
        {
            ans.add(new ArrayList<>(board));
            return;
        }
        for(int col=0;col<board.get(0).length();col++)
        {
            if(issafe(board,row,col))
            {
                char[] rowarr=board.get(row).toCharArray();
                rowarr[col]='Q';
                board.set(row,new String(rowarr));
                func(row+1,ans,board);
                rowarr[col]='.';
                board.set(row,new String(rowarr));

            }
        }
    }
    public boolean issafe(List<String> board,int row,int col)
    {
        int r=row,c=col;
        while(r>=0&&c>=0)
        {
            if(board.get(r).charAt(c)=='Q')
            return false;
            r--;
            c--;

        }
        r=row;
        c=col;
        while(r>=0)
        {
           if( board.get(r).charAt(c)=='Q')
           return false;
           r--;
        }
         r=row;
        c=col;
        while(r>=0&&c<board.get(0).length())
        {
            if( board.get(r).charAt(c)=='Q')
            return false;
            r--;
            c++;
        }
        return true;
    }
    public static void main(String args[])
    {
        nqueens sol=new nqueens();
        int n=4;
        List<List<String>> result=sol.solveNQueens(n);
        for(List<String> solu:result){
            for(String row:solu){
                System.out.println(row);
            }

        }
    }
    
}
