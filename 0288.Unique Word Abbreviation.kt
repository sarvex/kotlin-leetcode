internal class ValidWordAbbr(dictionary: Array<String>) {
  private val d: Map<String, Set<String>> = HashMap()

  init {
    for (s in dictionary) {
      d.computeIfAbsent(abbr(s)) { k -> HashSet() }.add(s)
    }
  }

  fun isUnique(word: String): Boolean {
    val ws: Unit = d[abbr(word)]
    return ws == null || (ws.size() === 1 && ws.contains(word))
  }

  private fun abbr(s: String): String {
    val n = s.length
    return if (n < 3) s else s.substring(0, 1) + (n - 2) + s.substring(n - 1)
  }
}
/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
