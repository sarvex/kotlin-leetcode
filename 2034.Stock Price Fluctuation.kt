internal class StockPrice {
  private val d: Map<Int, Int> = HashMap()
  private val ls: TreeMap<Int, Int> = TreeMap()
  private var last = 0

  fun update(timestamp: Int, price: Int) {
    if (d.containsKey(timestamp)) {
      val old = d[timestamp]!!
      if (ls.merge(old, -1) { a: Int, b: Int -> Integer.sum(a, b) } === 0) {
        ls.remove(old)
      }
    }
    d.put(timestamp, price)
    ls.merge(price, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    last = max(last, timestamp)
  }

  fun current(): Int {
    return d[last]!!
  }

  fun maximum(): Int {
    return ls.lastKey()
  }

  fun minimum(): Int {
    return ls.firstKey()
  }
}
/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
