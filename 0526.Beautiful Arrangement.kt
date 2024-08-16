internal class Solution {
  private var n = 0
  private var ans = 0
  private var vis: BooleanArray
  private var match: Map<Int, List<Int>>? = null

  fun countArrangement(n: Int): Int {
    this.n = n
    ans = 0
    vis = BooleanArray(n + 1)
    match = HashMap()
    for (i in 1..n) {
      for (j in 1..n) {
        if (i % j == 0 || j % i == 0) {
          match.computeIfAbsent(i) { k -> ArrayList() }.add(j)
        }
      }
    }
    dfs(1)
    return ans
  }

  private fun dfs(i: Int) {
    if (i == n + 1) {
      ++ans
      return
    }
    if (!match!!.containsKey(i)) {
      return
    }
    for (j in match!![i]!!) {
      if (!vis[j]) {
        vis[j] = true
        dfs(i + 1)
        vis[j] = false
      }
    }
  }
}
