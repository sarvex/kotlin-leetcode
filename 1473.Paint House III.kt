internal class Solution {
  fun minCost(houses: IntArray, cost: Array<IntArray>, m: Int, n: Int, target: Int): Int {
    val f = Array(m) { Array(n + 1) { IntArray(target + 1) } }
    val inf = 1 shl 30
    for (g in f) {
      for (e in g) {
        Arrays.fill(e, inf)
      }
    }
    if (houses[0] == 0) {
      for (j in 1..n) {
        f[0][j][1] = cost[0][j - 1]
      }
    } else {
      f[0][houses[0]][1] = 0
    }
    for (i in 1 until m) {
      if (houses[i] == 0) {
        for (j in 1..n) {
          for (k in 1..min(target, i + 1)) {
            for (j0 in 1..n) {
              if (j == j0) {
                f[i][j][k] = min(f[i][j][k], f[i - 1][j][k] + cost[i][j - 1])
              } else {
                f[i][j][k]
                = min(f[i][j][k], f[i - 1][j0][k - 1] + cost[i][j - 1])
              }
            }
          }
        }
      } else {
        val j = houses[i]
        for (k in 1..min(target, i + 1)) {
          for (j0 in 1..n) {
            if (j == j0) {
              f[i][j][k] = min(f[i][j][k], f[i - 1][j][k])
            } else {
              f[i][j][k] = min(f[i][j][k], f[i - 1][j0][k - 1])
            }
          }
        }
      }
    }
    var ans = inf
    for (j in 1..n) {
      ans = min(ans, f[m - 1][j][target])
    }
    return if (ans >= inf) -1 else ans
  }
}
