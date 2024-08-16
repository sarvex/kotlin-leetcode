internal class Solution {
  fun maximumScore(nums: IntArray, k: Int): Int {
    val n = nums.size
    val left = IntArray(n)
    val right = IntArray(n)
    Arrays.fill(left, -1)
    Arrays.fill(right, n)
    val stk: Deque<Int> = ArrayDeque()
    for (i in 0 until n) {
      val v = nums[i]
      while (!stk.isEmpty() && nums[stk.peek()] >= v) {
        stk.pop()
      }
      if (!stk.isEmpty()) {
        left[i] = stk.peek()
      }
      stk.push(i)
    }
    stk.clear()
    for (i in n - 1 downTo 0) {
      val v = nums[i]
      while (!stk.isEmpty() && nums[stk.peek()] > v) {
        stk.pop()
      }
      if (!stk.isEmpty()) {
        right[i] = stk.peek()
      }
      stk.push(i)
    }
    var ans = 0
    for (i in 0 until n) {
      if (left[i] + 1 <= k && k <= right[i] - 1) {
        ans = max(ans, nums[i] * (right[i] - left[i] - 1))
      }
    }
    return ans
  }
}
