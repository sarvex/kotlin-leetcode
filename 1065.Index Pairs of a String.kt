internal class Trie {
  @kotlin.jvm.JvmField
  var children: Array<Trie> = arrayOfNulls(26)
  @kotlin.jvm.JvmField
  var isEnd: Boolean = false

  fun insert(word: String) {
    var node = this
    for (c in word.toCharArray()) {
      var c = c
      (c -= 'a').toChar()
      if (node.children[c.code] == null) {
        node.children[c.code] = Trie()
      }
      node = node.children[c.code]
    }
    node.isEnd = true
  }
}

internal class Solution {
  fun indexPairs(text: String, words: Array<String>): Array<IntArray> {
    val trie = Trie()
    for (w in words) {
      trie.insert(w)
    }
    val n = text.length
    val ans: List<IntArray> = ArrayList()
    for (i in 0 until n) {
      var node = trie
      for (j in i until n) {
        val idx: Int = text[j].code - 'a'.code
        if (node.children[idx] == null) {
          break
        }
        node = node.children[idx]
        if (node.isEnd) {
          ans.add(intArrayOf(i, j))
        }
      }
    }
    return ans.toArray(Array(ans.size()) { IntArray(2) })
  }
}
