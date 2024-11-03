import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversals {
    List<Integer> res = new ArrayList<>();
    List<List<Integer>> r = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        BinaryTreeTraversals btt = new BinaryTreeTraversals();
        btt.preorderTraversal(root);
        btt.postorderTraversal(root);
        btt.inorderTraversal(root);
        btt.levelOrder(root);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return res;
    }

    public void preorder(TreeNode root) {
        if(root != null) {
            res.add(root.val);

            if(root.left != null)
                preorder(root.left);

            if(root.right != null)
                preorder(root.right);
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return res;
    }

    public void postorder(TreeNode root) {
        if(root != null) {
            if(root.left == null && root.right == null)
                res.add(root.val);

            if(root.left != null)
                postorder(root.left);

            if(root.right != null)
                postorder(root.right);

            if(root.left != null || root.right != null)
                res.add(root.val);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return res;
    }

    public void inorder(TreeNode root) {
        if(root != null) {
            if(root.left == null && root.right == null)
                res.add(root.val);

            if(root.left != null)
                inorder(root.left);

            if(root.left != null || root.right != null)
                res.add(root.val);

            if(root.right != null)
                inorder(root.right);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        levelOrderTraversal(root, 0);
        return r;
    }

    public void levelOrderTraversal(TreeNode root, int height) {
        if(root != null) {
            List<Integer> l = new ArrayList<>();

            if(r.size() == 0) {
                l.add(root.val);
                r.add(l);
            } else {
                if(r.size() > height) {
                    l = new ArrayList<>(r.get(height));
                    l.add(root.val);
                    r.remove(height);
                    r.add(height, l);
                } else {
                    l.add(root.val);
                    r.add(l);
                }
            }

            if(root.left != null)
                levelOrderTraversal(root.left, height + 1);

            if(root.right != null)
                levelOrderTraversal(root.right, height + 1);
        }
    }
}

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
