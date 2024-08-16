internal class neighborSum(private val grid: Array<IntArray>) {
  private val d: Map<Int, IntArray> = HashMap()
  private val dirs = arrayOf(intArrayOf(-1, 0, 1, 0, -1), intArrayOf(-1, 1, 1, -1, -1))

  init {
    val m = grid.size
    val n = grid[0].size
    for (i in 0 until m) {
      for (j in 0 until n) {
        d.put(grid[i][j], intArrayOf(i, j))
      }
    }
  }

  fun adjacentSum(value: Int): Int {
    return cal(value, 0)
  }

  fun diagonalSum(value: Int): Int {
    return cal(value, 1)
  }

  private fun cal(value: Int, k: Int): Int {
    val p = d[value]!!
    var s = 0
    for (q in 0..3) {
      val x = p[0] + dirs[k][q]
      val y = p[1] + dirs[k][q + 1]
      if (x >= 0 && x < grid.size && y >= 0 && y < grid[0].size) {
        s += grid[x][y]
      }
    }
    return s
  }
}
/**
 * Your neighborSum object will be instantiated and called as such:
 * neighborSum obj = new neighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */
