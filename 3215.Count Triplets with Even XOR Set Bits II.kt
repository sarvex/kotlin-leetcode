internal class Solution {
  fun tripletCount(a: IntArray, b: IntArray, c: IntArray): Long {
    val cnt1 = IntArray(2)
    val cnt2 = IntArray(2)
    val cnt3 = IntArray(2)
    for (x in a) {
      ++cnt1[Integer.bitCount(x) and 1]
    }
    for (x in b) {
      ++cnt2[Integer.bitCount(x) and 1]
    }
    for (x in c) {
      ++cnt3[Integer.bitCount(x) and 1]
    }
    var ans: Long = 0
    for (i in 0..1) {
      for (j in 0..1) {
        for (k in 0..1) {
          if ((i + j + k) % 2 == 0) {
            ans += 1L * cnt1[i] * cnt2[j] * cnt3[k]
          }
        }
      }
    }
    return ans
  }
}
