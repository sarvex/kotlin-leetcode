internal class Solution {
  fun concatenatedBinary(n: Int): Int {
    val mod = 1e9.toInt() + 7
    var ans: Long = 0
    for (i in 1..n) {
      ans = (ans shl (32 - Integer.numberOfLeadingZeros(i)) or i.toLong()) % mod
    }
    return ans.toInt()
  }
}
