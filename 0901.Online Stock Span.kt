import java.util.*

internal class StockSpanner {
  private val stk: Deque<IntArray> = ArrayDeque()

  fun next(price: Int): Int {
    var cnt = 1
    while (!stk.isEmpty() && stk.peek()[0] <= price) {
      cnt += stk.pop()[1]
    }
    stk.push(intArrayOf(price, cnt))
    return cnt
  }
}
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
