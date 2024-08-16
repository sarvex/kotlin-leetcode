internal class Solution {
  fun validUtf8(data: IntArray): Boolean {
    var cnt = 0
    for (v in data) {
      if (cnt > 0) {
        if (v shr 6 != 2) {
          return false
        }
        --cnt
      } else if (v shr 7 == 0) {
        cnt = 0
      } else if (v shr 5 == 6) {
        cnt = 1
      } else if (v shr 4 == 14) {
        cnt = 2
      } else if (v shr 3 == 30) {
        cnt = 3
      } else {
        return false
      }
    }
    return cnt == 0
  }
}
