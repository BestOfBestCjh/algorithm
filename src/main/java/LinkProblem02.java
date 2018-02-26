/**
 * Created by cjh on 2018/1/16
 * 将单向链表按某值划分成左边小、中间相等、右边大的形式
 */
public class LinkProblem02 {
    public static void main(String[] args) {

    }

    /**
     * 利用有限几个变量来进行操作，时间复杂度为O(N),空间复杂度为O(1)
     * @param head
     * @param pivot
     * @return
     */
    public static Node listPartiton2(Node head, int pivot){
        Node sH = null;//小的链表的头
        Node sT = null;//小的链表的尾
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;
        Node next = null;

        while (head != null){
            next = head.next;
            head.next = null;
            if (head.value < pivot){
                if (sH == null){
                    sH = head;
                    sT = head;
                }else {
                    sT.next = head;
                    sT = head;
                }
            }else if (head.value == pivot){
                if (eH == null){
                    eH = head;
                    eT = head;
                }else {
                    eT.next = head;
                    eT = head;
                }
            }else {
                if (bH == null){
                    bH = head;
                    bT = head;
                }else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }

        return null;

    }

}
