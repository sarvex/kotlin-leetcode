internal class Solution {
  fun countDivisibleSubstrings(word: String): Int {
    val d = arrayOf("ab", "cde", "fgh", "ijk", "lmn", "opq", "rst", "uvw", "xyz")
    val mp = IntArray(26)
    for (i in d.indices) {
      for (c in d[i].toCharArray()) {
        mp[c.code - 'a'.code] = i + 1
      }
    }
    var ans = 0
    val n = word.length
    for (i in 0 until n) {
      var s = 0
      for (j in i until n) {
        s += mp[word[j].code - 'a'.code]
        ans += if (s % (j - i + 1) == 0) 1 else 0
      }
    }
    return ans
  }
}
