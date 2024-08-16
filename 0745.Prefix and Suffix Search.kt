internal class WordFilter(words: Array<String>) {
  private val d: Map<String, Int> = HashMap()

  init {
    for (k in words.indices) {
      val w = words[k]
      val n = w.length
      for (i in 0..n) {
        val a: String = w.substring(0, i)
        for (j in 0..n) {
          val b: String = w.substring(j)
          d.put("$a.$b", k)
        }
      }
    }
  }

  fun f(pref: String, suff: String): Int {
    return d.getOrDefault("$pref.$suff", -1)
  }
}
/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */
