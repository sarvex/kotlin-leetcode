internal class Solution {
  fun countSegments(s: String): Int {
    var ans = 0
    for (t in s.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
      if ("" != t) {
        ++ans
      }
    }
    return ans
  }
}
