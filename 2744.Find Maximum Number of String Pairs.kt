internal class Solution {
  fun maximumNumberOfStringPairs(words: Array<String>): Int {
    val cnt: Map<Int, Int> = HashMap()
    var ans = 0
    for (w in words) {
      val a: Int = w[0].code - 'a'.code
      val b: Int = w[1].code - 'a'.code
      ans += cnt.getOrDefault(b shl 5 or a, 0)
      cnt.merge(a shl 5 or b, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    return ans
  }
}
