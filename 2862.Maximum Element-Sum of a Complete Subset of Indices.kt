internal class Solution {
  fun maximumSum(nums: List<Int>): Long {
    var ans: Long = 0
    val n: Int = nums.size()
    val used = BooleanArray(n + 1)
    val bound = floor(sqrt(n)) as Int
    val squares = IntArray(bound + 1)
    for (i in 1..(bound + 1)) {
      squares[i - 1] = i * i
    }
    for (i in 1..n) {
      var res: Long = 0
      var idx = 0
      var curr = i * squares[idx]
      while (curr <= n) {
        res += nums[curr - 1]
        curr = i * squares[++idx]
      }
      ans = max(ans, res)
    }
    return ans
  }
}
