internal class Solution {
  private val f: Map<Long, Int> = HashMap()
  private var k = 0

  fun waysToReachStair(k: Int): Int {
    this.k = k
    return dfs(1, 0, 0)
  }

  private fun dfs(i: Int, j: Int, jump: Int): Int {
    if (i > k + 1) {
      return 0
    }
    val key = (i.toLong() shl 32) or (jump shl 1).toLong() or j.toLong()
    if (f.containsKey(key)) {
      return f[key]!!
    }
    var ans = if (i == k) 1 else 0
    if (i > 0 && j == 0) {
      ans += dfs(i - 1, 1, jump)
    }
    ans += dfs(i + (1 shl jump), 0, jump + 1)
    f.put(key, ans)
    return ans
  }
}
