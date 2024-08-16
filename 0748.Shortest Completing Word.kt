internal class Solution {
  fun shortestCompletingWord(licensePlate: String, words: Array<String>): String {
    val cnt = IntArray(26)
    for (i in 0 until licensePlate.length) {
      val c = licensePlate[i]
      if (Character.isLetter(c)) {
        cnt[c.lowercaseChar() - 'a']++
      }
    }
    var ans = ""
    for (w in words) {
      if (!ans.isEmpty() && w.length >= ans.length) {
        continue
      }
      val t = IntArray(26)
      for (i in 0 until w.length) {
        t[w[i].code - 'a'.code]++
      }
      var ok = true
      for (i in 0..25) {
        if (t[i] < cnt[i]) {
          ok = false
          break
        }
      }
      if (ok) {
        ans = w
      }
    }
    return ans
  }
}
