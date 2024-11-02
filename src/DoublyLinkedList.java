public class DoublyLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;

        head.next.next = new Node(3);
        head.next.next.prev = head.next;

        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;

        DoublyLinkedList dll = new DoublyLinkedList();
        Node reversed = dll.reverse(head);
        dll.print(reversed);
    }

    public Node reverse(Node head) {
        Node prev = null;
        Node next = head;
        Node temp = null;

        while(next != null) {
            temp = next.next;
            next.next = prev;

            if(prev != null)
                prev.prev = next;

            prev = next;
            next = temp;
        }

        prev.prev = null;
        return prev;
    }

    public void print(Node head) {
        Node curr = head;
        System.out.println("Printing forward -----------------------------------------------");

        while(curr != null) {
            System.out.print(curr.data);
            if(curr.next != null)
                System.out.print("->");
            curr = curr.next;
        }

        System.out.println();
        System.out.println("Printing backward -----------------------------------------------");
        curr = head;
        while(curr != null) {
            if(curr.prev != null)
                System.out.print("<-");

            System.out.print(curr.data);
            curr = curr.next;
        }
    }
}

class Node {
    int data;
    Node next;
    Node prev;

    public Node(int v) {
        this.data = v;
    }
}
