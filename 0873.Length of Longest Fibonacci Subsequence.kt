internal class Solution {
  fun lenLongestFibSubseq(arr: IntArray): Int {
    val n = arr.size
    val f = Array(n) { IntArray(n) }
    val d: Map<Int, Int> = HashMap()
    for (i in 0 until n) {
      d.put(arr[i], i)
      for (j in 0 until i) {
        f[i][j] = 2
      }
    }
    var ans = 0
    for (i in 2 until n) {
      for (j in 1 until i) {
        val t = arr[i] - arr[j]
        val k = d[t]
        if (k != null && k < j) {
          f[i][j] = max(f[i][j], f[j][k] + 1)
          ans = max(ans, f[i][j])
        }
      }
    }
    return ans
  }
}
