import java.util.*

internal class Solution {
  fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
    val stk: Deque<Int> = ArrayDeque()
    val m: Map<Int, Int> = HashMap()
    for (v in nums2) {
      while (!stk.isEmpty() && stk.peek() < v) {
        m.put(stk.pop(), v)
      }
      stk.push(v)
    }
    val n = nums1.size
    val ans = IntArray(n)
    for (i in 0 until n) {
      ans[i] = m.getOrDefault(nums1[i], -1)
    }
    return ans
  }
}
