internal class Trie {
  private val children: Array<Trie> = arrayOfNulls(26)
  private var cnt = 0

  fun insert(w: String) {
    var node = this
    for (c in w.toCharArray()) {
      var c = c
      (c -= 'a').toChar()
      if (node.children[c.code] == null) {
        node.children[c.code] = Trie()
      }
      node = node.children[c.code]
      ++node.cnt
    }
  }

  fun search(w: String): Int {
    var node = this
    var ans = 0
    for (c in w.toCharArray()) {
      var c = c
      (c -= 'a').toChar()
      if (node.children[c.code] == null) {
        return ans
      }
      node = node.children[c.code]
      ans += node.cnt
    }
    return ans
  }
}

internal class Solution {
  fun sumPrefixScores(words: Array<String>): IntArray {
    val trie = Trie()
    for (w in words) {
      trie.insert(w)
    }
    val ans = IntArray(words.size)
    for (i in words.indices) {
      ans[i] = trie.search(words[i])
    }
    return ans
  }
}
