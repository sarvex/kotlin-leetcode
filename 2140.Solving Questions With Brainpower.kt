internal class Solution {
  private var n = 0
  private var f: Array<Long>
  private var questions: Array<IntArray>

  fun mostPoints(questions: Array<IntArray>): Long {
    n = questions.size
    f = arrayOfNulls(n)
    this.questions = questions
    return dfs(0)
  }

  private fun dfs(i: Int): Long {
    if (i >= n) {
      return 0
    }
    if (f[i] != null) {
      return f[i]
    }
    val p = questions[i][0]
    val b = questions[i][1]
    return max(p + dfs(i + b + 1), dfs(i + 1)).also { f[i] = it }
  }
}
