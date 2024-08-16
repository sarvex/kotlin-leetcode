internal class Solution {
  fun shiftGrid(grid: Array<IntArray>, k: Int): List<List<Int>> {
    val m = grid.size
    val n = grid[0].size
    val ans: List<List<Int>> = ArrayList()
    for (i in 0 until m) {
      val row: List<Int> = ArrayList()
      for (j in 0 until n) {
        row.add(0)
      }
      ans.add(row)
    }
    for (i in 0 until m) {
      for (j in 0 until n) {
        val idx: Int = (i * n + j + k) % (m * n)
        val x = idx / n
        val y = idx % n
        ans[x].set(y, grid[i][j])
      }
    }
    return ans
  }
}
