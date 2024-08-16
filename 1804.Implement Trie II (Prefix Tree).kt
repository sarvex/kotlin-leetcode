internal class Trie {
  private val children: Array<Trie> = arrayOfNulls(26)
  private var v = 0
  private var pv = 0

  fun insert(word: String) {
    var node = this
    for (c in word.toCharArray()) {
      var c = c
      (c -= 'a').toChar()
      if (node.children[c.code] == null) {
        node.children[c.code] = Trie()
      }
      node = node.children[c.code]
      ++node.pv
    }
    ++node.v
  }

  fun countWordsEqualTo(word: String): Int {
    val node = search(word)
    return if (node == null) 0 else node.v
  }

  fun countWordsStartingWith(prefix: String): Int {
    val node = search(prefix)
    return if (node == null) 0 else node.pv
  }

  fun erase(word: String) {
    var node = this
    for (c in word.toCharArray()) {
      var c = c
      (c -= 'a').toChar()
      node = node.children[c]
      --node.pv
    }
    --node.v
  }

  private fun search(word: String): Trie? {
    var node = this
    for (c in word.toCharArray()) {
      var c = c
      (c -= 'a').toChar()
      if (node.children[c.code] == null) {
        return null
      }
      node = node.children[c.code]
    }
    return node
  }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */
