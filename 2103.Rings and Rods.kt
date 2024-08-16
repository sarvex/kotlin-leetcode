internal class Solution {
  fun countPoints(rings: String): Int {
    val d = IntArray('Z')
    d.get('R') = 1
    d.get('G') = 2
    d.get('B') = 4
    val mask = IntArray(10)
    var i = 0
    val n = rings.length
    while (i < n) {
      val c: Int = rings[i].code
      val j: Int = rings[i + 1].code - '0'.code
      mask[j] = mask[j] or d[c]
      i += 2
    }
    var ans = 0
    for (x in mask) {
      if (x == 7) {
        ++ans
      }
    }
    return ans
  }
}
