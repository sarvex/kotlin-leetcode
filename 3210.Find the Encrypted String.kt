internal class Solution {
  fun getEncryptedString(s: String, k: Int): String {
    val cs: CharArray = s.toCharArray()
    val n = cs.size
    for (i in 0 until n) {
      cs[i] = s[(i + k) % n]
    }
    return String(cs)
  }
}
