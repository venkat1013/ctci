public class TreesAndGraphs {
    public boolean isBalancedTree(TreeNode root){
            return (maxDepth(root) - minDepth(root) <= 1);
    }
    public int minDepth(TreeNode treeNode) {
        if(treeNode == null){
            return 0;
        }
        return 1 + Math.min(minDepth(treeNode.left),minDepth(treeNode.right));
    }
    public int maxDepth(TreeNode treeNode){
        if(treeNode == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(treeNode.left),maxDepth(treeNode.right));
    }
    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int v){
            data = v;
            left = null;
            right = null;
        }
    }
}
