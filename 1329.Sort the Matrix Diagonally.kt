internal class Solution {
  fun diagonalSort(mat: Array<IntArray>): Array<IntArray> {
    val m = mat.size
    val n = mat[0].size
    val g: Array<List<Int>> = arrayOfNulls(m + n)
    Arrays.setAll(g) { k -> ArrayList() }
    for (i in 0 until m) {
      for (j in 0 until n) {
        g[m - i + j].add(mat[i][j])
      }
    }
    for (e in g) {
      Collections.sort(e) { a, b -> b - a }
    }
    for (i in 0 until m) {
      for (j in 0 until n) {
        mat[i][j] = g[m - i + j].removeLast()
      }
    }
    return mat
  }
}
