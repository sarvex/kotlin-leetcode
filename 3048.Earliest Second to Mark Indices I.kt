internal class Solution {
  private var nums: IntArray
  private var changeIndices: IntArray

  fun earliestSecondToMarkIndices(nums: IntArray, changeIndices: IntArray): Int {
    this.nums = nums
    this.changeIndices = changeIndices
    val m = changeIndices.size
    var l = 1
    var r = m + 1
    while (l < r) {
      val mid = (l + r) shr 1
      if (check(mid)) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return if (l > m) -1 else l
  }

  private fun check(t: Int): Boolean {
    val last = IntArray(nums.size + 1)
    for (s in 0 until t) {
      last[changeIndices[s]] = s
    }
    var decrement = 0
    var marked = 0
    for (s in 0 until t) {
      val i = changeIndices[s]
      if (last[i] == s) {
        if (decrement < nums[i - 1]) {
          return false
        }
        decrement -= nums[i - 1]
        ++marked
      } else {
        ++decrement
      }
    }
    return marked == nums.size
  }
}
