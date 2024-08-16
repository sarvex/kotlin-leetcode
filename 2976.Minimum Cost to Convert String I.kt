import java.util.*

internal class Solution {
  fun minimumCost(
    source: String, target: String, original: CharArray, changed: CharArray, cost: IntArray
  ): Long {
    val inf = 1 shl 29
    val g = Array(26) { IntArray(26) }
    for (i in 0..25) {
      Arrays.fill(g[i], inf)
      g[i][i] = 0
    }
    for (i in original.indices) {
      val x: Int = original[i].code - 'a'.code
      val y: Int = changed[i].code - 'a'.code
      val z = cost[i]
      g[x][y] = min(g[x][y], z)
    }
    for (k in 0..25) {
      for (i in 0..25) {
        for (j in 0..25) {
          g[i][j] = min(g[i][j], g[i][k] + g[k][j])
        }
      }
    }
    var ans: Long = 0
    val n = source.length
    for (i in 0 until n) {
      val x: Int = source[i].code - 'a'.code
      val y: Int = target[i].code - 'a'.code
      if (x != y) {
        if (g[x][y] >= inf) {
          return -1
        }
        ans += g[x][y].toLong()
      }
    }
    return ans
  }
}
