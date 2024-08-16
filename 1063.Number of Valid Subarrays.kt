import java.util.Deque

internal class Solution {
  fun validSubarrays(nums: IntArray): Int {
    val n = nums.size
    val right = IntArray(n)
    Arrays.fill(right, n)
    val stk: Deque<Int> = ArrayDeque()
    for (i in n - 1 downTo 0) {
      while (!stk.isEmpty() && nums[stk.peek()] >= nums[i]) {
        stk.pop()
      }
      if (!stk.isEmpty()) {
        right[i] = stk.peek()
      }
      stk.push(i)
    }
    var ans = 0
    for (i in 0 until n) {
      ans += right[i] - i
    }
    return ans
  }
}
