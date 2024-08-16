import java.util.*

internal class Solution {
  fun maxHammingDistances(nums: IntArray, m: Int): IntArray {
    val dist = IntArray(1 shl m)
    Arrays.fill(dist, -1)
    val q: Deque<Int> = ArrayDeque()
    for (x in nums) {
      dist[x] = 0
      q.offer(x)
    }
    var k = 1
    while (!q.isEmpty()) {
      for (t in q.size() downTo 1) {
        val x: Int = q.poll()
        for (i in 0 until m) {
          val y = x xor (1 shl i)
          if (dist[y] == -1) {
            q.offer(y)
            dist[y] = k
          }
        }
      }
      ++k
    }
    for (i in nums.indices) {
      nums[i] = m - dist[nums[i] xor ((1 shl m) - 1)]
    }
    return nums
  }
}
