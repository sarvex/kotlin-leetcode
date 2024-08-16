import java.util.*

internal class Solution {
  fun maximumLength(nums: IntArray, k: Int): Int {
    val n = nums.size
    val f = Array(n) { IntArray(k + 1) }
    val mp: Array<Map<Int, Int>> = arrayOfNulls(k + 1)
    Arrays.setAll(mp) { i -> HashMap() }
    val g = Array(k + 1) { IntArray(3) }
    var ans = 0
    for (i in 0 until n) {
      for (h in 0..k) {
        f[i][h] = mp[h].getOrDefault(nums[i], 0)
        if (h > 0) {
          if (g[h - 1][0] != nums[i]) {
            f[i][h] = max(f[i][h], g[h - 1][1])
          } else {
            f[i][h] = max(f[i][h], g[h - 1][2])
          }
        }
        ++f[i][h]
        mp[h].merge(nums[i], f[i][h]) { a: Int, b: Int -> Integer.max(a, b) }
        if (g[h][0] != nums[i]) {
          if (f[i][h] >= g[h][1]) {
            g[h][2] = g[h][1]
            g[h][1] = f[i][h]
            g[h][0] = nums[i]
          } else {
            g[h][2] = max(g[h][2], f[i][h])
          }
        } else {
          g[h][1] = max(g[h][1], f[i][h])
        }
        ans = max(ans, f[i][h])
      }
    }
    return ans
  }
}
