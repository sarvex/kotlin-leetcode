internal open class Node(var l: Int, var r: Int) {
  var lmx: Int
  var rmx: Int
  var mx: Int = 1

  init {
    rmx = mx
    lmx = rmx
  }
}

internal class SegmentTree(s: CharArray) {
  private val s: CharArray
  private val tr: Array<Node>

  init {
    val n = s.size
    this.s = s
    tr = arrayOfNulls(n shl 2)
    build(1, 1, n)
  }

  fun build(u: Int, l: Int, r: Int) {
    tr[u] = Node(l.toChar(), r)
    if (l == r) {
      return
    }
    val mid = (l + r) shr 1
    build(u shl 1, l, mid)
    build(u shl 1 or 1, mid + 1, r)
    pushup(u)
  }

  fun modify(u: Int, x: Int, v: Char) {
    if (tr[u].l == x && tr[u].r == x) {
      s[x - 1] = v
      return
    }
    val mid: Int = (tr[u].l + tr[u].r) shr 1
    if (x <= mid) {
      modify(u shl 1, x, v)
    } else {
      modify(u shl 1 or 1, x, v)
    }
    pushup(u)
  }

  fun query(u: Int, l: Int, r: Int): Int {
    if (tr[u].l >= l && tr[u].r <= r) {
      return tr[u].mx
    }
    val mid: Int = (tr[u].l + tr[u].r) shr 1
    var ans = 0
    if (r <= mid) {
      ans = query(u shl 1, l, r)
    }
    if (l > mid) {
      ans = max(ans, query(u shl 1 or 1, l, r))
    }
    return ans
  }

  private fun pushup(u: Int) {
    val root = tr[u]
    val left = tr[u shl 1]
    val right = tr[u shl 1 or 1]
    root.mx = max(left.mx, right.mx)
    root.lmx = left.lmx
    root.rmx = right.rmx
    val a: Int = left.r - left.l + 1
    val b: Int = right.r - right.l + 1
    if (s[left.r - 1] == s[right.l - 1]) {
      if (left.lmx == a) {
        root.lmx += right.lmx
      }
      if (right.rmx == b) {
        root.rmx += left.rmx
      }
      root.mx = max(root.mx, left.rmx + right.lmx)
    }
  }
}

internal class Solution {
  fun longestRepeating(s: String, queryCharacters: String, queryIndices: IntArray): IntArray {
    val tree = SegmentTree(s.toCharArray())
    val k = queryIndices.size
    val ans = IntArray(k)
    val n = s.length
    for (i in 0 until k) {
      val x = queryIndices[i] + 1
      val v = queryCharacters[i]
      tree.modify(1, x, v.code)
      ans[i] = tree.query(1, 1, n)
    }
    return ans
  }
}
