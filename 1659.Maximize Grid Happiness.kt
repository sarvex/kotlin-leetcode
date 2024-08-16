internal class Solution {
  private var m = 0
  private var mx = 0
  private var f: IntArray
  private var g: Array<IntArray>
  private var bits: Array<IntArray>
  private var ix: IntArray
  private var ex: IntArray
  private var memo: Array<Array<Array<Array<Int>>>>
  private val h = arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, -60, -10), intArrayOf(0, -10, 40))

  fun getMaxGridHappiness(m: Int, n: Int, introvertsCount: Int, extrovertsCount: Int): Int {
    this.m = m
    mx = 3.pow(n) as Int
    f = IntArray(mx)
    g = Array(mx) { IntArray(mx) }
    bits = Array(mx) { IntArray(n) }
    ix = IntArray(mx)
    ex = IntArray(mx)
    memo = Array(m) { Array(mx) { Array(introvertsCount + 1) { arrayOfNulls(extrovertsCount + 1) } } }
    for (i in 0 until mx) {
      var mask: Int = i
      for (j in 0 until n) {
        val x = mask % 3
        mask /= 3
        bits[i][j] = x
        if (x == 1) {
          ix[i]++
          f[i] += 120
        } else if (x == 2) {
          ex[i]++
          f[i] += 40
        }
        if (j > 0) {
          f[i] += h[x][bits[i][j - 1]]
        }
      }
    }
    for (i in 0 until mx) {
      for (j in 0 until mx) {
        for (k in 0 until n) {
          g[i][j] += h[bits[i][k]][bits[j][k]]
        }
      }
    }
    return dfs(0, 0, introvertsCount, extrovertsCount)
  }

  private fun dfs(i: Int, pre: Int, ic: Int, ec: Int): Int {
    if (i == m || (ic == 0 && ec == 0)) {
      return 0
    }
    if (memo[i][pre][ic][ec] != null) {
      return memo[i][pre][ic][ec]
    }
    var ans = 0
    for (cur in 0 until mx) {
      if (ix[cur] <= ic && ex[cur] <= ec) {
        ans = max(
          ans, f[cur] + g[pre][cur] + dfs(i + 1, cur, ic - ix[cur], ec - ex[cur])
        )
      }
    }
    return ans.also { memo[i][pre][ic][ec] = it }
  }
}
