internal open class Node {
  var children: Map<Int, Node> = HashMap()
  var cnt: Int = 0
}

internal class Solution {
  fun countPrefixSuffixPairs(words: Array<String>): Long {
    var ans: Long = 0
    val trie = Node()
    for (s in words) {
      var node = trie
      val m = s.length
      for (i in 0 until m) {
        val p: Int = s[i].code * 32 + s[m - i - 1].code
        node.children.putIfAbsent(p, Node())
        node = node.children.get(p)
        ans += node.cnt.toLong()
      }
      ++node.cnt
    }
    return ans
  }
}
