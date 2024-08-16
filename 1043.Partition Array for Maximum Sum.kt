internal class Solution {
  fun maxSumAfterPartitioning(arr: IntArray, k: Int): Int {
    val n = arr.size
    val f = IntArray(n + 1)
    for (i in 1..n) {
      var mx = 0
      for (j in i downTo max(0, i - k) + 1) {
        mx = max(mx, arr[j - 1])
        f[i] = max(f[i], f[j - 1] + mx * (i - j + 1))
      }
    }
    return f[n]
  }
}
