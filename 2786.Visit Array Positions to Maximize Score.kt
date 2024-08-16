import java.util.*

internal class Solution {
  fun maxScore(nums: IntArray, x: Int): Long {
    val f = LongArray(2)
    Arrays.fill(f, -(1L shl 60))
    f[nums[0] and 1] = nums[0].toLong()
    for (i in 1 until nums.size) {
      val v = nums[i]
      f[v and 1] = max(f[v and 1], f[v and 1 xor 1] - x) + v
    }
    return max(f[0], f[1])
  }
}
