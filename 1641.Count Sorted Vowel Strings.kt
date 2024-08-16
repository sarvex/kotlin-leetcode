internal class Solution {
  private var f: Array<Array<Int>>
  private var n = 0

  fun countVowelStrings(n: Int): Int {
    this.n = n
    f = Array(n) { arrayOfNulls(5) }
    return dfs(0, 0)
  }

  private fun dfs(i: Int, j: Int): Int {
    if (i >= n) {
      return 1
    }
    if (f[i][j] != null) {
      return f[i][j]
    }
    var ans = 0
    for (k in j..4) {
      ans += dfs(i + 1, k)
    }
    return ans.also { f[i][j] = it }
  }
}
