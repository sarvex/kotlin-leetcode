internal class Solution {
  fun numTeams(rating: IntArray): Int {
    val n = rating.size
    var ans = 0
    for (i in 0 until n) {
      var l = 0
      var r = 0
      for (j in 0 until i) {
        if (rating[j] < rating[i]) {
          ++l
        }
      }
      for (j in i + 1 until n) {
        if (rating[j] > rating[i]) {
          ++r
        }
      }
      ans += l * r
      ans += (i - l) * (n - i - 1 - r)
    }
    return ans
  }
}
