import java.util.*

internal class Solution {
  fun lexicographicallySmallestArray(nums: IntArray, limit: Int): IntArray {
    val n = nums.size
    val idx: Array<Int> = arrayOfNulls(n)
    for (i in 0 until n) {
      idx[i] = i
    }
    Arrays.sort(idx) { i, j -> nums[i] - nums[j] }
    val ans = IntArray(n)
    var i = 0
    while (i < n) {
      var j = i + 1
      while (j < n && nums[idx[j]] - nums[idx[j - 1]] <= limit) {
        ++j
      }
      val t = Arrays.copyOfRange(idx, i, j)
      Arrays.sort(t) { x, y -> x - y }
      for (k in i until j) {
        ans[t[k - i]] = nums[idx[k]]
      }
      i = j
    }
    return ans
  }
}
