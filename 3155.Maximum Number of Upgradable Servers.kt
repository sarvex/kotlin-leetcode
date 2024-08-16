internal class Solution {
  fun maxUpgrades(count: IntArray, upgrade: IntArray, sell: IntArray, money: IntArray): IntArray {
    val n = count.size
    val ans = IntArray(n)
    for (i in 0 until n) {
      ans[i] = min(
        count[i], ((1L * count[i] * sell[i] + money[i]) / (upgrade[i] + sell[i])).toInt()
      )
    }
    return ans
  }
}
