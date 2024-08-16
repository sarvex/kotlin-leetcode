internal class Solution {
  fun minCost(colors: String, neededTime: IntArray): Int {
    var ans = 0
    val n = neededTime.size
    var i = 0
    var j = 0
    while (i < n) {
      j = i
      var s = 0
      var mx = 0
      while (j < n && colors[j] == colors[i]) {
        s += neededTime[j]
        mx = max(mx, neededTime[j])
        ++j
      }
      if (j - i > 1) {
        ans += s - mx
      }
      i = j
    }
    return ans
  }
}
