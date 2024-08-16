internal class Solution {
  fun constructRectangle(area: Int): IntArray {
    var w = sqrt(area) as Int
    while (area % w != 0) {
      --w
    }
    return intArrayOf(area / w, w)
  }
}
