internal class Solution {
  fun maxProfitAssignment(difficulty: IntArray, profit: IntArray, worker: IntArray): Int {
    Arrays.sort(worker)
    val n = profit.size
    val jobs = Array(n) { IntArray(0) }
    for (i in 0 until n) {
      jobs[i] = intArrayOf(difficulty[i], profit[i])
    }
    Arrays.sort(jobs) { a, b -> a.get(0) - b.get(0) }
    var ans = 0
    var mx = 0
    var i = 0
    for (w in worker) {
      while (i < n && jobs[i][0] <= w) {
        mx = max(mx, jobs[i++][1])
      }
      ans += mx
    }
    return ans
  }
}
