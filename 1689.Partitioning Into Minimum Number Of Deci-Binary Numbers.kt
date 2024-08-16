internal class Solution {
  fun minPartitions(n: String): Int {
    var ans = 0
    for (i in 0 until n.length) {
      ans = max(ans, n[i].code - '0'.code)
    }
    return ans
  }
}
