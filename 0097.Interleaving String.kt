internal class Solution {
  private val f: Map<List<Int>, Boolean> = HashMap()
  private var s1: String? = null
  private var s2: String? = null
  private var s3: String? = null
  private var m = 0
  private var n = 0

  fun isInterleave(s1: String, s2: String, s3: String): Boolean {
    m = s1.length
    n = s2.length
    if (m + n != s3.length) {
      return false
    }
    this.s1 = s1
    this.s2 = s2
    this.s3 = s3
    return dfs(0, 0)
  }

  private fun dfs(i: Int, j: Int): Boolean {
    if (i >= m && j >= n) {
      return true
    }
    val key = List.of(i, j)
    if (f.containsKey(key)) {
      return f[key]!!
    }
    val k = i + j
    var ans = false
    if (i < m && s1!![i] == s3!![k] && dfs(i + 1, j)) {
      ans = true
    }
    if (!ans && j < n && s2!![j] == s3!![k] && dfs(i, j + 1)) {
      ans = true
    }
    f.put(key, ans)
    return ans
  }
}
