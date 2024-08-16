internal class Solution {
  fun reformatDate(date: String): String {
    val s: Array<String> = date.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    val months = " JanFebMarAprMayJunJulAugSepOctNovDec"
    val day: Int = s[0].substring(0, s[0].length - 2).toInt()
    val month: Int = months.indexOf(s[1]) / 3 + 1
    return String.format("%s-%02d-%02d", s[2], month, day)
  }
}
