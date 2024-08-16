internal class Solution {
  fun distinctSubseqII(s: String): Int {
    val dp = IntArray(26)
    for (i in 0 until s.length) {
      val j: Int = s[i].code - 'a'.code
      dp[j] = sum(dp) + 1
    }
    return sum(dp)
  }

  private fun sum(arr: IntArray): Int {
    var x = 0
    for (v in arr) {
      x = (x + v) % Solution.Companion.MOD
    }
    return x
  }

  companion object {
    private const val MOD = 1e9.toInt() + 7
  }
}
