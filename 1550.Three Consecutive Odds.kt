internal class Solution {
  fun threeConsecutiveOdds(arr: IntArray): Boolean {
    var cnt = 0
    for (x in arr) {
      if (x % 2 == 1) {
        if (++cnt == 3) {
          return true
        }
      } else {
        cnt = 0
      }
    }
    return false
  }
}
