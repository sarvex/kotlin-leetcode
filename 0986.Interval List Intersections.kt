internal class Solution {
  fun intervalIntersection(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {
    val ans: List<IntArray> = ArrayList()
    val m = firstList.size
    val n = secondList.size
    var i = 0
    var j = 0
    while (i < m && j < n) {
      val l: Int = max(firstList[i][0], secondList[j][0])
      val r: Int = min(firstList[i][1], secondList[j][1])
      if (l <= r) {
        ans.add(intArrayOf(l, r))
      }
      if (firstList[i][1] < secondList[j][1]) {
        ++i
      } else {
        ++j
      }
    }
    return ans.toArray(arrayOfNulls<IntArray>(ans.size()))
  }
}
