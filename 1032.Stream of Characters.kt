internal class Trie {
  var children: Array<Trie> = arrayOfNulls(26)
  var isEnd: Boolean = false

  fun insert(w: String) {
    var node = this
    for (i in w.length - 1 downTo 0) {
      val idx: Int = w[i].code - 'a'.code
      if (node.children[idx] == null) {
        node.children[idx] = Trie()
      }
      node = node.children[idx]
    }
    node.isEnd = true
  }

  fun query(s: StringBuilder): Boolean {
    var node = this
    for (i in s.length - 1 downTo 0) {
      val idx: Int = s[i].code - 'a'.code
      if (node.children[idx] == null) {
        return false
      }
      node = node.children[idx]
      if (node.isEnd) {
        return true
      }
    }
    return false
  }
}

internal class StreamChecker(words: Array<String>) {
  private val sb = StringBuilder()
  private val trie = Trie()

  init {
    for (w in words) {
      trie.insert(w)
    }
  }

  fun query(letter: Char): Boolean {
    sb.append(letter)
    return trie.query(sb)
  }
}
/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
