import java.util.HashSet;

/**
 * Created by cjh on 2018/1/17
 * 删除无序单链表中值重复出现的节点
 */
public class LinkProblem04 {

    public void removeRep1(Node head){
        if (head == null){
            return;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        Node pre = head;
        Node cur = head.next;
        set.add(head.value);
        while (cur != null){
            if (set.contains(cur.value)){
                pre.next = cur.next;
            }else {
                set.add(cur.value);
                pre = cur;
            }
            cur = cur.next;
        }
    }
}
