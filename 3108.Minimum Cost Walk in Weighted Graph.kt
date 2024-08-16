import java.util.*

internal class UnionFind(n: Int) {
  private val p = IntArray(n)
  private val size = IntArray(n)

  init {
    for (i in 0 until n) {
      p[i] = i
      size[i] = 1
    }
  }

  fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }

  fun union(a: Int, b: Int): Boolean {
    val pa = find(a)
    val pb = find(b)
    if (pa == pb) {
      return false
    }
    if (size[pa] > size[pb]) {
      p[pb] = pa
      size[pa] += size[pb]
    } else {
      p[pa] = pb
      size[pb] += size[pa]
    }
    return true
  }

  fun size(x: Int): Int {
    return size[find(x)]
  }
}

internal class Solution {
  private var uf: UnionFind? = null
  private var g: IntArray

  fun minimumCost(n: Int, edges: Array<IntArray>, query: Array<IntArray>): IntArray {
    uf = UnionFind(n)
    for (e in edges) {
      uf!!.union(e[0], e[1])
    }
    g = IntArray(n)
    Arrays.fill(g, -1)
    for (e in edges) {
      val root = uf!!.find(e[0])
      g[root] = g[root] and e[2]
    }
    val m = query.size
    val ans = IntArray(m)
    for (i in 0 until m) {
      val s = query[i][0]
      val t = query[i][1]
      ans[i] = f(s, t)
    }
    return ans
  }

  private fun f(u: Int, v: Int): Int {
    if (u == v) {
      return 0
    }
    val a = uf!!.find(u)
    val b = uf!!.find(v)
    return if (a == b) g[a] else -1
  }
}
