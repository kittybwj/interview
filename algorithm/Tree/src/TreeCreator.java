/**
 * 创建树
 */
public class TreeCreator {
    /**
     *      A         前序遍历：树根-前序遍历左子树-前序遍历右子树  ABDEGCF
     *     / \        中序遍历：中序遍历左子树-树根-中序遍历右子树  DBGEACF
     *    B   C       后序遍历：后序遍历左子树-后序遍历右子树-树根  DGEBFCA
     *   / \   \
     *  D   E   F
     *     /
     *    G
    */
    public TreeNode creatSampleTree(){
        TreeNode root = new TreeNode('A');
        root.setLeft(new TreeNode('B'));
        root.getLeft().setLeft(new TreeNode('D'));
        root.getLeft().setRight(new TreeNode('E'));
        root.getLeft().getRight().setLeft(new TreeNode('G'));
        root.setRight(new TreeNode('C'));
        root.getRight().setRight(new TreeNode('F'));
        return root;
    }

    //已知树的前序和中序，求树（生成树）
    public TreeNode creatTree(String preOrder,String inOrder){
        if (preOrder.isEmpty()){
            return null;
        }
        char treeValue = preOrder.charAt(0);
        int rootIndex = inOrder.indexOf(treeValue);
        //int leftSize = rootIndex;
        TreeNode root = new TreeNode(treeValue);
        root.setLeft(creatTree(preOrder.substring(1,1+rootIndex),inOrder.substring(0,rootIndex)));
        root.setRight(creatTree(preOrder.substring(1+rootIndex),inOrder.substring(1+rootIndex)));
        return root;
    }

    //已知树的前序和中序，求树（不生成树）,直接返回后序遍历字符串
    public String printTreePostOrder(String preOrder,String inOrder){
        if (preOrder.isEmpty()){
            return "";
        }
        char treeValue = preOrder.charAt(0);
        int rootIndex = inOrder.indexOf(treeValue);

        return
        printTreePostOrder(
                preOrder.substring(1,1+rootIndex),
                inOrder.substring(0,rootIndex))+
        printTreePostOrder(
                preOrder.substring(1+rootIndex),
                inOrder.substring(1+rootIndex))+
        treeValue;
    }
}
