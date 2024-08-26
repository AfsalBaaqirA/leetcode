public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        push(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        push(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void push(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}