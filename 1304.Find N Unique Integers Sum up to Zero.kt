internal class Solution {
  fun sumZero(n: Int): IntArray {
    val ans = IntArray(n)
    var i = 1
    var j = 0
    while (i <= n / 2) {
      ans[j++] = i
      ans[j++] = -i
      ++i
    }
    return ans
  }
}
