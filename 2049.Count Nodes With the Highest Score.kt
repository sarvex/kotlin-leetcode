internal class Solution {
  private var g: Array<List<Int>>
  private var ans = 0
  private var mx: Long = 0
  private var n = 0

  fun countHighestScoreNodes(parents: IntArray): Int {
    n = parents.size
    g = arrayOfNulls(n)
    Arrays.setAll(g) { i -> ArrayList() }
    for (i in 1 until n) {
      g[parents[i]].add(i)
    }
    dfs(0, -1)
    return ans
  }

  private fun dfs(i: Int, fa: Int): Int {
    var cnt = 1
    var score: Long = 1
    for (j in g[i]) {
      if (j != fa) {
        val t = dfs(j, i)
        cnt += t
        score *= t.toLong()
      }
    }
    if (n - cnt > 0) {
      score *= (n - cnt).toLong()
    }
    if (mx < score) {
      mx = score
      ans = 1
    } else if (mx == score) {
      ++ans
    }
    return cnt
  }
}
