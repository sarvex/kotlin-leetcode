internal class Solution {
  fun nextBeautifulNumber(n: Int): Int {
    var x = n + 1
    while (true) {
      val cnt = IntArray(10)
      run {
        var y = x
        while (y > 0) {
          ++cnt[y % 10]
          y /= 10
        }
      }
      var ok = true
      var y = x
      while (y > 0) {
        if (y % 10 != cnt[y % 10]) {
          ok = false
          break
        }
        y /= 10
      }
      if (ok) {
        return x
      }
      ++x
    }
  }
}
