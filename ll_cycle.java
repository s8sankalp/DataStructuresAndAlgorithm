class ListNode{
    int val;
    ListNode next;
    ListNode(){
        val=0;
        next=null;
    }
    ListNode(int val)
    {
        this.val=val;
        next=null;
    }
    ListNode(int val,ListNode next)
    {
        this.val=val;
        this.next=next;
    }
}
public class ll_cycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
            {
                return true;
            }
        }
        return false;
    }
}
    class LinkedList{
        public ListNode create(ListNode head,int val)
        {
            ListNode newNode=new ListNode(val);
            if(head==null)
            {
                head=newNode;
                return head;
            }
            ListNode temp=head;
            while(temp.next!=null)
            {
                temp=temp.next;
            }
            temp.next=newNode;
            return head;
        }
        public void print(ListNode head)
        {
            if(head==null)
            {
                System.out.println("List is empty");
                return;
            }
            ListNode temp=head;
            while(temp!=null)
            {
                System.out.println(temp.val+" ");
                temp=temp.next;
            }
            System.out.println();
        }

    }
    class main{
        public static void main(String[] args)
        {
            ListNode one=new ListNode(1);
            ListNode two=new ListNode(2);
            ListNode three=new ListNode(3);
            ListNode four=new ListNode(4);
            one.next=two;
            two.next=three;
            three.next=four;
            four.next=two;
            ll_cycle sol=new ll_cycle();
            boolean ans=sol.hasCycle(one);
            System.out.println(ans);
        }
    }

