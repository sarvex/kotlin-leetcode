internal class Solution {
  fun maximumBeauty(flowers: IntArray): Int {
    val n = flowers.size
    val s = IntArray(n + 1)
    val d: Map<Int, Int> = HashMap()
    var ans: Int = MIN_VALUE
    for (i in 0 until n) {
      val v = flowers[i]
      if (d.containsKey(v)) {
        ans = max(ans, s[i] - s[d[v]!! + 1] + v * 2)
      } else {
        d.put(v, i)
      }
      s[i + 1] = s[i] + max(v, 0)
    }
    return ans
  }
}
