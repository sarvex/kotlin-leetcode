internal class Solution {
  fun chalkReplacer(chalk: IntArray, k: Int): Int {
    var k = k
    var s: Long = 0
    for (x in chalk) {
      s += x.toLong()
    }
    k %= s.toInt()
    var i = 0
    while (true) {
      if (k < chalk[i]) {
        return i
      }
      k -= chalk[i]
      ++i
    }
  }
}
