internal class Solution {
  private var n = 0
  private var s: CharArray
  private var f: Array<Int>

  fun minimumSubstringsInPartition(s: String): Int {
    n = s.length
    f = arrayOfNulls(n)
    this.s = s.toCharArray()
    return dfs(0)
  }

  private fun dfs(i: Int): Int {
    if (i >= n) {
      return 0
    }
    if (f[i] != null) {
      return f[i]
    }
    val cnt = IntArray(26)
    val freq: Map<Int, Int> = HashMap(26)
    var ans = n - i
    for (j in i until n) {
      val k: Int = s[j].code - 'a'.code
      if (cnt[k] > 0) {
        if (freq.merge(cnt[k], -1) { a: Int, b: Int -> Integer.sum(a, b) } === 0) {
          freq.remove(cnt[k])
        }
      }
      ++cnt[k]
      freq.merge(cnt[k], 1) { a: Int, b: Int -> Integer.sum(a, b) }
      if (freq.size() === 1) {
        ans = min(ans, 1 + dfs(j + 1))
      }
    }
    return ans.also { f[i] = it }
  }
}
