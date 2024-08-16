internal class Solution {
  fun canFormArray(arr: IntArray, pieces: Array<IntArray>): Boolean {
    var i = 0
    while (i < arr.size) {
      var k = 0
      while (k < pieces.size && pieces[k][0] != arr[i]) {
        ++k
      }
      if (k == pieces.size) {
        return false
      }
      var j = 0
      while (j < pieces[k].size && arr[i] == pieces[k][j]) {
        ++i
        ++j
      }
    }
    return true
  }
}
