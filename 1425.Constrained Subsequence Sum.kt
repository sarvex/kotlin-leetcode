internal class Solution {
  fun constrainedSubsetSum(nums: IntArray, k: Int): Int {
    val n = nums.size
    val dp = IntArray(n)
    var ans: Int = MIN_VALUE
    val q: Deque<Int> = ArrayDeque()
    for (i in 0 until n) {
      if (!q.isEmpty() && i - q.peek() > k) {
        q.poll()
      }
      dp[i] = max(0, if (q.isEmpty()) 0 else dp[q.peek()]) + nums[i]
      while (!q.isEmpty() && dp[q.peekLast()] <= dp[i]) {
        q.pollLast()
      }
      q.offer(i)
      ans = max(ans, dp[i])
    }
    return ans
  }
}
