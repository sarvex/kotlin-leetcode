internal class Solution {
  fun minOperations(nums: IntArray, k: Int): Int {
    val pq: PriorityQueue<Long> = PriorityQueue()
    for (x in nums) {
      pq.offer(x.toLong())
    }
    var ans = 0
    while (pq.size() > 1 && pq.peek() < k) {
      val x: Long = pq.poll()
      val y: Long = pq.poll()
      pq.offer(min(x, y) * 2 + max(x, y))
      ++ans
    }
    return ans
  }
}
