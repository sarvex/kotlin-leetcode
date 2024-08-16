internal class Solution {
  fun leastInterval(tasks: CharArray, n: Int): Int {
    val cnt = IntArray(26)
    var x = 0
    for (c in tasks) {
      var c = c
      (c -= 'A').toChar()
      ++cnt[c.code]
      x = max(x, cnt[c.code])
    }
    var s = 0
    for (v in cnt) {
      if (v == x) {
        ++s
      }
    }
    return max(tasks.size, (x - 1) * (n + 1) + s)
  }
}
