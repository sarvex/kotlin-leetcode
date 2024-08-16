internal class Solution {
  fun strongPasswordChecker(password: String): Int {
    val types = countTypes(password)
    val n = password.length
    if (n < 6) {
      return max(6 - n, 3 - types)
    }
    val chars: CharArray = password.toCharArray()
    if (n <= 20) {
      var replace = 0
      var cnt = 0
      var prev = '~'
      for (curr in chars) {
        if (curr == prev) {
          ++cnt
        } else {
          replace += cnt / 3
          cnt = 1
          prev = curr
        }
      }
      replace += cnt / 3
      return max(replace, 3 - types)
    }
    var replace = 0
    var remove = n - 20
    var remove2 = 0
    var cnt = 0
    var prev = '~'
    for (curr in chars) {
      if (curr == prev) {
        ++cnt
      } else {
        if (remove > 0 && cnt >= 3) {
          if (cnt % 3 == 0) {
            --remove
            --replace
          } else if (cnt % 3 == 1) {
            ++remove2
          }
        }
        replace += cnt / 3
        cnt = 1
        prev = curr
      }
    }
    if (remove > 0 && cnt >= 3) {
      if (cnt % 3 == 0) {
        --remove
        --replace
      } else if (cnt % 3 == 1) {
        ++remove2
      }
    }
    replace += cnt / 3

    val use2: Int = min(min(replace, remove2), remove / 2)
    replace -= use2
    remove -= use2 * 2

    val use3: Int = min(replace, remove / 3)
    replace -= use3
    remove -= use3 * 3
    return (n - 20) + max(replace, 3 - types)
  }

  private fun countTypes(s: String): Int {
    var a = 0
    var b = 0
    var c = 0
    for (ch in s.toCharArray()) {
      if (Character.isLowerCase(ch)) {
        a = 1
      } else if (Character.isUpperCase(ch)) {
        b = 1
      } else if (Character.isDigit(ch)) {
        c = 1
      }
    }
    return a + b + c
  }
}
