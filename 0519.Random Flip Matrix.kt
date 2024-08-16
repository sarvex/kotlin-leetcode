internal class Solution(private val m: Int, private val n: Int) {
  private var total: Int
  private val rand: Random = Random()
  private val mp: Map<Int, Int> = HashMap()

  init {
    this.total = m * n
  }

  fun flip(): IntArray {
    val x: Int = rand.nextInt(total--)
    val idx = mp.getOrDefault(x, x)
    mp.put(x, mp.getOrDefault(total, total))
    return intArrayOf(idx / n, idx % n)
  }

  fun reset() {
    total = m * n
    mp.clear()
  }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */
