internal class Solution {
  fun mostFrequentIDs(nums: IntArray, freq: IntArray): LongArray {
    val cnt: Map<Int, Long> = HashMap()
    val lazy: Map<Long, Int> = HashMap()
    val n = nums.size
    val ans = LongArray(n)
    val pq: PriorityQueue<Long> = PriorityQueue(Collections.reverseOrder())
    for (i in 0 until n) {
      val x = nums[i]
      val f = freq[i]
      lazy.merge(cnt.getOrDefault(x, 0L), 1) { a: Int, b: Int -> Integer.sum(a, b) }
      cnt.merge(x, f.toLong()) { a: Long, b: Long -> java.lang.Long.sum(a, b) }
      pq.add(cnt[x])
      while (!pq.isEmpty() && lazy.getOrDefault(pq.peek(), 0) > 0) {
        lazy.merge(pq.poll(), -1) { a: Int, b: Int -> Integer.sum(a, b) }
      }
      ans[i] = if (pq.isEmpty()) 0 else pq.peek()
    }
    return ans
  }
}
