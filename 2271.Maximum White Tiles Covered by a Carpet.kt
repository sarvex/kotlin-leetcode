import java.util.*

internal class Solution {
  fun maximumWhiteTiles(tiles: Array<IntArray>, carpetLen: Int): Int {
    Arrays.sort(tiles) { a, b -> a[0] - b[0] }
    val n = tiles.size
    var s = 0
    var ans = 0
    var i = 0
    var j = 0
    while (i < n) {
      while (j < n && tiles[j][1] - tiles[i][0] + 1 <= carpetLen) {
        s += tiles[j][1] - tiles[j][0] + 1
        ++j
      }
      if (j < n && tiles[i][0] + carpetLen > tiles[j][0]) {
        ans = max(ans, s + tiles[i][0] + carpetLen - tiles[j][0])
      } else {
        ans = max(ans, s)
      }
      s -= (tiles[i][1] - tiles[i][0] + 1)
      ++i
    }
    return ans
  }
}
