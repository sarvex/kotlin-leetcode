import java.util.*

internal class Solution {
  fun countSubarrays(nums: IntArray, k: Int): Long {
    val mx = Arrays.stream(nums).max().asInt
    val n = nums.size
    var ans: Long = 0
    var cnt = 0
    var j = 0
    for (x in nums) {
      while (j < n && cnt < k) {
        cnt += if (nums[j++] == mx) 1 else 0
      }
      if (cnt < k) {
        break
      }
      ans += (n - j + 1).toLong()
      cnt -= if (x == mx) 1 else 0
    }
    return ans
  }
}
