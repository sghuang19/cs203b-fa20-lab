package assignment_3;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class BinaryTree {
    public TreeNode root;

    public BinaryTree() {
    }

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public static boolean AddLeft(TreeNode parent, TreeNode left) {
        if (parent.left == null) {
            parent.left = left;
            return true;
        }
        return false;
    }

    public static boolean AddRight(TreeNode parent, TreeNode right) {
        if (parent.right == null) {
            parent.right = right;
            return true;
        }
        return false;
    }

    public String TraversalInOrder() {
        StringBuilder output = new StringBuilder();
        TreeNode x = this.root;
        if (x != null) {
            output.append(new BinaryTree(x.left).TraversalInOrder());
            output.append(x.val);
            output.append(" ");
            output.append(new BinaryTree(x.right).TraversalInOrder());
        }
        return output.toString();
    }

    public String TraversalPreOrder() {
        StringBuilder output = new StringBuilder();
        if (this.root != null) {
            output.append(this.root.val);
            output.append(" ");
            if (this.root.left != null)
                output.append(new BinaryTree(this.root.left).TraversalPreOrder());
            if (this.root.left != null)
                output.append(new BinaryTree(this.root.right).TraversalPreOrder());
        }
        return output.toString();
    }

    public String TraversalPostOrder() {
        StringBuilder output = new StringBuilder();
        if (this.root != null) {
            if (this.root.left != null)
                output.append(new BinaryTree(this.root.left).TraversalPostOrder());
            if (this.root.left != null)
                output.append(new BinaryTree(this.root.right).TraversalPostOrder());
            output.append(this.root.val);
            output.append(" ");
        }
        return output.toString();
    }

    public String TraversalLevelOrder() {
        StringBuilder output = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        int level;
        queue.offer(this.root);

        while (!queue.isEmpty()) {
            level = queue.size();
            output.append("[");
            for (int i = 0; i < level; i++) {
                TreeNode T = queue.remove();
                output.append(T.val);
                output.append(" ");
                if (T.left != null)
                    queue.offer(T.left);
                if (T.right != null)
                    queue.offer(T.right);
            }
            output.append("]");
        }

        return output.toString();
    }

    public static String PreIn2Post(String preTraversal, String inTraversal) {

    }

    public static BinaryTree PreIn2PostTree(String preTraversal, String inTraversal) {
        int[] pre = String2Array(preTraversal);
        int[] in = String2Array(inTraversal);

        TreeNode root = new TreeNode(in[0]);
        BinaryTree tree = new BinaryTree(root);
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                root.left = PreIn2Post(Array2String(Arrays.copyOfRange(pre, 1, i + 1)), Array2String(Arrays.copyOfRange(in, 0, i))).root;
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return tree;
    }

    //
//    public String InPost2Pre(String inTraversal, String postTraversal) {
//    }

    //
//    public BinaryTree InPost2Pre(String inTraversal, String postTraversal) {
//    }

    private static String Array2String(int[] array) {
        StringBuilder output = new StringBuilder();
        for (int val : array)
            output.append(val).append(" ");
        return output.toString();
    }

    private static int[] String2Array(String string) {
        String[] input = string.split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++)
            array[i] = Integer.parseInt(input[i]);
        return array;
    }

}
