internal class Solution {
  fun getLengthOfOptimalCompression(s: String, k: Int): Int {
    // dp[i][k] := the length of the optimal compression of s[i..n) with at most
    // k deletion
    dp = Array(s.length) { IntArray(k + 1) }
    Arrays.stream(dp).forEach { A -> Arrays.fill(A, Solution.Companion.K_MAX) }
    return compression(s, 0, k)
  }

  private var dp: Array<IntArray>

  private fun compression(s: String, i: Int, k: Int): Int {
    if (k < 0) {
      return Solution.Companion.K_MAX
    }
    if (i == s.length || s.length - i <= k) {
      return 0
    }
    if (dp[i][k] != Solution.Companion.K_MAX) {
      return dp[i][k]
    }
    var maxFreq = 0
    val count = IntArray(128)
    // Make letters in s[i..j] be the same.
    // Keep the letter that has the maximum frequency in this range and remove
    // the other letters.
    for (j in i until s.length) {
      maxFreq = max(maxFreq, ++count[s[j].code])
      dp[i][k] = min(
        dp[i][k], getLength(maxFreq) + compression(s, j + 1, k - (j - i + 1 - maxFreq))
      )
    }
    return dp[i][k]
  }

  // Returns the length to compress `maxFreq`.
  private fun getLength(maxFreq: Int): Int {
    if (maxFreq == 1) {
      return 1 // c
    }
    if (maxFreq < 10) {
      return 2 // [1-9]c
    }
    if (maxFreq < 100) {
      return 3 // [1-9][0-9]c
    }
    return 4 // [1-9][0-9][0-9]c
  }

  companion object {
    private const val K_MAX = 101
  }
}
