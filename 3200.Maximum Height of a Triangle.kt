internal class Solution {
  fun maxHeightOfTriangle(red: Int, blue: Int): Int {
    var ans = 0
    for (k in 0..1) {
      val c = intArrayOf(red, blue)
      var i = 1
      var j = k
      while (i <= c[j]) {
        c[j] -= i
        ans = max(ans, i)
        j = j xor 1
        ++i
      }
    }
    return ans
  }
}
