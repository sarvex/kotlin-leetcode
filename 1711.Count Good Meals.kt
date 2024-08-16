internal class Solution {
  fun countPairs(deliciousness: IntArray): Int {
    val mx: Int = Arrays.stream(deliciousness).max().getAsInt() shl 1
    var ans = 0
    val cnt: Map<Int, Int> = HashMap()
    for (d in deliciousness) {
      var s = 1
      while (s <= mx) {
        ans = (ans + cnt.getOrDefault(s - d, 0)) % Solution.Companion.MOD
        s = s shl 1
      }
      cnt.merge(d, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    return ans
  }

  companion object {
    private const val MOD = 1e9.toInt() + 7
  }
}
