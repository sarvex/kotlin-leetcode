internal class KthLargest(private val k: Int, nums: IntArray) {
  private val minQ: PriorityQueue<Int>

  init {
    minQ = PriorityQueue(k)
    for (x in nums) {
      add(x)
    }
  }

  fun add(`val`: Int): Int {
    minQ.offer(`val`)
    if (minQ.size() > k) {
      minQ.poll()
    }
    return minQ.peek()
  }
}
/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
