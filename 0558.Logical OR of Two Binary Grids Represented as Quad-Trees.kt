/*
// Definition for a QuadTree node.
class Node {
   public boolean val;
   public boolean isLeaf;
   public Node topLeft;
   public Node topRight;
   public Node bottomLeft;
   public Node bottomRight;

   public Node() {}

   public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node
_bottomRight) { val = _val; isLeaf = _isLeaf; topLeft = _topLeft; topRight = _topRight; bottomLeft =
_bottomLeft; bottomRight = _bottomRight;
   }
};
*/
internal class Solution {
  fun intersect(quadTree1: Node, quadTree2: Node): Node {
    return dfs(quadTree1, quadTree2)
  }

  private fun dfs(t1: Node, t2: Node): Node {
    if (t1.isLeaf && t2.isLeaf) {
      return Node((t1.`val` || t2.`val`).toInt(), true.toInt())
    }
    if (t1.isLeaf) {
      return if (t1.`val`) t1 else t2
    }
    if (t2.isLeaf) {
      return if (t2.`val`) t2 else t1
    }
    var res = Node()
    res.topLeft = dfs(t1.topLeft, t2.topLeft)
    res.topRight = dfs(t1.topRight, t2.topRight)
    res.bottomLeft = dfs(t1.bottomLeft, t2.bottomLeft)
    res.bottomRight = dfs(t1.bottomRight, t2.bottomRight)
    val isLeaf = res.topLeft.isLeaf && res.topRight.isLeaf && res.bottomLeft.isLeaf
        && res.bottomRight.isLeaf
    val sameVal =
      res.topLeft.`val` === res.topRight.`val` && res.topRight.`val` === res.bottomLeft.`val` && res.bottomLeft.`val` === res.bottomRight.`val`
    if (isLeaf && sameVal) {
      res = res.topLeft
    }
    return res
  }
}
