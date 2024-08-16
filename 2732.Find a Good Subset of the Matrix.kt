internal class Solution {
  fun goodSubsetofBinaryMatrix(grid: Array<IntArray>): List<Int> {
    val g: Map<Int, Int> = HashMap()
    for (i in grid.indices) {
      var mask = 0
      for (j in grid[0].indices) {
        mask = mask or (grid[i][j] shl j)
      }
      if (mask == 0) {
        return List.of(i)
      }
      g.put(mask, i)
    }
    for (e1 in g.entrySet()) {
      for (e2 in g.entrySet()) {
        if ((e1.getKey() and e2.getKey()) === 0) {
          val i: Int = e1.getValue()
          val j: Int = e2.getValue()
          return List.of(min(i, j), max(i, j))
        }
      }
    }
    return List.of()
  }
}
