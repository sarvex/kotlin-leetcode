internal class Solution {
  private var p: IntArray
  private var size: IntArray

  fun findLatestStep(arr: IntArray, m: Int): Int {
    val n = arr.size
    if (m == n) {
      return n
    }
    val vis = BooleanArray(n)
    p = IntArray(n)
    size = IntArray(n)
    for (i in 0 until n) {
      p[i] = i
      size[i] = 1
    }
    var ans = -1
    for (i in 0 until n) {
      val v = arr[i] - 1
      if (v > 0 && vis[v - 1]) {
        if (size[find(v - 1)] == m) {
          ans = i
        }
        union(v, v - 1)
      }
      if (v < n - 1 && vis[v + 1]) {
        if (size[find(v + 1)] == m) {
          ans = i
        }
        union(v, v + 1)
      }
      vis[v] = true
    }
    return ans
  }

  private fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }

  private fun union(a: Int, b: Int) {
    val pa = find(a)
    val pb = find(b)
    if (pa == pb) {
      return
    }
    p[pa] = pb
    size[pb] += size[pa]
  }
}
