internal class Solution {
  fun longestAwesome(s: String): Int {
    val d = IntArray(1024)
    var st = 0
    var ans = 1
    Arrays.fill(d, -1)
    d[0] = 0
    for (i in 1..s.length) {
      var v: Int = s[i - 1].code - '0'.code
      st = st xor (1 shl v)
      if (d[st] >= 0) {
        ans = max(ans, i - d[st])
      } else {
        d[st] = i
      }
      v = 0
      while (v < 10) {
        if (d[st xor (1 shl v)] >= 0) {
          ans = max(ans, i - d[st xor (1 shl v)])
        }
        ++v
      }
    }
    return ans
  }
}
