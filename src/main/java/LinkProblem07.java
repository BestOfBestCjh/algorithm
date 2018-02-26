/**
 * Created by cjh on 2018/1/18
 */
public class LinkProblem07 {

    public static Node selectionSort(Node head){
        Node tail = null;
        Node cur = head;
        Node smallPre = null;
        Node small = null;
        while (cur != null){
            small = cur;
            smallPre = getSmallestPreNode(cur);
            if (smallPre != null){
                small = smallPre.next;
                smallPre.next = small.next;
            }
            cur = cur == small ? cur.next : cur;
            if (tail == null){
                head = small;
            }else {
                tail.next = small;
            }
            tail = small;
        }
        return head;
    }

    private static Node getSmallestPreNode(Node head) {
        Node smallPre = null;
        Node small = head;
        Node pre = head;
        Node cur = head.next;
        while (cur != null){
            if (cur.value < small.value){
                smallPre = pre;
                small = cur;
            }
            pre = cur;
            cur = cur.next;
        }
        return smallPre;
    }
}
