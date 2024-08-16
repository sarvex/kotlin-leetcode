internal class Solution {
  fun passThePillow(n: Int, time: Int): Int {
    var time = time
    var ans = 1
    var k = 1
    while (time-- > 0) {
      ans += k
      if (ans == 1 || ans == n) {
        k *= -1
      }
    }
    return ans
  }
}
