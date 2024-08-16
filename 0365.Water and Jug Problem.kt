internal class Solution {
  private val vis: Set<Long> = HashSet()
  private var x = 0
  private var y = 0
  private var z = 0

  fun canMeasureWater(jug1Capacity: Int, jug2Capacity: Int, targetCapacity: Int): Boolean {
    x = jug1Capacity
    y = jug2Capacity
    z = targetCapacity
    return dfs(0, 0)
  }

  private fun dfs(i: Int, j: Int): Boolean {
    val st = f(i, j)
    if (!vis.add(st)) {
      return false
    }
    if (i == z || j == z || i + j == z) {
      return true
    }
    if (dfs(x, j) || dfs(i, y) || dfs(0, j) || dfs(i, 0)) {
      return true
    }
    val a: Int = min(i, y - j)
    val b: Int = min(j, x - i)
    return dfs(i - a, j + a) || dfs(i + b, j - b)
  }

  private fun f(i: Int, j: Int): Long {
    return i * 1000000L + j
  }
}
