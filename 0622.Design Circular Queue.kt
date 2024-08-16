internal class MyCircularQueue(k: Int) {
  private val q = IntArray(k)
  private var front = 0
  private var size = 0
  private val capacity = k

  fun enQueue(value: Int): Boolean {
    if (isFull) {
      return false
    }
    val idx = (front + size) % capacity
    q[idx] = value
    ++size
    return true
  }

  fun deQueue(): Boolean {
    if (isEmpty) {
      return false
    }
    front = (front + 1) % capacity
    --size
    return true
  }

  fun Front(): Int {
    if (isEmpty) {
      return -1
    }
    return q[front]
  }

  fun Rear(): Int {
    if (isEmpty) {
      return -1
    }
    val idx = (front + size - 1) % capacity
    return q[idx]
  }

  val isEmpty: Boolean
    get() = size == 0

  val isFull: Boolean
    get() = size == capacity
}
/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
