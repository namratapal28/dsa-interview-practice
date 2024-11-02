public class FlattenMultiLevelDoublyLinkedList {
    public static void main(String[] args) {
        FlattenMultiLevelDoublyLinkedList obj = new FlattenMultiLevelDoublyLinkedList();

        MultiLevelLinkedListNode head =  new MultiLevelLinkedListNode(1);
        head.next = new MultiLevelLinkedListNode(2);
        head.next.prev = head;

        head.next.next = new MultiLevelLinkedListNode(3);
        head.next.next.prev = head.next;

        head.next.next.child = new MultiLevelLinkedListNode(7);
        head.next.next.child.next = new MultiLevelLinkedListNode(8);
        head.next.next.child.next.prev = head.next.next.child;

        obj.flatten(head);
    }

    public MultiLevelLinkedListNode flatten(MultiLevelLinkedListNode head) {
        MultiLevelLinkedListNode curr = head;

        while(curr != null) {
            MultiLevelLinkedListNode p = curr.child;
            MultiLevelLinkedListNode q = null;
            boolean hasChild = false;

            while(p != null) {
                q = curr.next;
                curr.next = p;
                p.prev = curr;
                p = p.child;

                hasChild = true;
                curr.child = null;
            }

            MultiLevelLinkedListNode itr = null;
            MultiLevelLinkedListNode prev = null;

            if(hasChild) {
                itr = curr.next;
                prev = itr;
            }

            while(hasChild && itr != null) {
                prev = itr;
                itr = itr.next;
            }

            if(hasChild) {
                prev.next = q;
                if(q != null)
                    q.prev = prev;
            }

            curr = curr.next;
        }

        return head;
    }
}

class MultiLevelLinkedListNode {
    public int val;
    public MultiLevelLinkedListNode prev;
    public MultiLevelLinkedListNode next;
    public MultiLevelLinkedListNode child;

    public MultiLevelLinkedListNode(int v) {
        this.val = v;
    }
}
