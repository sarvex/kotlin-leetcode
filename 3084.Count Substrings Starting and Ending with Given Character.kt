internal class Solution {
  fun countSubstrings(s: String, c: Char): Long {
    val cnt = s.chars().filter { ch: Int -> ch == c.code }.count()
    return cnt + cnt * (cnt - 1) / 2
  }
}
