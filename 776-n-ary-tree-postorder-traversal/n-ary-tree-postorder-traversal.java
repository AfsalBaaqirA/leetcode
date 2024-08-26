class Solution {
    private List<Integer> result;
    public List<Integer> postorder(Node root) {
        result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        helper(root);
        return result;
    }

    private void helper(Node currentNode) {
        if (currentNode == null) {
            return;
        }
        
        for (Node childNode : currentNode.children) {
            helper(childNode);
        }
        result.add(currentNode.val);
    }
}