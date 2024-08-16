internal class Solution {
  fun checkIfPangram(sentence: String): Boolean {
    val vis = BooleanArray(26)
    for (i in 0 until sentence.length) {
      vis[sentence[i].code - 'a'.code] = true
    }
    for (v in vis) {
      if (!v) {
        return false
      }
    }
    return true
  }
}
