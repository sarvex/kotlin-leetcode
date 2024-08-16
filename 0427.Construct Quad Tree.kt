/*
// Definition for a QuadTree node.
class Node {
   public boolean val;
   public boolean isLeaf;
   public Node topLeft;
   public Node topRight;
   public Node bottomLeft;
   public Node bottomRight;


   public Node() {
       this.val = false;
       this.isLeaf = false;
       this.topLeft = null;
       this.topRight = null;
       this.bottomLeft = null;
       this.bottomRight = null;
   }

   public Node(boolean val, boolean isLeaf) {
       this.val = val;
       this.isLeaf = isLeaf;
       this.topLeft = null;
       this.topRight = null;
       this.bottomLeft = null;
       this.bottomRight = null;
   }

   public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node
bottomRight) { this.val = val; this.isLeaf = isLeaf; this.topLeft = topLeft; this.topRight =
topRight; this.bottomLeft = bottomLeft; this.bottomRight = bottomRight;
   }
};
*/
internal class Solution {
  fun construct(grid: Array<IntArray>): Node {
    return dfs(0, 0, grid.size - 1, grid[0].size - 1, grid)
  }

  private fun dfs(a: Int, b: Int, c: Int, d: Int, grid: Array<IntArray>): Node {
    var zero = 0
    var one = 0
    for (i in a..c) {
      for (j in b..d) {
        if (grid[i][j] == 0) {
          zero = 1
        } else {
          one = 1
        }
      }
    }
    val isLeaf = zero + one == 1
    val `val` = isLeaf && one == 1
    val node = Node(`val`.toInt(), isLeaf.toInt())
    if (isLeaf) {
      return node
    }
    node.topLeft = dfs(a, b, (a + c) / 2, (b + d) / 2, grid)
    node.topRight = dfs(a, (b + d) / 2 + 1, (a + c) / 2, d, grid)
    node.bottomLeft = dfs((a + c) / 2 + 1, b, c, (b + d) / 2, grid)
    node.bottomRight = dfs((a + c) / 2 + 1, (b + d) / 2 + 1, c, d, grid)
    return node
  }
}
