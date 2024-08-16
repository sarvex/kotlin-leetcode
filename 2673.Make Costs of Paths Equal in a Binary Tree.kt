internal class Solution {
  fun minIncrements(n: Int, cost: IntArray): Int {
    var ans = 0
    for (i in n shr 1 downTo 1) {
      val l: Int = i shl 1
      val r: Int = i shl 1 or 1
      ans += abs(cost[l - 1] - cost[r - 1])
      cost[i - 1] += max(cost[l - 1], cost[r - 1])
    }
    return ans
  }
}
