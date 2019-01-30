/**
 * 非递归的中序遍历
 *
 *      A         前序遍历：树根-前序遍历左子树-前序遍历右子树  ABDEGCF
 *     / \        中序遍历：中序遍历左子树-树根-中序遍历右子树  DBGEACF
 *    B   C       后序遍历：后序遍历左子树-后序遍历右子树-树根  DGEBFCA
 *   / \   \
 *  D   E   F
 *     /
 *    G
 */
public class InOrder {

    //返回中序遍历的下一个节点
    public TreeNode next(TreeNode node){
        if (node == null){
            return null;
        }
        if (node.getRight() != null){
            return first(node.getRight());
        }else {
            while (node.getParent() != null && node.getParent().getRight() == node){
                node = node.getParent();
            }
            return node.getParent();
        }
    }

    public TreeNode first(TreeNode node){
        if (node == null){
            return null;
        }
        TreeNode curNode = node;
        while (curNode.getLeft() != null){
            curNode = curNode.getLeft();
        }
        return curNode;
    }

    public void traverse(TreeNode root){
        for (TreeNode node = first(root); node != null ; node = next(node)) {
            System.out.print(node.getValue());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeCreator creator = new TreeCreator();
        InOrder inOrder = new InOrder();
        TreeNode tree = creator.creatSampleTree();
        inOrder.traverse(tree);
        inOrder.traverse(creator.creatTree("",""));
        inOrder.traverse(creator.creatTree("A","A"));
        inOrder.traverse(creator.creatTree("AB","BA"));
        inOrder.traverse(creator.creatTree("ABCD","DCBA"));
        inOrder.traverse(creator.creatTree("ABCD","ABCD"));


    }



}
