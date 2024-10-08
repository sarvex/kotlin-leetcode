internal class Solution {
  private var n = 0
  private var m = 0
  private var filled: IntArray
  private var ans = 0

  fun tilingRectangle(n: Int, m: Int): Int {
    this.n = n
    this.m = m
    ans = n * m
    filled = IntArray(n)
    dfs(0, 0, 0)
    return ans
  }

  private fun dfs(i: Int, j: Int, t: Int) {
    var i = i
    var j = j
    if (j == m) {
      ++i
      j = 0
    }
    if (i == n) {
      ans = t
      return
    }
    if ((filled[i] shr j and 1) == 1) {
      dfs(i, j + 1, t)
    } else if (t + 1 < ans) {
      var r = 0
      var c = 0
      for (k in i until n) {
        if ((filled[k] shr j and 1) == 1) {
          break
        }
        ++r
      }
      for (k in j until m) {
        if ((filled[i] shr k and 1) == 1) {
          break
        }
        ++c
      }
      val mx: Int = min(r, c)
      for (w in 1..mx) {
        for (k in 0 until w) {
          filled[i + w - 1] = filled[i + w - 1] or (1 shl (j + k))
          filled[i + k] = filled[i + k] or (1 shl (j + w - 1))
        }
        dfs(i, j + w, t + 1)
      }
      for (x in i until i + mx) {
        for (y in j until j + mx) {
          filled[x] = filled[x] xor (1 shl y)
        }
      }
    }
  }
}
