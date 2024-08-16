internal class Solution {
  fun maximumUnits(boxTypes: Array<IntArray>, truckSize: Int): Int {
    var truckSize = truckSize
    Arrays.sort(boxTypes) { a, b -> b.get(1) - a.get(1) }
    var ans = 0
    for (e in boxTypes) {
      val a = e[0]
      val b = e[1]
      ans += b * min(truckSize, a)
      truckSize -= a
      if (truckSize <= 0) {
        break
      }
    }
    return ans
  }
}
