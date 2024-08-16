internal class Solution {
  private var f: Array<Int>
  private var s: IntArray
  private var k = 0
  private var n = 0

  fun minimumCost(sentence: String, k: Int): Int {
    this.k = k
    val words: Array<String> = sentence.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    n = words.size
    f = arrayOfNulls(n)
    s = IntArray(n + 1)
    for (i in 0 until n) {
      s[i + 1] = s[i] + words[i].length
    }
    return dfs(0)
  }

  private fun dfs(i: Int): Int {
    if (s[n] - s[i] + n - i - 1 <= k) {
      return 0
    }
    if (f[i] != null) {
      return f[i]
    }
    var ans: Int = MAX_VALUE
    var j = i + 1
    while (j < n && s[j] - s[i] + j - i - 1 <= k) {
      val m = s[j] - s[i] + j - i - 1
      ans = min(ans, dfs(j) + (k - m) * (k - m))
      ++j
    }
    return ans.also { f[i] = it }
  }
}
