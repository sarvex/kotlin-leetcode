internal class UnionFind(n: Int) {
  @kotlin.jvm.JvmField
  var p: IntArray = IntArray(n)

  init {
    for (i in 0 until n) {
      p[i] = i
    }
  }

  fun union(a: Int, b: Int) {
    val pa = find(a)
    val pb = find(b)
    if (pa != pb) {
      p[pa] = pb
    }
  }

  fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }
}

internal class Solution {
  fun largestComponentSize(nums: IntArray): Int {
    var m = 0
    for (v in nums) {
      m = max(m, v)
    }
    val uf = UnionFind(m + 1)
    for (v in nums) {
      var i = 2
      while (i <= v / i) {
        if (v % i == 0) {
          uf.union(v, i)
          uf.union(v, v / i)
        }
        ++i
      }
    }
    val cnt = IntArray(m + 1)
    var ans = 0
    for (v in nums) {
      val t = uf.find(v)
      ++cnt[t]
      ans = max(ans, cnt[t])
    }
    return ans
  }
}
