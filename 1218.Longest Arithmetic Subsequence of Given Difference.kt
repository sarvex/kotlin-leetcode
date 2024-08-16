internal class Solution {
  fun longestSubsequence(arr: IntArray, difference: Int): Int {
    val f: Map<Int, Int> = HashMap()
    var ans = 0
    for (x in arr) {
      f.put(x, f.getOrDefault(x - difference, 0) + 1)
      ans = Math.max(ans, f[x]!!)
    }
    return ans
  }
}
