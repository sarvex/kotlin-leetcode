internal class Solution {
  private var p: IntArray

  fun minimumHammingDistance(source: IntArray, target: IntArray, allowedSwaps: Array<IntArray>): Int {
    val n = source.size
    p = IntArray(n)
    for (i in 0 until n) {
      p[i] = i
    }
    for (a in allowedSwaps) {
      p[find(a[0])] = find(a[1])
    }
    val cnt: Map<Int, Map<Int, Int>> = HashMap()
    for (i in 0 until n) {
      val j = find(i)
      cnt.computeIfAbsent(j) { k -> HashMap() }
        .merge(source[i], 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    var ans = 0
    for (i in 0 until n) {
      val j = find(i)
      val t = cnt[j]!!
      if (t.merge(target[i], -1) { a: Int, b: Int -> Integer.sum(a, b) } < 0) {
        ++ans
      }
    }
    return ans
  }

  private fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }
}
