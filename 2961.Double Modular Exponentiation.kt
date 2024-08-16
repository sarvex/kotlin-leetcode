internal class Solution {
  fun getGoodIndices(variables: Array<IntArray>, target: Int): List<Int> {
    val ans: List<Int> = ArrayList()
    for (i in variables.indices) {
      val e = variables[i]
      val a = e[0]
      val b = e[1]
      val c = e[2]
      val m = e[3]
      if (qpow(qpow(a.toLong(), b, 10).toLong(), c, m) == target) {
        ans.add(i)
      }
    }
    return ans
  }

  private fun qpow(a: Long, n: Int, mod: Int): Int {
    var a = a
    var n = n
    var ans: Long = 1
    while (n > 0) {
      if ((n and 1) == 1) {
        ans = ans * a % mod
      }
      a = a * a % mod
      n = n shr 1
    }
    return ans.toInt()
  }
}
