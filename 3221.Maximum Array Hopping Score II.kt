internal class Solution {
  fun maxScore(nums: IntArray): Long {
    val stk: Deque<Int> = ArrayDeque()
    for (i in nums.indices) {
      while (!stk.isEmpty() && nums[stk.peek()] <= nums[i]) {
        stk.pop()
      }
      stk.push(i)
    }
    var ans: Long = 0
    var i: Long = 0
    while (!stk.isEmpty()) {
      val j: Int = stk.pollLast()
      ans += (j - i) * nums[j]
      i = j.toLong()
    }
    return ans
  }
}
