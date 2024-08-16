internal class Solution {
  fun subdomainVisits(cpdomains: Array<String>): List<String> {
    val cnt: Map<String, Int> = HashMap()
    for (s in cpdomains) {
      var i: Int = s.indexOf(" ")
      val v: Int = s.substring(0, i).toInt()
      while (i < s.length) {
        if (s[i] == ' ' || s[i] == '.') {
          val t: String = s.substring(i + 1)
          cnt.put(t, cnt.getOrDefault(t, 0) + v)
        }
        ++i
      }
    }
    val ans: List<String> = ArrayList()
    for (e in cnt.entrySet()) {
      ans.add(e.getValue() + " " + e.getKey())
    }
    return ans
  }
}
