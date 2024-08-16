internal class Solution {
  fun countAlternatingSubarrays(nums: IntArray): Long {
    var ans: Long = 1
    var s: Long = 1
    for (i in 1 until nums.size) {
      s = if (nums[i] != nums[i - 1]) s + 1 else 1
      ans += s
    }
    return ans
  }
}
