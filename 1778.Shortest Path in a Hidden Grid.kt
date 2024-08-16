/**
 * // This is the GridMaster's API interface.
 * // You should not implement it, or speculate about its implementation
 * class GridMaster {
 * boolean canMove(char direction);
 * void move(char direction);
 * boolean isTarget();
 * }
 */
internal class Solution {
  private var target: IntArray?
  private var master: GridMaster? = null
  private val n = 2010
  private val s = "URDL"
  private val dirs = intArrayOf(-1, 0, 1, 0, -1)
  private val vis: Set<Int> = HashSet()

  fun findShortestPath(master: GridMaster?): Int {
    this.master = master
    dfs(0, 0)
    if (target == null) {
      return -1
    }
    vis.remove(0)
    val q: Deque<IntArray> = ArrayDeque()
    q.offer(intArrayOf(0, 0))
    var ans = 0
    while (!q.isEmpty()) {
      for (m in q.size() downTo 1) {
        val p: Unit = q.poll()
        if (p.get(0) === target!![0] && p.get(1) === target!![1]) {
          return ans
        }
        for (k in 0..3) {
          val x: Int = p.get(0) + dirs[k]
          val y: Int = p.get(1) + dirs[k + 1]
          if (vis.remove(x * n + y)) {
            q.offer(intArrayOf(x, y))
          }
        }
      }
      ++ans
    }
    return -1
  }

  private fun dfs(i: Int, j: Int) {
    if (master.isTarget()) {
      target = intArrayOf(i, j)
      return
    }
    for (k in 0..3) {
      val x = i + dirs[k]
      val y = j + dirs[k + 1]
      if (master.canMove(s[k]) && vis.add(x * n + y)) {
        master.move(s[k])
        dfs(x, y)
        master.move(s[(k + 2) % 4])
      }
    }
  }
}
