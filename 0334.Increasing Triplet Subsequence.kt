internal class Solution {
  fun increasingTriplet(nums: IntArray): Boolean {
    val n = nums.size
    val lmi = IntArray(n)
    val rmx = IntArray(n)
    lmi[0] = MAX_VALUE
    rmx[n - 1] = MIN_VALUE
    for (i in 1 until n) {
      lmi[i] = min(lmi[i - 1], nums[i - 1])
    }
    for (i in n - 2 downTo 0) {
      rmx[i] = max(rmx[i + 1], nums[i + 1])
    }
    for (i in 0 until n) {
      if (lmi[i] < nums[i] && nums[i] < rmx[i]) {
        return true
      }
    }
    return false
  }
}
