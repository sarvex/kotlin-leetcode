internal class SeatManager(n: Int) {
  private val q: PriorityQueue<Int> = PriorityQueue()

  init {
    for (i in 1..n) {
      q.offer(i)
    }
  }

  fun reserve(): Int {
    return q.poll()
  }

  fun unreserve(seatNumber: Int) {
    q.offer(seatNumber)
  }
}
/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
