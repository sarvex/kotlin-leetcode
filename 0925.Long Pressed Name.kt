internal class Solution {
  fun isLongPressedName(name: String, typed: String): Boolean {
    val m = name.length
    val n = typed.length
    var i = 0
    var j = 0
    while (i < m && j < n) {
      if (name[i] != typed[j]) {
        return false
      }
      var x = i + 1
      while (x < m && name[x] == name[i]) {
        ++x
      }
      var y = j + 1
      while (y < n && typed[y] == typed[j]) {
        ++y
      }
      if (x - i > y - j) {
        return false
      }
      i = x
      j = y
    }
    return i == m && j == n
  }
}
