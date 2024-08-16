internal class Solution {
  fun isValid(word: String): Boolean {
    if (word.length < 3) {
      return false
    }
    var hasVowel = false
    var hasConsonant = false
    val vs = BooleanArray(26)
    for (c in "aeiou".toCharArray()) {
      vs[c.code - 'a'.code] = true
    }
    for (c in word.toCharArray()) {
      if (Character.isAlphabetic(c.code)) {
        if (vs[c.lowercaseChar() - 'a']) {
          hasVowel = true
        } else {
          hasConsonant = true
        }
      } else if (!Character.isDigit(c)) {
        return false
      }
    }
    return hasVowel && hasConsonant
  }
}
