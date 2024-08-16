internal class Solution {
  fun maxMoves(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    var q: Set<Int> = IntStream.range(0, m).boxed().collect(Collectors.toSet())
    for (j in 0 until n - 1) {
      val t: Set<Int> = HashSet()
      for (i in q) {
        for (k in i - 1..(i + 1)) {
          if (k >= 0 && k < m && grid[i][j] < grid[k][j + 1]) {
            t.add(k)
          }
        }
      }
      if (t.isEmpty()) {
        return j
      }
      q = t
    }
    return n - 1
  }
}
