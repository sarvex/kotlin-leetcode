import java.util.*

internal class Solution {
  fun maximizeSquareArea(m: Int, n: Int, hFences: IntArray, vFences: IntArray): Int {
    val hs = f(hFences, m)
    val vs = f(vFences, n)
    hs.retainAll(vs)
    var ans = -1
    val mod = 1e9.toInt() + 7
    for (x in hs) {
      ans = max(ans, x)
    }
    return if (ans > 0) (1L * ans * ans % mod).toInt() else -1
  }

  private fun f(nums: IntArray, k: Int): Set<Int> {
    var nums = nums
    val n = nums.size
    nums = Arrays.copyOf(nums, n + 2)
    nums[n] = 1
    nums[n + 1] = k
    Arrays.sort(nums)
    val s: Set<Int> = HashSet()
    for (i in nums.indices) {
      for (j in 0 until i) {
        s.add(nums[i] - nums[j])
      }
    }
    return s
  }
}
