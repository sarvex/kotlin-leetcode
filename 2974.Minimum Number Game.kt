internal class Solution {
  fun numberGame(nums: IntArray): IntArray {
    val pq: PriorityQueue<Int> = PriorityQueue()
    for (x in nums) {
      pq.offer(x)
    }
    val ans = IntArray(nums.size)
    var i = 0
    while (!pq.isEmpty()) {
      val a: Int = pq.poll()
      ans[i++] = pq.poll()
      ans[i++] = a
    }
    return ans
  }
}
