internal class Solution {
  fun minOrAfterOperations(nums: IntArray, k: Int): Int {
    var ans = 0
    var rans = 0
    for (i in 29 downTo 0) {
      val test = ans + (1 shl i)
      var cnt = 0
      var `val` = 0
      for (num in nums) {
        `val` = if (`val` == 0) {
          test and num
        } else {
          `val` and (test and num)
        }
        if (`val` != 0) {
          cnt++
        }
      }
      if (cnt > k) {
        rans += (1 shl i)
      } else {
        ans += (1 shl i)
      }
    }
    return rans
  }
}
