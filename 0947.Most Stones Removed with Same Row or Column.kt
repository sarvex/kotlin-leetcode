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
  fun removeStones(stones: Array<IntArray>): Int {
    val n = stones.size
    val uf = UnionFind(n)
    var ans = 0
    for (i in 0 until n) {
      for (j in 0 until i) {
        if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
          ans += if (uf.union(i, j)) 1 else 0
        }
      }
    }
    return ans
  }
}
