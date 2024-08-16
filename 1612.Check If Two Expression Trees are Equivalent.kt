/**
 * Definition for a binary tree node.
 * class Node {
 * char val;
 * Node left;
 * Node right;
 * Node() {this.val = ' ';}
 * Node(char val) { this.val = val; }
 * Node(char val, Node left, Node right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
internal class Solution {
  private val cnt = IntArray(26)

  fun checkEquivalence(root1: Node?, root2: Node?): Boolean {
    dfs(root1, 1)
    dfs(root2, -1)
    for (x in cnt) {
      if (x != 0) {
        return false
      }
    }
    return true
  }

  private fun dfs(root: Node?, v: Int) {
    if (root == null) {
      return
    }
    if (root.`val` !== '+') {
      cnt[root.`val` - 'a'] += v
    }
    dfs(root.left, v)
    dfs(root.right, v)
  }
}
