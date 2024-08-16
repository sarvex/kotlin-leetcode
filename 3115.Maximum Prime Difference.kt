internal class Solution {
  fun maximumPrimeDifference(nums: IntArray): Int {
    var i = 0
    while (true) {
      if (isPrime(nums[i])) {
        var j = nums.size - 1
        while (true) {
          if (isPrime(nums[j])) {
            return j - i
          }
          --j
        }
      }
      ++i
    }
  }

  private fun isPrime(x: Int): Boolean {
    if (x < 2) {
      return false
    }
    var v = 2
    while (v * v <= x) {
      if (x % v == 0) {
        return false
      }
      ++v
    }
    return true
  }
}
