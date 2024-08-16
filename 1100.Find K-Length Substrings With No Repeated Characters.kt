internal class Solution {
  fun numKLenSubstrNoRepeats(s: String, k: Int): Int {
    val n = s.length
    if (n < k) {
      return 0
    }
    val cnt: Map<Char, Int> = HashMap(k)
    for (i in 0 until k) {
      cnt.merge(s[i], 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    var ans = if (cnt.size() === k) 1 else 0
    for (i in k until n) {
      cnt.merge(s[i], 1) { a: Int, b: Int -> Integer.sum(a, b) }
      if (cnt.merge(s[i - k], -1) { a: Int, b: Int -> Integer.sum(a, b) } === 0) {
        cnt.remove(s[i - k])
      }
      ans += if (cnt.size() === k) 1 else 0
    }
    return ans
  }
}
