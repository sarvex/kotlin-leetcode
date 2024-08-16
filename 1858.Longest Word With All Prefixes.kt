internal class Trie {
  private val children: Array<Trie> = arrayOfNulls(26)
  private var isEnd = false

  fun insert(w: String) {
    var node = this
    for (c in w.toCharArray()) {
      val idx: Int = c.code - 'a'.code
      if (node.children[idx] == null) {
        node.children[idx] = Trie()
      }
      node = node.children[idx]
    }
    node.isEnd = true
  }

  fun search(w: String): Boolean {
    var node = this
    for (c in w.toCharArray()) {
      val idx: Int = c.code - 'a'.code
      node = node.children[idx]
      if (!node.isEnd) {
        return false
      }
    }
    return true
  }
}

internal class Solution {
  fun longestWord(words: Array<String>): String {
    val trie = Trie()
    for (w in words) {
      trie.insert(w)
    }
    var ans = ""
    for (w in words) {
      if ((w.length > ans.length || (w.length == ans.length && w.compareTo(ans) < 0))
        && trie.search(w)
      ) {
        ans = w
      }
    }
    return ans
  }
}
