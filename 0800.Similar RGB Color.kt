internal class Solution {
  fun similarRGB(color: String): String {
    val a: String = color.substring(1, 3)
    val b: String = color.substring(3, 5)
    val c: String = color.substring(5, 7)
    return "#" + f(a) + f(b) + f(c)
  }

  private fun f(x: String): String {
    var q: Int = x.toInt(16)
    q = q / 17 + (if (q % 17 > 8) 1 else 0)
    return String.format("%02x", 17 * q)
  }
}
