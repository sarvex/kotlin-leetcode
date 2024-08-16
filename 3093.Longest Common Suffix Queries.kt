internal class Trie {
  private val inf = 1 shl 30
  private val children: Array<Trie> = arrayOfNulls(26)
  private var length = inf
  private var idx = inf

  fun insert(w: String, i: Int) {
    var node = this
    if (node.length > w.length) {
      node.length = w.length
      node.idx = i
    }
    for (k in w.length - 1 downTo 0) {
      val idx: Int = w[k].code - 'a'.code
      if (node.children[idx] == null) {
        node.children[idx] = Trie()
      }
      node = node.children[idx]
      if (node.length > w.length) {
        node.length = w.length
        node.idx = i
      }
    }
  }

  fun query(w: String): Int {
    var node = this
    for (k in w.length - 1 downTo 0) {
      val idx: Int = w[k].code - 'a'.code
      if (node.children[idx] == null) {
        break
      }
      node = node.children[idx]
    }
    return node.idx
  }
}

internal class Solution {
  fun stringIndices(wordsContainer: Array<String?>, wordsQuery: Array<String?>): IntArray {
    val trie = Trie()
    for (i in wordsContainer.indices) {
      trie.insert(wordsContainer[i]!!, i)
    }
    val n = wordsQuery.size
    val ans = IntArray(n)
    for (i in 0 until n) {
      ans[i] = trie.query(wordsQuery[i])
    }
    return ans
  }
}
