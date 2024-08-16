internal class UnionFind(n: Int) {
  private val p = IntArray(n)
  val size: IntArray = IntArray(n)

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
}

internal class Solution {
  fun numIslands2(m: Int, n: Int, positions: Array<IntArray>): List<Int> {
    val grid = Array(m) { IntArray(n) }
    val uf = UnionFind(m * n)
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    var cnt = 0
    val ans: List<Int> = ArrayList()
    for (p in positions) {
      val i = p[0]
      val j = p[1]
      if (grid[i][j] == 1) {
        ans.add(cnt)
        continue
      }
      grid[i][j] = 1
      ++cnt
      for (k in 0..3) {
        val x = i + dirs[k]
        val y = j + dirs[k + 1]
        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1 && uf.union(i * n + j, x * n + y)) {
          --cnt
        }
      }
      ans.add(cnt)
    }
    return ans
  }
}
