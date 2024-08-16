internal class Solution {
  fun checkInclusion(s1: String, s2: String): Boolean {
    val n = s1.length
    val m = s2.length
    if (n > m) {
      return false
    }
    val cnt1 = IntArray(26)
    val cnt2 = IntArray(26)
    for (i in 0 until n) {
      ++cnt1[s1[i].code - 'a'.code]
      ++cnt2[s2[i].code - 'a'.code]
    }
    if (Arrays.equals(cnt1, cnt2)) {
      return true
    }
    for (i in n until m) {
      ++cnt2[s2[i].code - 'a'.code]
      --cnt2[s2[i - n].code - 'a'.code]
      if (Arrays.equals(cnt1, cnt2)) {
        return true
      }
    }
    return false
  }
}
