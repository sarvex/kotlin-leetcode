internal class Solution {
  fun dayOfYear(date: String): Int {
    val y: Int = date.substring(0, 4).toInt()
    val m: Int = date.substring(5, 7).toInt()
    val d: Int = date.substring(8).toInt()
    val v = if (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)) 29 else 28
    val days = intArrayOf(31, v, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    var ans = d
    for (i in 0 until m - 1) {
      ans += days[i]
    }
    return ans
  }
}
