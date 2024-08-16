internal class Solution {
  fun countBits(n: Int): IntArray {
    val ans = IntArray(n + 1)
    for (i in 0..n) {
      ans[i] = Integer.bitCount(i)
    }
    return ans
  }
}
