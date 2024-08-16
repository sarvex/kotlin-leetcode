import java.util.*

internal class Solution {
  fun maxScore(nums1: IntArray, nums2: IntArray, k: Int): Long {
    val n = nums1.size
    val nums = Array(n) { IntArray(2) }
    for (i in 0 until n) {
      nums[i] = intArrayOf(nums1[i], nums2[i])
    }
    Arrays.sort(nums) { a, b -> b[1] - a[1] }
    var ans: Long = 0
    var s: Long = 0
    val q: PriorityQueue<Int> = PriorityQueue()
    for (i in 0 until n) {
      s += nums[i][0].toLong()
      q.offer(nums[i][0])
      if (q.size() === k) {
        ans = max(ans, s * nums[i][1])
        s -= q.poll()
      }
    }
    return ans
  }
}
