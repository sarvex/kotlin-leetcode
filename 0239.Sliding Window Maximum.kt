internal class Solution {
  fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    val q
        : PriorityQueue<IntArray> = PriorityQueue { a, b ->
      if (a.get(0) === b.get(0)) a.get(1) - b.get(1) else b.get(0) - a.get(
        0
      )
    }
    val n = nums.size
    for (i in 0 until k - 1) {
      q.offer(intArrayOf(nums[i], i))
    }
    val ans = IntArray(n - k + 1)
    var i = k - 1
    var j = 0
    while (i < n) {
      q.offer(intArrayOf(nums[i], i))
      while (q.peek().get(1) <= i - k) {
        q.poll()
      }
      ans[j++] = q.peek().get(0)
      ++i
    }
    return ans
  }
}
