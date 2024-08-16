internal class Solution {
  fun findThePrefixCommonArray(A: IntArray, B: IntArray): IntArray {
    val n = A.size
    val ans = IntArray(n)
    val cnt1 = IntArray(n + 1)
    val cnt2 = IntArray(n + 1)
    for (i in 0 until n) {
      ++cnt1[A[i]]
      ++cnt2[B[i]]
      for (j in 1..n) {
        ans[i] += min(cnt1[j], cnt2[j])
      }
    }
    return ans
  }
}
