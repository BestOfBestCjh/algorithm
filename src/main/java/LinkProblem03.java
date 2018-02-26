/**
 * Created by cjh on 2018/1/17
 * 将单链表的每K个节点之间逆序
 */
public class LinkProblem03 {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node next = null;
        for (int i = 2; i <= 10; i++) {
            Node cur = new Node(i);
            if (head.next == null){
                head.next = cur;
                next = cur;
            }
            next.next = cur;
            next = cur;
        }
        Node newHead = reverseNode2(head, 4);
        System.out.println();

    }

    public static Node reverseNode2(Node head, int k){
        if (k < 2){
            return head;
        }
        Node cur = head;
        Node start = null;
        Node pre = null;
        Node next = null;
        int count = 1;
        while (cur != null){
            next = cur.next;
            if (count == k){
                start = pre == null ? head : pre.next;
                head = pre == null ? cur : head;
                resign2(pre, start, cur, next);
                pre = start;
                count = 0;
            }
            count++;
            cur = next;
        }
        return head;
    }

    public static void resign2(Node left, Node start, Node end, Node right){
        Node pre = start;
        Node cur = start.next;
        Node next = null;
        while (cur != right){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (left != null){
            left.next = end;
        }
        start.next = right;
    }
}
