import java.util.Stack;

/**
 * Created by cjh on 2018/1/17
 */
public class LinkProblem05 {

    public Node removeValue1(Node head, int num){
        Stack<Node> stack = new Stack<Node>();
        while (head != null){
            if (head.value != num){
                stack.push(head);
            }
            head = head.next;
        }
        while (!stack.isEmpty()){
            stack.peek().next = head;
            head = stack.pop();
        }
        return head;
    }
}
