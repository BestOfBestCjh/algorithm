/**
 * Created by chen on 2017/12/7.
 * 链表相关问题
 */
public class NodeProblem {

    /**
     * 删除中间节点，要点：链条长度没增加2，要删除的节点就后移一个节点
     * 1-->2,删除节点1
     * 1-->2-->3,删除节点2
     * 1-->2-->3-->4,删除节点2
     * 1-->2-->3-->4-->5,删除节点3
     * @param head
     * @return
     */
    public Node removeMidNode(Node head){
        if (head == null || head.next == null){
            return head;
        }
        if (head.next.next == null){
            return head.next;
        }
        Node pre = head;
        Node cur = head.next.next;
        while (cur.next != null && cur.next.next != null){
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    /**
     * 删除位于a/b处节点的函数
     *
     * @param head
     * @param a
     * @param b
     * @return
     */
    public Node removeByRatio(Node head, int a, int b){
        if (a < 1 || a > b){
            return head;
        }
        int n = 0;
        Node cur = head;
        while (cur != null){
            n++;
            cur = cur.next;
        }
        n = (int)Math.ceil((double)(a * n) / (double) b);
        if (n == 1){
            head = head.next;
        }
        if (n > 1){
            cur = head;
            while (--n != 1){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    /**
     * 反转单向链表
     * @param head
     * @return
     */
    public Node reverseList(Node head){
        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 反转双向链表
     * @param head
     * @return
     */
    public DoubleNode reverseDoubleList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 反转部分单向链表
     * @param head
     * @param from
     * @param to
     * @return
     */
    public Node reversePart(Node head, int from, int to){
        int len = 0;
        Node node1 = head;
        Node fpre = null;
        Node tPos = null;
        while (node1 != null){
            len++;
            fpre = len == from -1 ? node1 : fpre;
            tPos = len == to + 1 ? node1 : tPos;
            node1 = node1.next;
        }
        if (from > to || from < 1 || to > len){
            return head;
        }
        node1 = fpre == null ? head : fpre.next;
        Node node2 = node1.next;
        node1.next = tPos;
        Node next = null;
        while (node2 != tPos){
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if (fpre != null){
            fpre.next = node1;
            return head;
        }
        return node1;
    }


    public Node josephusKill1(Node head, int m){
        if (head == null || head.next == head || m < 1){
            return head;
        }
        Node last = head;
        while (last.next != head){
            last = last.next;
        }
        int count = 0;
        while (head != last){
            if (++count == m){
                last.next = head.next;
                count = 0;
            }else {
                last = last.next;
            }
            head = last.next;
        }
        return head;
    }

    /**
     * 判断一个链表是否为回文结构
     * 1-->2-->1,返回true;
     * 1-->2-->2-->1,返回true;
     * 15-->4-->15,返回true;
     * 1-->2-->3,返回false;
     * @param head
     * @return
     */
    public boolean isPalindrome3(Node head){
        if (head == null || head.next == null){
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null){
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = n1.next;//n2 右部分第一个节点
        n1.next = null; // mid.next = null
        Node n3 = null;
        while (n2 != null){
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n3 = n1;// 保存最后一个节点
        n2 = head;//左边第一个节点
        boolean res = true;
        while (n1 != null && n2 != null){
            if (n1.value != n2.value){
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        n1 = n3.next;
        n3.next = null;
        while (n1 != null){
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;

    }

}
