internal class Solution {
  fun complexNumberMultiply(num1: String, num2: String): String {
    val x = parse(num1)
    val y = parse(num2)
    val a1 = x[0]
    val b1 = x[1]
    val a2 = y[0]
    val b2 = y[1]
    return (a1 * a2 - b1 * b2).toString() + "+" + (a1 * b2 + a2 * b1) + "i"
  }

  private fun parse(s: String): IntArray {
    val cs: Array<String> =
      s.substring(0, s.length - 1).split("\\+".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    return intArrayOf(cs[0].toInt(), cs[1].toInt())
  }
}
