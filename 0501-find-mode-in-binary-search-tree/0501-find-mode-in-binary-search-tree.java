/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count = 0;
    int maxCount = 0;
    Integer prev = null;
    List<Integer> ans = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inorder(root);

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        if (prev == null || prev != node.val) {
            count = 1;
        } else {
            count++;
        }

        if (count > maxCount) {
            maxCount = count;
            ans.clear();
            ans.add(node.val);
        } else if (count == maxCount) {
            ans.add(node.val);
        }

        prev = node.val;

        inorder(node.right);
    }
}