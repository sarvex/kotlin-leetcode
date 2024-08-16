import java.util.*

internal class Solution {
  fun minimalKSum(nums: IntArray, k: Int): Long {
    var k = k
    val n = nums.size
    val arr = IntArray(n + 2)
    arr[1] = 2 * 1000000000
    System.arraycopy(nums, 0, arr, 2, n)
    Arrays.sort(arr)
    var ans: Long = 0
    var i = 0
    while (i < n + 1 && k > 0) {
      val m: Int = max(0, min(k, arr[i + 1] - arr[i] - 1))
      ans += (arr[i] + 1L + arr[i] + m) * m / 2
      k -= m
      ++i
    }
    return ans
  }
}
