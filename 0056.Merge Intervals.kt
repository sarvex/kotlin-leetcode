internal class Solution {
  fun merge(intervals: Array<IntArray>): Array<IntArray> {
    Arrays.sort(intervals, Comparator.comparingInt { a -> a.get(0) })
    var st = intervals[0][0]
    var ed = intervals[0][1]
    val ans: List<IntArray> = ArrayList()
    for (i in 1 until intervals.size) {
      val s = intervals[i][0]
      val e = intervals[i][1]
      if (ed < s) {
        ans.add(intArrayOf(st, ed))
        st = s
        ed = e
      } else {
        ed = max(ed, e)
      }
    }
    ans.add(intArrayOf(st, ed))
    return ans.toArray(arrayOfNulls<IntArray>(ans.size()))
  }
}
