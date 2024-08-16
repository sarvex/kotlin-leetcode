internal class Solution {
  fun replaceWords(dictionary: List<String?>?, sentence: String): String {
    val s: Set<String> = HashSet(dictionary)
    val words: Array<String> = sentence.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    for (i in words.indices) {
      val word = words[i]
      for (j in 1..word.length) {
        val t: String = word.substring(0, j)
        if (s.contains(t)) {
          words[i] = t
          break
        }
      }
    }
    return java.lang.String.join(" ", *words)
  }
}
