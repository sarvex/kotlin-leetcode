internal class Solution {
  private val ans: List<String> = ArrayList()
  private val t = StringBuilder()
  private var n = 0

  fun validStrings(n: Int): List<String> {
    this.n = n
    dfs(0)
    return ans
  }

  private fun dfs(i: Int) {
    if (i >= n) {
      ans.add(t.toString())
      return
    }
    for (j in 0..1) {
      if ((j == 0 && (i == 0 || t[i - 1] == '1')) || j == 1) {
        t.append(j)
        dfs(i + 1)
        t.deleteCharAt(t.length - 1)
      }
    }
  }
}
