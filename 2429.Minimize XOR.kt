internal class Solution {
  fun minimizeXor(num1: Int, num2: Int): Int {
    var cnt = Integer.bitCount(num2)
    var x = 0
    run {
      var i = 30
      while (i >= 0 && cnt > 0) {
        if ((num1 shr i and 1) == 1) {
          x = x or (1 shl i)
          --cnt
        }
        --i
      }
    }
    var i = 0
    while (cnt > 0) {
      if ((num1 shr i and 1) == 0) {
        x = x or (1 shl i)
        --cnt
      }
      ++i
    }
    return x
  }
}
