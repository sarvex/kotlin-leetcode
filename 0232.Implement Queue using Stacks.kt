import java.util.*

internal class MyQueue {
  private val stk1: Deque<Int> = ArrayDeque()
  private val stk2: Deque<Int> = ArrayDeque()

  fun push(x: Int) {
    stk1.push(x)
  }

  fun pop(): Int {
    move()
    return stk2.pop()
  }

  fun peek(): Int {
    move()
    return stk2.peek()
  }

  fun empty(): Boolean {
    return stk1.isEmpty() && stk2.isEmpty()
  }

  private fun move() {
    while (stk2.isEmpty()) {
      while (!stk1.isEmpty()) {
        stk2.push(stk1.pop())
      }
    }
  }
}
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
