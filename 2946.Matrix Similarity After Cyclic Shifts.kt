internal class Solution {
  fun areSimilar(mat: Array<IntArray>, k: Int): Boolean {
    var k = k
    val m = mat.size
    val n = mat[0].size
    k %= n
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (i % 2 == 1 && mat[i][j] != mat[i][(j + k) % n]) {
          return false
        }
        if (i % 2 == 0 && mat[i][j] != mat[i][(j - k + n) % n]) {
          return false
        }
      }
    }
    return true
  }
}
