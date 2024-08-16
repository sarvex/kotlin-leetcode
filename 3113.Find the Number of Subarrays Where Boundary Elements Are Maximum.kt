internal class Solution {
  fun numberOfSubarrays(nums: IntArray): Long {
    val stk: Deque<IntArray> = ArrayDeque()
    var ans: Long = 0
    for (x in nums) {
      while (!stk.isEmpty() && stk.peek().get(0) < x) {
        stk.pop()
      }
      if (stk.isEmpty() || stk.peek().get(0) > x) {
        stk.push(intArrayOf(x, 1))
      } else {
        stk.peek().get(1)++
      }
      ans += stk.peek().get(1)
    }
    return ans
  }
}
