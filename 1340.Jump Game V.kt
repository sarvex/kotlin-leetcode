internal class Solution {
  private var n = 0
  private var d = 0
  private var arr: IntArray
  private var f: Array<Int>

  fun maxJumps(arr: IntArray, d: Int): Int {
    n = arr.size
    this.d = d
    this.arr = arr
    f = arrayOfNulls(n)
    var ans = 1
    for (i in 0 until n) {
      ans = max(ans, dfs(i))
    }
    return ans
  }

  private fun dfs(i: Int): Int {
    if (f[i] != null) {
      return f[i]
    }
    var ans = 1
    for (j in i - 1 downTo 0) {
      if (i - j > d || arr[j] >= arr[i]) {
        break
      }
      ans = max(ans, 1 + dfs(j))
    }
    for (j in i + 1 until n) {
      if (j - i > d || arr[j] >= arr[i]) {
        break
      }
      ans = max(ans, 1 + dfs(j))
    }
    return ans.also { f[i] = it }
  }
}
