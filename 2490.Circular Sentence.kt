internal class Solution {
  fun isCircularSentence(sentence: String): Boolean {
    val ss: Array<String> = sentence.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    val n = ss.size
    for (i in 0 until n) {
      if (ss[i][ss[i].length - 1] != ss[(i + 1) % n][0]) {
        return false
      }
    }
    return true
  }
}
