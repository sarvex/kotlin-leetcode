internal class Solution {
  fun partitionString(s: String): Int {
    val ss: Set<Char> = HashSet()
    var ans = 1
    for (c in s.toCharArray()) {
      if (ss.contains(c)) {
        ++ans
        ss.clear()
      }
      ss.add(c)
    }
    return ans
  }
}
