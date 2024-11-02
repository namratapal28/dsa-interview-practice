public class LinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        LinkedList prog = new LinkedList();
        ListNode reversed = prog.reverse(head);
        prog.print(reversed);
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode next = head;
        ListNode temp = null;

        while(next != null) {
            temp = next.next;
            next.next = prev;

            prev = next;
            next = temp;
        }

        return prev;
    }

    public void print(ListNode head) {
        ListNode curr = head;

        while(curr != null) {
            System.out.print(curr.data);
            if(curr.next != null)
                System.out.print("->");

            curr = curr.next;
        }
    }
}

class ListNode {
    int data;
    ListNode next;

    public ListNode(int v) {
        this.data = v;
        next = null;
    }
}