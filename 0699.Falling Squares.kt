internal open class Node(var l: Int, var r: Int) {
  var left: Node? = null
  var right: Node? = null
  var mid: Int = (l + r) shr 1
  var v: Int = 0
  var add: Int = 0
}

internal class SegmentTree {
  private val root = Node(1, 1e9.toInt())

  @kotlin.jvm.JvmOverloads
  fun modify(l: Int, r: Int, v: Int, node: Node = root) {
    if (l > r) {
      return
    }
    if (node.l >= l && node.r <= r) {
      node.v = v
      node.add = v
      return
    }
    pushdown(node)
    if (l <= node.mid) {
      modify(l, r, v, node.left)
    }
    if (r > node.mid) {
      modify(l, r, v, node.right)
    }
    pushup(node)
  }

  @kotlin.jvm.JvmOverloads
  fun query(l: Int, r: Int, node: Node = root): Int {
    if (l > r) {
      return 0
    }
    if (node.l >= l && node.r <= r) {
      return node.v
    }
    pushdown(node)
    var v = 0
    if (l <= node.mid) {
      v = max(v, query(l, r, node.left))
    }
    if (r > node.mid) {
      v = max(v, query(l, r, node.right))
    }
    return v
  }

  fun pushup(node: Node) {
    node.v = max(node.left.v, node.right.v)
  }

  fun pushdown(node: Node) {
    if (node.left == null) {
      node.left = Node(node.l, node.mid)
    }
    if (node.right == null) {
      node.right = Node(node.mid + 1, node.r)
    }
    if (node.add != 0) {
      val left: Node = node.left
      val right: Node = node.right
      left.add = node.add
      right.add = node.add
      left.v = node.add
      right.v = node.add
      node.add = 0
    }
  }
}

internal class Solution {
  fun fallingSquares(positions: Array<IntArray>): List<Int> {
    val ans: List<Int> = ArrayList()
    val tree = SegmentTree()
    var mx = 0
    for (p in positions) {
      val l = p[0]
      val w = p[1]
      val r = l + w - 1
      val h = tree.query(l, r) + w
      mx = max(mx, h)
      ans.add(mx)
      tree.modify(l, r, h)
    }
    return ans
  }
}
