internal class Solution {
  fun maxCoins(nums: IntArray): Int {
    val n = nums.size
    val arr = IntArray(n + 2)
    arr[0] = 1
    arr[n + 1] = 1
    System.arraycopy(nums, 0, arr, 1, n)
    val f = Array(n + 2) { IntArray(n + 2) }
    for (i in n - 1 downTo 0) {
      for (j in i + 2..(n + 1)) {
        for (k in i + 1 until j) {
          f[i][j] = max(f[i][j], f[i][k] + f[k][j] + arr[i] * arr[k] * arr[j])
        }
      }
    }
    return f[0][n + 1]
  }
}
