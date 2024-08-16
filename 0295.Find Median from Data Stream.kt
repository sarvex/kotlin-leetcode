internal class MedianFinder {
  private val minQ: PriorityQueue<Int> = PriorityQueue()
  private val maxQ: PriorityQueue<Int> = PriorityQueue(Collections.reverseOrder())

  fun addNum(num: Int) {
    maxQ.offer(num)
    minQ.offer(maxQ.poll())
    if (minQ.size() - maxQ.size() > 1) {
      maxQ.offer(minQ.poll())
    }
  }

  fun findMedian(): Double {
    return if (minQ.size() === maxQ.size()) (minQ.peek() + maxQ.peek()) / 2.0 else minQ.peek()
  }
}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
