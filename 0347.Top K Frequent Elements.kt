internal class Solution {
  fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val cnt: Map<Int, Int> = HashMap()
    for (x in nums) {
      cnt.merge(x, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    val pq
        : PriorityQueue<Map.Entry<Int, Int>> = PriorityQueue(Comparator.comparingInt(Map.Entry::getValue))
    for (e in cnt.entrySet()) {
      pq.offer(e)
      if (pq.size() > k) {
        pq.poll()
      }
    }
    return pq.stream().mapToInt(Map.Entry::getKey).toArray()
  }
}
