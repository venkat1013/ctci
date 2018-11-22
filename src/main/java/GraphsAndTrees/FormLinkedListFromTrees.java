package GraphsAndTrees;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
public class FormLinkedListFromTrees {
    FormLinkedListFromTrees(TreeNode treeNode) {
        createLinkedLists(treeNode);
    }
    class TreeNode {
        int                       data;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }
    public static ArrayList<LinkedList<TreeNode>> createLinkedLists(TreeNode treeNode) {
        ArrayList<LinkedList<TreeNode>> finalArrayListOfLLAtEachLevel = new ArrayList<LinkedList<TreeNode>>();
        LinkedList<TreeNode> rootLinkedList = new LinkedList<TreeNode>();
        rootLinkedList.add(treeNode);
        LinkedList<TreeNode> temp = rootLinkedList;
        finalArrayListOfLLAtEachLevel.add(rootLinkedList);
        while (temp.size() > 0) {
            temp = formNextLevelAsLinkedList(temp);
            if(temp != null){
                finalArrayListOfLLAtEachLevel.add(temp);
            }
        }
        return finalArrayListOfLLAtEachLevel;
    }

    static LinkedList<TreeNode> formNextLevelAsLinkedList(LinkedList<TreeNode> temp){
        if(temp == null){
            return null;
        }
        LinkedList<TreeNode> nextLevelNode = new LinkedList<TreeNode>();
        while (!temp.isEmpty()) {
            TreeNode node = temp.removeFirst();
            if(node.left != null){
                nextLevelNode.add(node.left);
            }
            if(node.right != null){
                nextLevelNode.add(node.right);
            }
        }
        return nextLevelNode;
    }

    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode treeNode){
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
        createLevelLinkedList(treeNode,lists,0);
        return lists;
    }

    public static void createLevelLinkedList(TreeNode treeNode, ArrayList<LinkedList<TreeNode>> lists, int level){
        if(treeNode == null){
            return;
        }
        LinkedList<TreeNode> list = null;
        if(lists.size() == level){
            list = new LinkedList<TreeNode>();
            lists.add(list);
        }
        else {
            lists.get(level);
        }
        list.add(treeNode);
        createLevelLinkedList(treeNode.left,lists,level+1);
        createLevelLinkedList(treeNode.right,lists,level);
    }

    public static TreeNode inOrderSuc(TreeNode treeNode) {
        if(treeNode != null){
            TreeNode succesor;
            if(treeNode.parent == null || treeNode.right != null){
                succesor = leftMostNode(treeNode.right);
            }
            else {
                TreeNode parent = treeNode.parent;
                if(parent.left == treeNode){
                    succesor = parent;
                    return succesor;
                }
                else {
                    inOrderSuc(parent);
                }
            }
        }
        return null;
    }

    public static TreeNode leftMostNode(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        while (treeNode.left != null) {
            treeNode = treeNode.left;
        }
        return treeNode;
    }

    public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(covers(root.left,p) && covers(root.left,q)){
            commonAncestor(root.left,p,q);
        }
        if(covers(root.right,p) && covers(root.right,q)){
            commonAncestor(root.right,p,q);
        }
        return root;
    }

    public static boolean covers(TreeNode root, TreeNode v){
        if(root == null){
            return false;
        }
        if(root == v){
            return true;
        }
        return covers(root.left,v) || covers(root.right,v);
    }

    public boolean containsTree(TreeNode t1, TreeNode t2){
        if(t2 == null){
            return true;
        }
        else {
            return subTree(t1,t2);
        }
    }
    public boolean subTree(TreeNode t1, TreeNode t2){
        if(t1 == null){
            return false;
        }
        if(t1.data == t2.data){
            if(matchTree(t1,t2)) return true;
        }
        return subTree(t1.left,t2) || subTree(t1.right,t2);
    }
    public boolean matchTree(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null){
            return true;
        }
        if(t1 == null || t2 == null){
            return false;
        }
        if(t1.data != t2.data){
            return false;
        }
        return matchTree(t1.left,t2.left) && matchTree(t1.right,t2.right);
    }
}
