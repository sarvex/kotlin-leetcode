internal class Solution {
  fun minimumCosts(regular: IntArray, express: IntArray, expressCost: Int): LongArray {
    val n = regular.size
    val f = LongArray(n + 1)
    val g = LongArray(n + 1)
    g[0] = (1 shl 30).toLong()
    val cost = LongArray(n)
    for (i in 1..n) {
      val a = regular[i - 1]
      val b = express[i - 1]
      f[i] = min(f[i - 1] + a, g[i - 1] + a)
      g[i] = min(f[i - 1] + expressCost + b, g[i - 1] + b)
      cost[i - 1] = min(f[i], g[i])
    }
    return cost
  }
}
