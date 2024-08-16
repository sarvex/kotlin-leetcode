internal class Solution {
  private var jobs: Array<IntArray>
  private var f: IntArray
  private var n = 0

  fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
    n = profit.size
    jobs = Array(n) { IntArray(3) }
    for (i in 0 until n) {
      jobs[i] = intArrayOf(startTime[i], endTime[i], profit[i])
    }
    Arrays.sort(jobs) { a, b -> a.get(0) - b.get(0) }
    f = IntArray(n)
    return dfs(0)
  }

  private fun dfs(i: Int): Int {
    if (i >= n) {
      return 0
    }
    if (f[i] != 0) {
      return f[i]
    }
    val e = jobs[i][1]
    val p = jobs[i][2]
    val j = search(jobs, e, i + 1)
    val ans: Int = max(dfs(i + 1), p + dfs(j))
    f[i] = ans
    return ans
  }

  private fun search(jobs: Array<IntArray>, x: Int, i: Int): Int {
    var left = i
    var right = n
    while (left < right) {
      val mid = (left + right) shr 1
      if (jobs[mid][0] >= x) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }
}
