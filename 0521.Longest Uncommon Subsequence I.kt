internal class Solution {
  fun findLUSlength(a: String, b: String): Int {
    return if (a == b) -1 else max(a.length, b.length)
  }
}
