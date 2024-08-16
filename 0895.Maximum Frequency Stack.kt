internal class FreqStack {
  private val cnt: Map<Int, Int> = HashMap()
  private val q
      : PriorityQueue<IntArray> = PriorityQueue { a, b ->
    if (a.get(0) === b.get(0)) b.get(1) - a.get(1) else b.get(0) - a.get(
      0
    )
  }
  private var ts = 0

  fun push(`val`: Int) {
    cnt.put(`val`, cnt.getOrDefault(`val`, 0) + 1)
    q.offer(intArrayOf(cnt[`val`]!!, ++ts, `val`))
  }

  fun pop(): Int {
    val `val`: Int = q.poll().get(2)
    cnt.put(`val`, cnt[`val`]!! - 1)
    return `val`
  }
}
/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
