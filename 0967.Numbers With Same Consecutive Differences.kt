internal class Solution {
  private val ans: List<Int> = ArrayList()
  private var boundary = 0
  private var k = 0

  fun numsSameConsecDiff(n: Int, k: Int): IntArray {
    this.k = k
    boundary = 10.pow(n - 1) as Int
    for (i in 1..9) {
      dfs(i)
    }
    return ans.stream().mapToInt { i -> i }.toArray()
  }

  private fun dfs(x: Int) {
    if (x >= boundary) {
      ans.add(x)
      return
    }
    val last = x % 10
    if (last + k < 10) {
      dfs(x * 10 + last + k)
    }
    if (k != 0 && last - k >= 0) {
      dfs(x * 10 + last - k)
    }
  }
}
