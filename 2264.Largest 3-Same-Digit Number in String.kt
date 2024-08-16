internal class Solution {
  fun largestGoodInteger(num: String): String {
    for (i in 9 downTo 0) {
      val s: String = i.toString().repeat(3)
      if (num.contains(s)) {
        return s
      }
    }
    return ""
  }
}
