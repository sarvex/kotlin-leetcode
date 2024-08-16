internal class Solution {
  fun minimumOperationsToMakeKPeriodic(word: String, k: Int): Int {
    val cnt: Map<String, Int> = HashMap()
    val n = word.length
    var mx = 0
    var i = 0
    while (i < n) {
      mx = Math.max(mx, cnt.merge(word.substring(i, i + k), 1) { a: Int, b: Int ->
        Integer.sum(
          a,
          b
        )
      })
      i += k
    }
    return n / k - mx
  }
}
