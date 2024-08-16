internal class Solution {
  private var vis: Array<BooleanArray>
  private var maze: Array<IntArray>
  private var d: IntArray
  private var m = 0
  private var n = 0

  fun hasPath(maze: Array<IntArray>, start: IntArray, destination: IntArray): Boolean {
    m = maze.size
    n = maze[0].size
    d = destination
    this.maze = maze
    vis = Array(m) { BooleanArray(n) }
    dfs(start[0], start[1])
    return vis[d[0]][d[1]]
  }

  private fun dfs(i: Int, j: Int) {
    if (vis[i][j]) {
      return
    }
    vis[i][j] = true
    if (i == d[0] && j == d[1]) {
      return
    }
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    for (k in 0..3) {
      var x = i
      var y = j
      val a = dirs[k]
      val b = dirs[k + 1]
      while (x + a >= 0 && x + a < m && y + b >= 0 && y + b < n && maze[x + a][y + b] == 0) {
        x += a
        y += b
      }
      dfs(x, y)
    }
  }
}
