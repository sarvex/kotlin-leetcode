internal class Solution {
  fun findRightInterval(intervals: Array<IntArray>): IntArray {
    val n = intervals.size
    val arr = Array(n) { IntArray(0) }
    for (i in 0 until n) {
      arr[i] = intArrayOf(intervals[i][0], i)
    }
    Arrays.sort(arr) { a, b -> a.get(0) - b.get(0) }
    val ans = IntArray(n)
    for (i in 0 until n) {
      val j = search(arr, intervals[i][1])
      ans[i] = if (j < n) arr[j][1] else -1
    }
    return ans
  }

  private fun search(arr: Array<IntArray>, x: Int): Int {
    var l = 0
    var r = arr.size
    while (l < r) {
      val mid = (l + r) shr 1
      if (arr[mid][0] >= x) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l
  }
}
