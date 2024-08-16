internal class Solution {
  fun getLastMoment(n: Int, left: IntArray, right: IntArray): Int {
    var ans = 0
    for (x in left) {
      ans = max(ans, x)
    }
    for (x in right) {
      ans = max(ans, n - x)
    }
    return ans
  }
}
