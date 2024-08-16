internal class Solution {
  fun findRadius(houses: IntArray, heaters: IntArray): Int {
    Arrays.sort(heaters)
    var res = 0
    for (x in houses) {
      var i: Int = Arrays.binarySearch(heaters, x)
      if (i < 0) {
        i = i.inv()
      }
      val dis1 = if (i > 0) x - heaters[i - 1] else MAX_VALUE
      val dis2 = if (i < heaters.size) heaters[i] - x else MAX_VALUE
      res = max(res, min(dis1, dis2))
    }
    return res
  }
}
