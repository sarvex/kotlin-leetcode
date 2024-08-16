internal class Solution {
  private var word: String? = null
  private var n = 0

  fun generateAbbreviations(word: String): List<String> {
    this.word = word
    n = word.length
    return dfs(0)
  }

  private fun dfs(i: Int): List<String> {
    if (i >= n) {
      return List.of("")
    }
    val ans: List<String> = ArrayList()
    for (s in dfs(i + 1)) {
      ans.add(word!![i].toString() + s)
    }
    for (j in i + 1..n) {
      for (s in dfs(j + 1)) {
        ans.add((j - i).toString() + "" + (if (j < n) word!![j].toString() else "") + s)
      }
    }
    return ans
  }
}
