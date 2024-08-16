import java.util.*

internal class Solution {
  fun triangleType(nums: IntArray): String {
    Arrays.sort(nums)
    if (nums[0] + nums[1] <= nums[2]) {
      return "none"
    }
    if (nums[0] == nums[2]) {
      return "equilateral"
    }
    if (nums[0] == nums[1] || nums[1] == nums[2]) {
      return "isosceles"
    }
    return "scalene"
  }
}
