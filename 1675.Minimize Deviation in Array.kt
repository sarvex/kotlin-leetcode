internal class Solution {
  fun minimumDeviation(nums: IntArray): Int {
    val q: PriorityQueue<Int> = PriorityQueue { a, b -> b - a }
    var mi: Int = MAX_VALUE
    for (v in nums) {
      var v = v
      if (v % 2 == 1) {
        v = v shl 1
      }
      q.offer(v)
      mi = min(mi, v)
    }
    var ans: Int = q.peek() - mi
    while (q.peek() % 2 === 0) {
      val x: Int = q.poll() / 2
      q.offer(x)
      mi = min(mi, x)
      ans = Math.min(ans, q.peek() - mi)
    }
    return ans
  }
}
