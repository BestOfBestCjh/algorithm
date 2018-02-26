/**
 * Created by cjh on 2018/2/12
 */
public class BinaryTreeProblem01 {

    public void printEdge1(TreeNode head){
        if (head == null){
            return;
        }

    }

    public int getHeight(TreeNode h, int l){
        if (h == null){
            return l;
        }
        return Math.max(getHeight(h.left, l + 1), getHeight(h.right, l + 1));
    }


    /**
     * 获取每层的左右边界值
     * @param h
     * @param l
     * @param edgeMap
     */
    public void setEdgeMap(TreeNode h, int l, TreeNode[][] edgeMap){
        if (h == null){
            return;
        }
        edgeMap[l][0] = edgeMap[l][0] == null ? h : edgeMap[l][0];
        edgeMap[l][1] = h;
        setEdgeMap(h.left, l + 1, edgeMap);
        setEdgeMap(h.right, l + 1, edgeMap);
    }

    public void printLeafNotInMap(TreeNode h, int l, TreeNode[][] m){
        if (h == null){
            return;
        }
        if (h.left == null && h.right == null && h != m[l][0]){

        }
    }



}
