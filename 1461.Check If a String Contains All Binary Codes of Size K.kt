internal class Solution {
  fun hasAllCodes(s: String, k: Int): Boolean {
    val n = s.length
    val m = 1 shl k
    if (n - k + 1 < m) {
      return false
    }
    val ss: Set<String> = HashSet()
    for (i in 0 until n - k + 1) {
      ss.add(s.substring(i, i + k))
    }
    return ss.size() === m
  }
}
