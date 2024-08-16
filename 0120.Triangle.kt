internal class Solution {
  fun minimumTotal(triangle: List<List<Int>>): Int {
    val n: Int = triangle.size()
    val f = IntArray(n + 1)
    for (i in n - 1 downTo 0) {
      for (j in 0..i) {
        f[j] = min(f[j], f[j + 1]) + triangle[i][j]
      }
    }
    return f[0]
  }
}
