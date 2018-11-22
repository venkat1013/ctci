package GraphsAndTrees;

public class createMinimalBST {
    TreeNode createMinimalBST(int[] array) {
        return constructMinimalBST(array, 0, array.length - 1);
    }

    public TreeNode constructMinimalBST(int[] array, int begin, int end) {
        return null;
    }

    public TreeNode addToTree(int arr[],int begin,int end){
        if(begin > end){
            return null;
        }
        int mid = (begin + end)/2;
        TreeNode treeNode = new TreeNode(mid);
        treeNode.left = addToTree(arr,begin,mid-1);
        treeNode.right = addToTree(arr,mid+1,end);
        return treeNode;
    }

    class TreeNode {
        int      data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
