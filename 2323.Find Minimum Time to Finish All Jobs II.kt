import java.util.*

internal class Solution {
  fun minimumTime(jobs: IntArray, workers: IntArray): Int {
    Arrays.sort(jobs)
    Arrays.sort(workers)
    var ans = 0
    for (i in jobs.indices) {
      ans = max(ans, (jobs[i] + workers[i] - 1) / workers[i])
    }
    return ans
  }
}
