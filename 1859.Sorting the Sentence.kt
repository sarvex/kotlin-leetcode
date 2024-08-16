internal class Solution {
  fun sortSentence(s: String): String {
    val ws: Array<String> = s.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    val n = ws.size
    val ans: Array<String> = arrayOfNulls(n)
    for (i in 0 until n) {
      val w = ws[i]
      ans[w[w.length - 1].code - '1'.code] = w.substring(0, w.length - 1)
    }
    return java.lang.String.join(" ", *ans)
  }
}
