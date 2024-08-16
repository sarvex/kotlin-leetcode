internal class Solution {
  fun halvesAreAlike(s: String): Boolean {
    val vowels: Set<Char> = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    val n = s.length shr 1
    var cnt = 0
    for (i in 0 until n) {
      cnt += if (vowels.contains(s[i])) 1 else 0
      cnt -= if (vowels.contains(s[i + n])) 1 else 0
    }
    return cnt == 0
  }
}
