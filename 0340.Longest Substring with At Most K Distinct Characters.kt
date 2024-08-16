internal class Solution {
  fun lengthOfLongestSubstringKDistinct(s: String, k: Int): Int {
    val cnt: Map<Char, Int> = HashMap()
    var l = 0
    val cs: CharArray = s.toCharArray()
    for (c in cs) {
      cnt.merge(c, 1) { a: Int, b: Int -> Integer.sum(a, b) }
      if (cnt.size() > k) {
        if (cnt.merge(cs[l], -1) { a: Int, b: Int -> Integer.sum(a, b) } === 0) {
          cnt.remove(cs[l])
        }
        ++l
      }
    }
    return cs.size - l
  }
}
