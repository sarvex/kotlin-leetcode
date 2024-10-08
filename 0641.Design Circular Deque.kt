internal class MyCircularDeque(k: Int) {
  private val q = IntArray(k)
  private var front = 0
  private var size = 0
  private val capacity = k

  /** Adds an item at the front of Deque. Return true if the operation is successful.  */
  fun insertFront(value: Int): Boolean {
    if (isFull) {
      return false
    }
    if (!isEmpty) {
      front = (front - 1 + capacity) % capacity
    }
    q[front] = value
    ++size
    return true
  }

  /** Adds an item at the rear of Deque. Return true if the operation is successful.  */
  fun insertLast(value: Int): Boolean {
    if (isFull) {
      return false
    }
    val idx = (front + size) % capacity
    q[idx] = value
    ++size
    return true
  }

  /** Deletes an item from the front of Deque. Return true if the operation is successful.  */
  fun deleteFront(): Boolean {
    if (isEmpty) {
      return false
    }
    front = (front + 1) % capacity
    --size
    return true
  }

  /** Deletes an item from the rear of Deque. Return true if the operation is successful.  */
  fun deleteLast(): Boolean {
    if (isEmpty) {
      return false
    }
    --size
    return true
  }

  /** Get the front item from the deque.  */
  fun getFront(): Int {
    if (isEmpty) {
      return -1
    }
    return q[front]
  }

  val rear: Int
    /** Get the last item from the deque.  */
    get() {
      if (isEmpty) {
        return -1
      }
      val idx = (front + size - 1) % capacity
      return q[idx]
    }

  val isEmpty: Boolean
    /** Checks whether the circular deque is empty or not.  */
    get() = size == 0

  val isFull: Boolean
    /** Checks whether the circular deque is full or not.  */
    get() = size == capacity
}
/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
