internal class Solution {
  fun minimumXORSum(nums1: IntArray, nums2: IntArray): Int {
    val n = nums1.size
    val f = Array(n + 1) { IntArray(1 shl n) }
    for (g in f) {
      Arrays.fill(g, 1 shl 30)
    }
    f[0][0] = 0
    for (i in 1..n) {
      for (j in 0 until (1 shl n)) {
        for (k in 0 until n) {
          if ((j shr k and 1) == 1) {
            f[i][j]
            = min(f[i][j], f[i - 1][j xor (1 shl k)] + (nums1[i - 1] xor nums2[k]))
          }
        }
      }
    }
    return f[n][(1 shl n) - 1]
  }
}
