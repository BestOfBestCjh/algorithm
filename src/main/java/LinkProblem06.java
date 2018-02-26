import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by cjh on 2018/1/18
 */
public class LinkProblem06 {

    public TreeNode convert1(TreeNode head){

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        inOrderToQueue(head,queue);
        if (queue.isEmpty()){
            return head;
        }
        head = queue.poll();
        TreeNode pre = head;
        pre.left = null;
        TreeNode cur = null;
        while (!queue.isEmpty()){
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;
        return head;
    }

    public void inOrderToQueue(TreeNode head, Queue<TreeNode> queue){
        if (head == null){
            return;
        }
        inOrderToQueue(head.left, queue);
        queue.offer(head);
    }

    public TreeNode process(TreeNode head){
        if (head == null){
            return null;
        }
        TreeNode leftE = process(head.left);
        TreeNode rightE = process(head.right);
        TreeNode leftS = leftE != null ? leftE.right : null;
        TreeNode rightS = rightE != null ? rightE.right : null;
        if (leftE != null && rightE != null){
            leftE.right = head;
            head.left = leftE;
            head.right = rightS;
            rightS.left = head;
            rightE.right = leftS;
            return rightE;
        } else if (leftE != null){
            leftE.right = head;
            head.left = leftE;
            head.right = leftS;
            return head;
        } else if (rightE != null){
            head.right = rightS;
            rightS.left = head;
            rightE.right = head;
            return rightE;
        } else {
            head.right = head;
            return head;
        }

    }

    public TreeNode convert2(TreeNode head){
        if (head == null){
            return null;
        }
        TreeNode last = process(head);
        head = last.right;
        last.right = null;
        return head;
    }
}
