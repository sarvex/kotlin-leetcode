internal class Solution {
  fun stoneGameVI(aliceValues: IntArray, bobValues: IntArray): Int {
    val n = aliceValues.size
    val vals = Array(n) { IntArray(0) }
    for (i in 0 until n) {
      vals[i] = intArrayOf(aliceValues[i] + bobValues[i], i)
    }
    Arrays.sort(vals) { a, b -> b.get(0) - a.get(0) }
    var a = 0
    var b = 0
    for (k in 0 until n) {
      val i = vals[k][1]
      if (k % 2 == 0) {
        a += aliceValues[i]
      } else {
        b += bobValues[i]
      }
    }
    if (a == b) {
      return 0
    }
    return if (a > b) 1 else -1
  }
}
