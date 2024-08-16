internal class Solution {
  fun isPrefixOfWord(sentence: String, searchWord: String): Int {
    val words: Array<String> = sentence.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    for (i in words.indices) {
      if (words[i].startsWith(searchWord)) {
        return i + 1
      }
    }
    return -1
  }
}
