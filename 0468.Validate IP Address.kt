internal class Solution {
  fun validIPAddress(queryIP: String): String {
    if (isIPv4(queryIP)) {
      return "IPv4"
    }
    if (isIPv6(queryIP)) {
      return "IPv6"
    }
    return "Neither"
  }

  private fun isIPv4(s: String): Boolean {
    if (s.endsWith(".")) {
      return false
    }
    val ss: Array<String> = s.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    if (ss.size != 4) {
      return false
    }
    for (t in ss) {
      if (t.length == 0 || t.length > 1 && t[0] == '0') {
        return false
      }
      val x = convert(t)
      if (x < 0 || x > 255) {
        return false
      }
    }
    return true
  }

  private fun isIPv6(s: String): Boolean {
    if (s.endsWith(":")) {
      return false
    }
    val ss: Array<String> = s.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    if (ss.size != 8) {
      return false
    }
    for (t in ss) {
      if (t.length < 1 || t.length > 4) {
        return false
      }
      for (c in t.toCharArray()) {
        if (!Character.isDigit(c)
          && !"0123456789abcdefABCDEF".contains(c.toString())
        ) {
          return false
        }
      }
    }
    return true
  }

  private fun convert(s: String): Int {
    var x = 0
    for (c in s.toCharArray()) {
      if (!Character.isDigit(c)) {
        return -1
      }
      x = x * 10 + (c.code - '0'.code)
      if (x > 255) {
        return x
      }
    }
    return x
  }
}
