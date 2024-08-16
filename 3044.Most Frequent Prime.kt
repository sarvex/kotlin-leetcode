internal class Solution {
  fun mostFrequentPrime(mat: Array<IntArray>): Int {
    val m = mat.size
    val n = mat[0].size
    val cnt: Map<Int, Int> = HashMap()
    for (i in 0 until m) {
      for (j in 0 until n) {
        for (a in -1..1) {
          for (b in -1..1) {
            if (a == 0 && b == 0) {
              continue
            }
            var x: Int = i + a
            var y: Int = j + b
            var v = mat[i][j]
            while (x >= 0 && x < m && y >= 0 && y < n) {
              v = v * 10 + mat[x][y]
              if (isPrime(v)) {
                cnt.merge(v, 1) { a: Int, b: Int -> Integer.sum(a, b) }
              }
              x += a
              y += b
            }
          }
        }
      }
    }
    var ans = -1
    var mx = 0
    for (e in cnt.entrySet()) {
      val v: Int = e.getKey()
      val x: Int = e.getValue()
      if (mx < x || (mx == x && ans < v)) {
        mx = x
        ans = v
      }
    }
    return ans
  }

  private fun isPrime(n: Int): Boolean {
    for (i in 2..(n / i)) {
      if (n % i == 0) {
        return false
      }
    }
    return true
  }
}
