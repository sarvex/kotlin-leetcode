internal class Solution {
  fun decrypt(code: IntArray, k: Int): IntArray {
    val n = code.size
    val ans = IntArray(n)
    if (k == 0) {
      return ans
    }
    for (i in 0 until n) {
      if (k > 0) {
        for (j in i + 1 until i + k + 1) {
          ans[i] += code[j % n]
        }
      } else {
        for (j in i + k until i) {
          ans[i] += code[(j + n) % n]
        }
      }
    }
    return ans
  }
}
