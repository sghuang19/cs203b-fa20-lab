package assignment_3;


import java.util.Arrays;
import java.util.LinkedList;
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
            output.append(x.val).append(" ");
            output.append(new BinaryTree(x.right).TraversalInOrder());
        }
        return output.toString();
    }

    public String TraversalPreOrder() {
        StringBuilder output = new StringBuilder();
        if (this.root != null) {
            output.append(this.root.val).append(" ");
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
            output.append(this.root.val).append(" ");
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
                output.append(T.val).append(" ");
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
        return PreIn2PostTree(preTraversal, inTraversal).TraversalPostOrder();
    }

    private static BinaryTree PreIn2PostTree(String preTraversal, String inTraversal) {
        if (preTraversal.length() == 0 || inTraversal.length() == 0)
            return new BinaryTree(null);

        int[] pre = String2Array(preTraversal);
        int[] in = String2Array(inTraversal);

        TreeNode x = new TreeNode(pre[0]);
        BinaryTree tree = new BinaryTree(x);

        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                int[] left_sub_pre = Arrays.copyOfRange(pre, 1, i + 1);
                int[] left_sub_in = Arrays.copyOfRange(in, 0, i);
                x.left = PreIn2PostTree(Array2String(left_sub_pre), Array2String(left_sub_in)).root;

                int[] right_sub_pre = Arrays.copyOfRange(pre, i + 1, pre.length);
                int[] right_sub_in = Arrays.copyOfRange(in, i + 1, in.length);
                x.right = PreIn2PostTree(Array2String(right_sub_pre), Array2String(right_sub_in)).root;
            }
        }
        return tree;
    }


    public static String InPost2Pre(String inTraversal, String postTraversal) {
        return InPost2PreTree(inTraversal, postTraversal).TraversalPreOrder();
    }


    private static BinaryTree InPost2PreTree(String inTraversal, String postTraversal) {
        if (inTraversal.length() == 0 || postTraversal.length() == 0)
            return new BinaryTree(null);

        int[] in = String2Array(inTraversal);
        int l = in.length;
        int[] post = String2Array(postTraversal);

        TreeNode x = new TreeNode(post[l - 1]);
        BinaryTree tree = new BinaryTree(x);

        for (int i = 0; i < l; i++) {
            if (post[l - 1] == in[i]) {
                int[] left_sub_post = Arrays.copyOfRange(post, 0, i);
                int[] left_sub_in = Arrays.copyOfRange(in, 0, i);
                x.left = InPost2PreTree(Array2String(left_sub_in), Array2String(left_sub_post)).root;

                int[] right_sub_post = Arrays.copyOfRange(post, i, l - 1);
                int[] right_sub_in = Arrays.copyOfRange(in, i + 1, l);
                x.right = InPost2PreTree(Array2String(right_sub_in), Array2String(right_sub_post)).root;
            }
        }
        return tree;
    }

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
