import java.util.*

internal class Solution {
  fun totalCost(costs: IntArray, k: Int, candidates: Int): Long {
    var k = k
    val n = costs.size
    var ans: Long = 0
    if (candidates * 2 >= n) {
      Arrays.sort(costs)
      for (i in 0 until k) {
        ans += costs[i].toLong()
      }
      return ans
    }
    val pq
        : PriorityQueue<IntArray> = PriorityQueue { a, b ->
      if (a.get(0) === b.get(0)) a.get(1) - b.get(1) else a.get(0) - b.get(
        0
      )
    }
    for (i in 0 until candidates) {
      pq.offer(intArrayOf(costs[i], i))
      pq.offer(intArrayOf(costs[n - i - 1], n - i - 1))
    }
    var l = candidates
    var r = n - candidates - 1
    while (k-- > 0) {
      val p: Unit = pq.poll()
      ans += p.get(0)
      if (l > r) {
        continue
      }
      if (p.get(1) < l) {
        pq.offer(intArrayOf(costs[l], l++))
      } else {
        pq.offer(intArrayOf(costs[r], r--))
      }
    }
    return ans
  }
}
