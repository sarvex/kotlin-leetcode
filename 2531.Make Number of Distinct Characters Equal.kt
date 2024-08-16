internal class Solution {
  fun isItPossible(word1: String, word2: String): Boolean {
    val cnt1 = IntArray(26)
    val cnt2 = IntArray(26)
    var x = 0
    var y = 0
    for (i in 0 until word1.length) {
      if (++cnt1[word1[i].code - 'a'.code] == 1) {
        ++x
      }
    }
    for (i in 0 until word2.length) {
      if (++cnt2[word2[i].code - 'a'.code] == 1) {
        ++y
      }
    }
    for (i in 0..25) {
      for (j in 0..25) {
        if (cnt1[i] > 0 && cnt2[j] > 0) {
          if (i == j) {
            if (x == y) {
              return true
            }
          } else {
            val a = x - (if (cnt1[i] == 1) 1 else 0) + (if (cnt1[j] == 0) 1 else 0)
            val b = y - (if (cnt2[j] == 1) 1 else 0) + (if (cnt2[i] == 0) 1 else 0)
            if (a == b) {
              return true
            }
          }
        }
      }
    }
    return false
  }
}
