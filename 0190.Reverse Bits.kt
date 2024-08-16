class Solution {
  // you need treat n as an unsigned value
  fun reverseBits(n: Int): Int {
    var n = n
    var ans = 0
    var i = 0
    while (i < 32 && n != 0) {
      ans = ans or ((n and 1) shl (31 - i))
      n = n ushr 1
      ++i
    }
    return ans
  }
}
