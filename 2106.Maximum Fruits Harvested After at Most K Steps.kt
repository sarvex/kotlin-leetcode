internal class Solution {
  fun maxTotalFruits(fruits: Array<IntArray>, startPos: Int, k: Int): Int {
    var ans = 0
    var s = 0
    var i = 0
    var j = 0
    while (j < fruits.size) {
      val pj = fruits[j][0]
      val fj = fruits[j][1]
      s += fj
      while (i <= j
        && (pj - fruits[i][0]
            + min(abs(startPos - fruits[i][0]), abs(startPos - pj))
            > k)
      ) {
        s -= fruits[i++][1]
      }
      ans = max(ans, s)
      ++j
    }
    return ans
  }
}
