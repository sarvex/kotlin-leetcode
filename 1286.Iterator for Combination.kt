internal class CombinationIterator(private val characters: String, private val combinationLength: Int) {
  private val n = characters.length
  private val t = StringBuilder()
  private val cs: List<String> = ArrayList()
  private var idx = 0

  init {
    dfs(0)
  }

  fun next(): String {
    return cs[idx++]
  }

  fun hasNext(): Boolean {
    return idx < cs.size()
  }

  private fun dfs(i: Int) {
    if (t.length == combinationLength) {
      cs.add(t.toString())
      return
    }
    if (i == n) {
      return
    }
    t.append(characters[i])
    dfs(i + 1)
    t.deleteCharAt(t.length - 1)
    dfs(i + 1)
  }
}
/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
