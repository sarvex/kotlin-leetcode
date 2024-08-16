internal class Solution {
  fun minStoneSum(piles: IntArray, k: Int): Int {
    var k = k
    val pq: PriorityQueue<Int> = PriorityQueue { a, b -> b - a }
    for (x in piles) {
      pq.offer(x)
    }
    while (k-- > 0) {
      val x: Int = pq.poll()
      pq.offer(x - x / 2)
    }
    var ans = 0
    while (!pq.isEmpty()) {
      ans += pq.poll()
    }
    return ans
  }
}
