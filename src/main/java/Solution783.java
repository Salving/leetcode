class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution783 {
    public int minDiffInBST(TreeNode root) {
        if (root.left == null && root.right == null) return Integer.MAX_VALUE;

        int minDiff = Integer.MAX_VALUE;
        if (root.right != null) {
            minDiff = Math.abs(root.val - leftmostElement(root.right));
        }
        if (root.left != null) {
            int leftDiff = Math.abs(root.val - rightmostElement(root.left));
            if (leftDiff < minDiff) minDiff = leftDiff;
        }

        if (root.left != null) {
            minDiff = Math.min(minDiff, minDiffInBST(root.left));
        }

        if (root.right != null) {
            minDiff = Math.min(minDiff, minDiffInBST(root.right));
        }
        return minDiff;
    }

    int leftmostElement(TreeNode root) {
        if (root.left == null) return root.val;
        else return leftmostElement(root.left);
    }

    int rightmostElement(TreeNode root) {
        if (root.right == null) return root.val;
        else return rightmostElement(root.right);
    }
}
