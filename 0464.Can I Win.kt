internal class Solution {
  private val f: Map<Int, Boolean> = HashMap()
  private var maxChoosableInteger = 0
  private var desiredTotal = 0

  fun canIWin(maxChoosableInteger: Int, desiredTotal: Int): Boolean {
    if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
      return false
    }
    this.maxChoosableInteger = maxChoosableInteger
    this.desiredTotal = desiredTotal
    return dfs(0, 0)
  }

  private fun dfs(mask: Int, s: Int): Boolean {
    if (f.containsKey(mask)) {
      return f[mask]!!
    }
    for (i in 0 until maxChoosableInteger) {
      if ((mask shr i and 1) == 0) {
        if (s + i + 1 >= desiredTotal || !dfs(mask or (1 shl i), s + i + 1)) {
          f.put(mask, true)
          return true
        }
      }
    }
    f.put(mask, false)
    return false
  }
}
