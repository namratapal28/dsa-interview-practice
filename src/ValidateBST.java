public class ValidateBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println("Is BST = " + new ValidateBST().isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    public boolean isValid(TreeNode root, Integer min, Integer max) {
        if(root == null)
            return true;

        if((min != null && root.val <= min) || (max != null && root.val >= max))
            return false;

        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
}
