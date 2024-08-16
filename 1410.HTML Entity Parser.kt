internal class Solution {
  fun entityParser(text: String): String {
    val d: Map<String, String> = HashMap()
    d.put("&quot;", "\"")
    d.put("&apos;", "'")
    d.put("&amp;", "&")
    d.put("&gt;", ">")
    d.put("&lt;", "<")
    d.put("&frasl;", "/")
    val ans = StringBuilder()
    var i = 0
    val n = text.length
    while (i < n) {
      var found = false
      for (l in 1..7) {
        val j = i + l
        if (j <= n) {
          val t: String = text.substring(i, j)
          if (d.containsKey(t)) {
            ans.append(d[t])
            i = j
            found = true
            break
          }
        }
      }
      if (!found) {
        ans.append(text[i++])
      }
    }
    return ans.toString()
  }
}
