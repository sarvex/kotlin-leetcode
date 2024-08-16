internal class Solution {
  fun maxUncrossedLines(nums1: IntArray, nums2: IntArray): Int {
    val m = nums1.size
    val n = nums2.size
    val f = Array(m + 1) { IntArray(n + 1) }
    for (i in 1..m) {
      for (j in 1..n) {
        if (nums1[i - 1] == nums2[j - 1]) {
          f[i][j] = f[i - 1][j - 1] + 1
        } else {
          f[i][j] = max(f[i - 1][j], f[i][j - 1])
        }
      }
    }
    return f[m][n]
  }
}
