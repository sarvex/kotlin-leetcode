internal class Trie {
  var children: Array<Trie> = arrayOfNulls(26)
  var isEnd: Boolean = false
}

internal class WordDictionary {
  private val trie = Trie()

  fun addWord(word: String) {
    var node = trie
    for (c in word.toCharArray()) {
      val idx: Int = c.code - 'a'.code
      if (node.children[idx] == null) {
        node.children[idx] = Trie()
      }
      node = node.children[idx]
    }
    node.isEnd = true
  }

  fun search(word: String): Boolean {
    return search(word, trie)
  }

  private fun search(word: String, node: Trie): Boolean {
    var node = node
    for (i in 0 until word.length) {
      val c = word[i]
      val idx: Int = c.code - 'a'.code
      if (c != '.' && node.children[idx] == null) {
        return false
      }
      if (c == '.') {
        for (child in node.children) {
          if (child != null && search(word.substring(i + 1), child)) {
            return true
          }
        }
        return false
      }
      node = node.children[idx]
    }
    return node.isEnd
  }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
