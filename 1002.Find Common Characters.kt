internal class Solution {
  fun commonChars(words: Array<String>): List<String> {
    val cnt = IntArray(26)
    Arrays.fill(cnt, 20000)
    for (w in words) {
      val t = IntArray(26)
      for (i in 0 until w.length) {
        ++t[w[i].code - 'a'.code]
      }
      for (i in 0..25) {
        cnt[i] = min(cnt[i], t[i])
      }
    }
    val ans: List<String> = ArrayList()
    for (i in 0..25) {
      ans.addAll(Collections.nCopies(cnt[i], ('a'.code + i).toChar().toString()))
    }
    return ans
  }
}
