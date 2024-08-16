internal class Solution {
  fun getBiggestThree(grid: Array<IntArray>): IntArray {
    val m = grid.size
    val n = grid[0].size
    val s1 = Array(m + 1) { IntArray(n + 2) }
    val s2 = Array(m + 1) { IntArray(n + 2) }
    for (i in 1..m) {
      for (j in 1..n) {
        s1[i][j] = s1[i - 1][j - 1] + grid[i - 1][j - 1]
        s2[i][j] = s2[i - 1][j + 1] + grid[i - 1][j - 1]
      }
    }
    val ss: TreeSet<Int> = TreeSet()
    for (i in 1..m) {
      for (j in 1..n) {
        val l: Int = min(min(i - 1, m - i), min(j - 1, n - j))
        ss.add(grid[i - 1][j - 1])
        for (k in 1..l) {
          val a = s1[i + k][j] - s1[i][j - k]
          val b = s1[i][j + k] - s1[i - k][j]
          val c = s2[i][j - k] - s2[i - k][j]
          val d = s2[i + k][j] - s2[i][j + k]
          ss.add(a + b + c + d - grid[i + k - 1][j - 1] + grid[i - k - 1][j - 1])
        }
        while (ss.size() > 3) {
          ss.pollFirst()
        }
      }
    }
    val ans = IntArray(ss.size())
    for (i in ans.indices) {
      ans[i] = ss.pollLast()
    }
    return ans
  }
}
