internal class Solution {
  fun findWordsContaining(words: Array<String>, x: Char): List<Int> {
    val ans: List<Int> = ArrayList()
    for (i in words.indices) {
      if (words[i].indexOf(x) != -1) {
        ans.add(i)
      }
    }
    return ans
  }
}
