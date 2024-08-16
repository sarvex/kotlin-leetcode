internal class Solution {
  fun maximumLength(nums: IntArray, k: Int): Int {
    val n = nums.size
    val f = Array(n) { IntArray(k + 1) }
    var ans = 0
    for (i in 0 until n) {
      for (h in 0..k) {
        for (j in 0 until i) {
          if (nums[i] == nums[j]) {
            f[i][h] = max(f[i][h], f[j][h])
          } else if (h > 0) {
            f[i][h] = max(f[i][h], f[j][h - 1])
          }
        }
        ++f[i][h]
      }
      ans = max(ans, f[i][k])
    }
    return ans
  }
}
