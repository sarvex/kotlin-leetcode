internal class Hashing(word: String, base: Long, mod: Int) {
  private val p: LongArray
  private val h: LongArray
  private val mod: Long

  init {
    val n = word.length
    p = LongArray(n + 1)
    h = LongArray(n + 1)
    p[0] = 1
    this.mod = mod.toLong()
    for (i in 1..n) {
      p[i] = p[i - 1] * base % mod
      h[i] = (h[i - 1] * base + word[i - 1].code.toLong() - 'a'.code.toLong()) % mod
    }
  }

  fun query(l: Int, r: Int): Long {
    return (h[r] - h[l - 1] * p[r - l + 1] % mod + mod) % mod
  }
}

internal class Solution {
  fun minimumTimeToInitialState(word: String, k: Int): Int {
    val hashing = Hashing(word, 13331, 998244353)
    val n = word.length
    var i = k
    while (i < n) {
      if (hashing.query(1, n - i) == hashing.query(i + 1, n)) {
        return i / k
      }
      i += k
    }
    return (n + k - 1) / k
  }
}
