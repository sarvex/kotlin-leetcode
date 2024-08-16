internal class Solution {
  fun isIsomorphic(s: String, t: String): Boolean {
    val d1: Map<Char, Char> = HashMap()
    val d2: Map<Char, Char> = HashMap()
    val n = s.length
    for (i in 0 until n) {
      val a = s[i]
      val b = t[i]
      if (d1.containsKey(a) && d1[a] !== b) {
        return false
      }
      if (d2.containsKey(b) && d2[b] !== a) {
        return false
      }
      d1.put(a, b)
      d2.put(b, a)
    }
    return true
  }
}
