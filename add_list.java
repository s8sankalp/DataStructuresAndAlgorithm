class ListNode{
    int data;
    ListNode next;
    ListNode()
    {
         data=0;
         next=null;
    }
    ListNode(int data)
    {
        this.data=data;
        next=null;
}
    ListNode(int data,ListNode next)
    {
        this.data=data;
        this.next=next;
    }
}
public class add_list {
    public ListNode add(ListNode l1,ListNode l2)
    {
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        int carry=0;
        while(l1!=null||l2!=null)
        {
            int sum=carry;
            if(l1!=null)
            {
                sum+=l1.data;
            }
            if(l2!=null)
            {
                sum+=l2.data;
            }
            ListNode node=new ListNode(sum%10);
            carry=sum/10;
            curr.next=node;
            curr=node;
            if(l1!=null)
            {
                l1=l1.next;
            }
            if(l2!=null)
            {
                l2=l2.next;
            }
        }
        if(carry!=0)
        {
            ListNode temp=new ListNode(carry);
            curr.next=temp;
            curr=temp;
        }
        return dummy.next;
    }
    class main{}
        public void print(ListNode head)
        {
            while(head!=null)
            {
                System.out.println(head.data+" ");
                head=head.next;
            }
            System.out.println();;
        }
        public static void main(String args[])
    {
        add_list sol=new add_list();
        ListNode l1=new ListNode(2,new ListNode(3,new ListNode(4)));
        ListNode l2=new ListNode(5,new ListNode(6,new ListNode(7)));
        ListNode result=sol.add(l1,l2);
        sol.print(result);
    }

}
