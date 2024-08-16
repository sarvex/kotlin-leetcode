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

  fun connected(a: Int, b: Int): Boolean {
    return find(a) == find(b)
  }
}

internal class Solution {
  fun minimumEffortPath(heights: Array<IntArray>): Int {
    val m = heights.size
    val n = heights[0].size
    val uf = UnionFind(m * n)
    val edges: List<IntArray> = ArrayList()
    val dirs = intArrayOf(1, 0, 1)
    for (i in 0 until m) {
      for (j in 0 until n) {
        for (k in 0..1) {
          val x: Int = i + dirs[k]
          val y: Int = j + dirs[k + 1]
          if (x >= 0 && x < m && y >= 0 && y < n) {
            val d: Int = abs(heights[i][j] - heights[x][y])
            edges.add(intArrayOf(d, i * n + j, x * n + y))
          }
        }
      }
    }
    Collections.sort(edges) { a, b -> a.get(0) - b.get(0) }
    for (e in edges) {
      uf.union(e[1], e[2])
      if (uf.connected(0, m * n - 1)) {
        return e[0]
      }
    }
    return 0
  }
}
