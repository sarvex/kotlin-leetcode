internal class Solution(n: Int, blacklist: IntArray) {
  private val d: Map<Int, Int> = HashMap()
  private val rand: Random = Random()
  private val k = n - blacklist.size

  init {
    var i = k
    val black: Set<Int> = HashSet()
    for (b in blacklist) {
      black.add(b)
    }
    for (b in blacklist) {
      if (b < k) {
        while (black.contains(i)) {
          ++i
        }
        d.put(b, i++)
      }
    }
  }

  fun pick(): Int {
    val x: Int = rand.nextInt(k)
    return d.getOrDefault(x, x)
  }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
