import java.util.*
import kotlin.Array
import kotlin.Int
import kotlin.IntArray
import kotlin.intArrayOf

internal class Solution {
  fun minimumTime(nums1: List<Int>, nums2: List<Int>, x: Int): Int {
    val n: Int = nums1.size()
    val f = Array(n + 1) { IntArray(n + 1) }
    val nums = Array(n) { IntArray(0) }
    for (i in 0 until n) {
      nums[i] = intArrayOf(nums1[i], nums2[i])
    }
    Arrays.sort(nums, Comparator.comparingInt { a -> a.get(1) })
    for (i in 1..n) {
      for (j in 0..n) {
        f[i][j] = f[i - 1][j]
        if (j > 0) {
          val a = nums[i - 1][0]
          val b = nums[i - 1][1]
          f[i][j] = max(f[i][j], f[i - 1][j - 1] + a + b * j)
        }
      }
    }
    var s1 = 0
    var s2 = 0
    for (v in nums1) {
      s1 += v
    }
    for (v in nums2) {
      s2 += v
    }

    for (j in 0..n) {
      if (s1 + s2 * j - f[n][j] <= x) {
        return j
      }
    }
    return -1
  }
}
