internal class Solution {
  fun numberOfPaths(n: Int, corridors: Array<IntArray>): Int {
    val g: Array<Set<Int>> = arrayOfNulls(n + 1)
    for (i in 0..n) {
      g[i] = HashSet()
    }
    for (c in corridors) {
      val a = c[0]
      val b = c[1]
      g[a].add(b)
      g[b].add(a)
    }
    var ans = 0
    for (c in 1..n) {
      val nxt: ArrayList = ArrayList(g[c])
      val m: Int = nxt.size()
      for (i in 0 until m) {
        for (j in i + 1 until m) {
          val a: Int = nxt.get(i)
          val b: Int = nxt.get(j)
          if (g[b].contains(a)) {
            ++ans
          }
        }
      }
    }
    return ans / 3
  }
}
