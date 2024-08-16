internal class Solution {
  fun winningPlayerCount(n: Int, pick: Array<IntArray>): Int {
    val cnt = Array(n) { IntArray(11) }
    val s: Set<Int> = HashSet()
    for (p in pick) {
      val x = p[0]
      val y = p[1]
      if (++cnt[x][y] > x) {
        s.add(x)
      }
    }
    return s.size()
  }
}
