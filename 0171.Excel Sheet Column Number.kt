internal class Solution {
  fun titleToNumber(columnTitle: String): Int {
    var ans = 0
    for (i in 0 until columnTitle.length) {
      ans = ans * 26 + (columnTitle[i].code - 'A'.code + 1)
    }
    return ans
  }
}
