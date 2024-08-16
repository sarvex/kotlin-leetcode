import java.util.*

internal class Solution {
  fun divideArray(nums: IntArray, k: Int): Array<IntArray> {
    Arrays.sort(nums)
    val n = nums.size
    val ans: Array<IntArray> = arrayOfNulls(n / 3)
    var i = 0
    while (i < n) {
      val t = Arrays.copyOfRange(nums, i, i + 3)
      if (t[2] - t[0] > k) {
        return arrayOf()
      }
      ans[i / 3] = t
      i += 3
    }
    return ans
  }
}
