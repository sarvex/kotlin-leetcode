internal class Solution {
  fun numberOfAlternatingGroups(colors: IntArray, k: Int): Int {
    val n = colors.size
    var ans = 0
    var cnt = 0
    for (i in 0 until (n shl 1)) {
      if (i > 0 && colors[i % n] == colors[(i - 1) % n]) {
        cnt = 1
      } else {
        ++cnt
      }
      ans += if (i >= n && cnt >= k) 1 else 0
    }
    return ans
  }
}
