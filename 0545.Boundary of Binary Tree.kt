internal class Solution {
  fun boundaryOfBinaryTree(root: TreeNode): List<Int> {
    val ans: List<Int> = ArrayList()
    ans.add(root.`val`)
    if (root.left === root.right) {
      return ans
    }
    val left: List<Int> = ArrayList()
    val leaves: List<Int> = ArrayList()
    val right: List<Int> = ArrayList()
    dfs(left, root.left, 0)
    dfs(leaves, root, 1)
    dfs(right, root.right, 2)

    ans.addAll(left)
    ans.addAll(leaves)
    Collections.reverse(right)
    ans.addAll(right)
    return ans
  }

  private fun dfs(nums: List<Int>, root: TreeNode?, i: Int) {
    if (root == null) {
      return
    }
    if (i == 0) {
      if (root.left !== root.right) {
        nums.add(root.`val`)
        if (root.left != null) {
          dfs(nums, root.left, i)
        } else {
          dfs(nums, root.right, i)
        }
      }
    } else if (i == 1) {
      if (root.left === root.right) {
        nums.add(root.`val`)
      } else {
        dfs(nums, root.left, i)
        dfs(nums, root.right, i)
      }
    } else {
      if (root.left !== root.right) {
        nums.add(root.`val`)
        if (root.right != null) {
          dfs(nums, root.right, i)
        } else {
          dfs(nums, root.left, i)
        }
      }
    }
  }
}
