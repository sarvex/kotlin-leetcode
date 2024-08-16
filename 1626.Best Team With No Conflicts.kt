internal class Solution {
  fun bestTeamScore(scores: IntArray, ages: IntArray): Int {
    val n = ages.size
    val arr = Array(n) { IntArray(2) }
    for (i in 0 until n) {
      arr[i] = intArrayOf(scores[i], ages[i])
    }
    Arrays.sort(arr) { a, b -> if (a.get(0) === b.get(0)) a.get(1) - b.get(1) else a.get(0) - b.get(0) }
    val f = IntArray(n)
    var ans = 0
    for (i in 0 until n) {
      for (j in 0 until i) {
        if (arr[i][1] >= arr[j][1]) {
          f[i] = max(f[i], f[j])
        }
      }
      f[i] += arr[i][0]
      ans = max(ans, f[i])
    }
    return ans
  }
}
