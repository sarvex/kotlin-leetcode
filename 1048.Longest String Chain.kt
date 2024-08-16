internal class Solution {
  fun longestStrChain(words: Array<String>): Int {
    Arrays.sort(words, Comparator.comparingInt(java.lang.String::length))
    var res = 0
    val map: Map<String, Int> = HashMap()
    for (word in words) {
      var x = 1
      for (i in 0 until word.length) {
        val pre: String = word.substring(0, i) + word.substring(i + 1)
        x = Math.max(x, map.getOrDefault(pre, 0) + 1)
      }
      map.put(word, x)
      res = max(res, x)
    }
    return res
  }
}
