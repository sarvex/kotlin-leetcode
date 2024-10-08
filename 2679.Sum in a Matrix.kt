import java.util.*

internal class Solution {
  fun matrixSum(nums: Array<IntArray>): Int {
    for (row in nums) {
      Arrays.sort(row)
    }
    var ans = 0
    for (j in nums[0].indices) {
      var mx = 0
      for (row in nums) {
        mx = max(mx, row[j])
      }
      ans += mx
    }
    return ans
  }
}
