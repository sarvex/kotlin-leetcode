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
}

internal class Solution {
  fun numSimilarGroups(strs: Array<String>): Int {
    val n = strs.size
    val m = strs[0].length
    val uf = UnionFind(n)
    var cnt = n
    for (i in 0 until n) {
      for (j in 0 until i) {
        var diff = 0
        for (k in 0 until m) {
          if (strs[i][k] != strs[j][k]) {
            ++diff
          }
        }
        if (diff <= 2 && uf.union(i, j)) {
          --cnt
        }
      }
    }
    return cnt
  }
}
