internal class Solution {
  fun minimumDeletions(nums: IntArray): Int {
    var mi = 0
    var mx = 0
    val n = nums.size
    for (i in 0 until n) {
      if (nums[i] < nums[mi]) {
        mi = i
      }
      if (nums[i] > nums[mx]) {
        mx = i
      }
    }
    if (mi > mx) {
      val t = mx
      mx = mi
      mi = t
    }
    return min(min(mx + 1, n - mi), mi + 1 + n - mx)
  }
}
