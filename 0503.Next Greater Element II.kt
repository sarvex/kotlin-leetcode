import java.util.Deque

internal class Solution {
  fun nextGreaterElements(nums: IntArray): IntArray {
    val n = nums.size
    val ans = IntArray(n)
    Arrays.fill(ans, -1)
    val stk: Deque<Int> = ArrayDeque()
    for (i in n * 2 - 1 downTo 0) {
      val j: Int = i % n
      while (!stk.isEmpty() && stk.peek() <= nums[j]) {
        stk.pop()
      }
      if (!stk.isEmpty()) {
        ans[j] = stk.peek()
      }
      stk.push(nums[j])
    }
    return ans
  }
}
