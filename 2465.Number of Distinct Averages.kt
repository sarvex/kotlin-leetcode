import java.util.*

internal class Solution {
  fun distinctAverages(nums: IntArray): Int {
    Arrays.sort(nums)
    val s: Set<Int> = HashSet()
    val n = nums.size
    for (i in 0 until (n shr 1)) {
      s.add(nums[i] + nums[n - i - 1])
    }
    return s.size()
  }
}
