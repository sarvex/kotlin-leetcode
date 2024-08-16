import java.util.*

internal class Solution {
  fun unmarkedSumArray(nums: IntArray, queries: Array<IntArray>): LongArray {
    val n = nums.size
    var s = Arrays.stream(nums).asLongStream().sum()
    val mark = BooleanArray(n)
    val arr = Array(n) { IntArray(0) }
    for (i in 0 until n) {
      arr[i] = intArrayOf(nums[i], i)
    }
    Arrays.sort(arr) { a, b -> if (a[0] === b[0]) a[1] - b[1] else a[0] - b[0] }
    val m = queries.size
    val ans = LongArray(m)
    var i = 0
    var j = 0
    while (i < m) {
      val index = queries[i][0]
      var k = queries[i][1]
      if (!mark[index]) {
        mark[index] = true
        s -= nums[index].toLong()
      }
      while (k > 0 && j < n) {
        if (!mark[arr[j][1]]) {
          mark[arr[j][1]] = true
          s -= arr[j][0].toLong()
          --k
        }
        ++j
      }
      ans[i] = s
      ++i
    }
    return ans
  }
}
