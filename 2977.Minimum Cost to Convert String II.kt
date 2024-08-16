import java.util.*

internal open class Node {
  var children: Array<Node> = arrayOfNulls(26)
  var v: Int = -1
}

internal class Solution {
  private val inf = 1L shl 60
  private val root = Node()
  private var idx = 0

  private var g: Array<LongArray>
  private var s: CharArray
  private var t: CharArray
  private var f: Array<Long>

  fun minimumCost(
    source: String, target: String, original: Array<String>, changed: Array<String>, cost: IntArray
  ): Long {
    val m = cost.size
    g = Array(m shl 1) { LongArray(m shl 1) }
    s = source.toCharArray()
    t = target.toCharArray()
    for (i in g.indices) {
      Arrays.fill(g[i], inf)
      g[i][i] = 0
    }
    for (i in 0 until m) {
      val x = insert(original[i])
      val y = insert(changed[i])
      g[x][y] = min(g[x][y], cost[i])
    }
    for (k in 0 until idx) {
      for (i in 0 until idx) {
        if (g[i][k] >= inf) {
          continue
        }
        for (j in 0 until idx) {
          g[i][j] = min(g[i][j], g[i][k] + g[k][j])
        }
      }
    }
    f = arrayOfNulls(s.size)
    val ans = dfs(0)
    return if (ans >= inf) -1 else ans
  }

  private fun insert(w: String): Int {
    var node = root
    for (c in w.toCharArray()) {
      val i: Int = c.code - 'a'.code
      if (node.children.get(i) == null) {
        node.children.get(i) = Node()
      }
      node = node.children.get(i)
    }
    if (node.v < 0) {
      node.v = idx++
    }
    return node.v
  }

  private fun dfs(i: Int): Long {
    if (i >= s.size) {
      return 0
    }
    if (f[i] != null) {
      return f[i]
    }
    var res = if (s[i] == t[i]) dfs(i + 1) else inf
    var p = root
    var q = root
    for (j in i until s.size) {
      p = p.children.get(s[j].code - 'a'.code)
      q = q.children.get(t[j].code - 'a'.code)
      if (p == null || q == null) {
        break
      }
      if (p.v < 0 || q.v < 0) {
        continue
      }
      val t = g[p.v][q.v]
      if (t < inf) {
        res = min(res, t + dfs(j + 1))
      }
    }
    return res.also { f[i] = it }
  }
}
