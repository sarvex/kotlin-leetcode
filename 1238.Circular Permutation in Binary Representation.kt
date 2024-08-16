internal class Solution {
  fun circularPermutation(n: Int, start: Int): List<Int> {
    val g = IntArray(1 shl n)
    var j = 0
    for (i in 0 until (1 shl n)) {
      g[i] = i xor (i shr 1)
      if (g[i] == start) {
        j = i
      }
    }
    val ans: List<Int> = ArrayList()
    for (i in j until j + (1 shl n)) {
      ans.add(g[i % (1 shl n)])
    }
    return ans
  }
}
