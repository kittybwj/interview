/**
 * 遍历树
 */
public class TreeTraversal {

    //前序遍历
    public void preOrder(TreeNode root){
        if (root == null){
            return;
        }
        System.out.print(root.getValue());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    //中序遍历
    public void inOrder(TreeNode root){
        if (root == null){
            return;
        }
        inOrder(root.getLeft());
        System.out.print(root.getValue());
        inOrder(root.getRight());
    }

    //后序遍历
    public void postOrder(TreeNode root){
        if (root == null){
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getValue());
    }


    public static void main(String[] args) {
        TreeCreator treeCreator = new TreeCreator();
        TreeTraversal traversal = new TreeTraversal();
        System.out.println("先序遍历：");
        traversal.preOrder(treeCreator.creatSampleTree());
        System.out.println();
        System.out.println("中序遍历:");
        traversal.inOrder(treeCreator.creatSampleTree());
        System.out.println();
        System.out.println("后序遍历:");
        traversal.postOrder(treeCreator.creatSampleTree());
        System.out.println();

        System.out.println("=============");

        System.out.println("已知先序为：ABDEGCF，中序为：DBGEACF，求后序遍历：");
        traversal.postOrder(treeCreator.creatTree("ABDEGCF","DBGEACF"));
        System.out.println();
        String postOrder = treeCreator.printTreePostOrder("ABDEGCF","DBGEACF");
        System.out.println(postOrder);
        System.out.println("已知先序为：空，中序为：空，求后序遍历：");
        traversal.postOrder(treeCreator.creatTree("",""));
        System.out.println();
        System.out.println("已知先序为：A，中序为：A，求后序遍历：");
        traversal.postOrder(treeCreator.creatTree("A","A"));
        System.out.println();
        System.out.println("已知先序为：AB，中序为：BA，求后序遍历：");
        traversal.postOrder(treeCreator.creatTree("AB","BA"));
        System.out.println();

    }
}
