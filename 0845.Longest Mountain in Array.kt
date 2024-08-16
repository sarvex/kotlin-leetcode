internal class Solution {
  fun longestMountain(arr: IntArray): Int {
    val n = arr.size
    val f = IntArray(n)
    val g = IntArray(n)
    Arrays.fill(f, 1)
    Arrays.fill(g, 1)
    for (i in 1 until n) {
      if (arr[i] > arr[i - 1]) {
        f[i] = f[i - 1] + 1
      }
    }
    var ans = 0
    for (i in n - 2 downTo 0) {
      if (arr[i] > arr[i + 1]) {
        g[i] = g[i + 1] + 1
        if (f[i] > 1) {
          ans = max(ans, f[i] + g[i] - 1)
        }
      }
    }
    return ans
  }
}
