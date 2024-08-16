internal class Solution {
  fun findKthBit(n: Int, k: Int): Char {
    return ('0'.code + dfs(n, k)).toChar()
  }

  private fun dfs(n: Int, k: Int): Int {
    if (k == 1) {
      return 0
    }
    if ((k and (k - 1)) == 0) {
      return 1
    }
    val m = 1 shl n
    if (k * 2 < m - 1) {
      return dfs(n - 1, k)
    }
    return dfs(n - 1, m - k) xor 1
  }
}
