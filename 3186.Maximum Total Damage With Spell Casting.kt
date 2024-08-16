import java.util.*

internal class Solution {
  private var f: Array<Long>
  private var power: IntArray
  private var cnt: Map<Int, Int>? = null
  private var nxt: IntArray
  private var n = 0

  fun maximumTotalDamage(power: IntArray): Long {
    Arrays.sort(power)
    this.power = power
    n = power.size
    f = arrayOfNulls(n)
    cnt = HashMap(n)
    nxt = IntArray(n)
    for (i in 0 until n) {
      cnt.merge(power[i], 1) { a: Int, b: Int -> Integer.sum(a, b) }
      var l = Arrays.binarySearch(power, power[i] + 3)
      l = if (l < 0) -l - 1 else l
      nxt[i] = l
    }
    return dfs(0)
  }

  private fun dfs(i: Int): Long {
    if (i >= n) {
      return 0
    }
    if (f[i] != null) {
      return f[i]
    }
    val a = dfs(i + cnt!![power[i]]!!)
    val b = 1L * power[i] * cnt!![power[i]]!! + dfs(nxt[i])
    return max(a, b).also { f[i] = it }
  }
}
