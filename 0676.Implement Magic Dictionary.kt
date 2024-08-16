internal class Trie {
  val children: Array<Trie> = arrayOfNulls(26)
  var isEnd = false

  fun insert(w: String) {
    var node = this
    for (c in w.toCharArray()) {
      val i: Int = c.code - 'a'.code
      if (node.children[i] == null) {
        node.children[i] = Trie()
      }
      node = node.children[i]
    }
    node.isEnd = true
  }

  fun search(w: String): Boolean {
    return dfs(w, 0, this, 0)
  }

  private fun dfs(w: String, i: Int, node: Trie, diff: Int): Boolean {
    if (i == w.length) {
      return diff == 1 && node.isEnd
    }
    val j: Int = w[i].code - 'a'.code
    if (node.children[j] != null) {
      if (dfs(w, i + 1, node.children[j], diff)) {
        return true
      }
    }
    if (diff == 0) {
      for (k in 0..25) {
        if (k != j && node.children[k] != null) {
          if (dfs(w, i + 1, node.children[k], 1)) {
            return true
          }
        }
      }
    }
    return false
  }
}

internal class MagicDictionary {
  private val trie = Trie()

  fun buildDict(dictionary: Array<String>) {
    for (w in dictionary) {
      trie.insert(w)
    }
  }

  fun search(searchWord: String): Boolean {
    return trie.search(searchWord)
  }
}
/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
