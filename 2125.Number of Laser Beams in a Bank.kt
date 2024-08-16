internal class Solution {
  fun numberOfBeams(bank: Array<String>): Int {
    var ans = 0
    var pre = 0
    for (row in bank) {
      var cur = 0
      for (i in 0 until row.length) {
        cur += row[i].code - '0'.code
      }
      if (cur > 0) {
        ans += pre * cur
        pre = cur
      }
    }
    return ans
  }
}
