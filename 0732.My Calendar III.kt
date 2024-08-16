internal open class Node(var l: Int, var r: Int) {
  @kotlin.jvm.JvmField
  var left: Node? = null
  @kotlin.jvm.JvmField
  var right: Node? = null
  @kotlin.jvm.JvmField
  var mid: Int = (l + r) shr 1
  @kotlin.jvm.JvmField
  var v: Int = 0
  @kotlin.jvm.JvmField
  var add: Int = 0
}

internal class SegmentTree {
  private val root = Node(1, 1e9.toInt() + 1)

  @kotlin.jvm.JvmOverloads
  fun modify(l: Int, r: Int, v: Int, node: Node = root) {
    if (l > r) {
      return
    }
    if (node.l >= l && node.r <= r) {
      node.v += v
      node.add += v
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
      left.add += node.add
      right.add += node.add
      left.v += node.add
      right.v += node.add
      node.add = 0
    }
  }
}

internal class MyCalendarThree {
  private val tree = SegmentTree()

  fun book(start: Int, end: Int): Int {
    tree.modify(start + 1, end, 1)
    return tree.query(1, 1e9.toInt() + 1)
  }
}
/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
