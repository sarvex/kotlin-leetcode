internal class Solution {
  fun maximumScore(a: Int, b: Int, c: Int): Int {
    val s = intArrayOf(a, b, c)
    Arrays.sort(s)
    var ans = 0
    while (s[1] > 0) {
      ++ans
      s[1]--
      s[2]--
      Arrays.sort(s)
    }
    return ans
  }
}
