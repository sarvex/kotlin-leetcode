internal class Solution {
  fun fractionToDecimal(numerator: Int, denominator: Int): String {
    if (numerator == 0) {
      return "0"
    }
    val sb = StringBuilder()
    val neg = (numerator > 0) xor (denominator > 0)
    sb.append(if (neg) "-" else "")
    var a: Long = abs(numerator.toLong())
    val b: Long = abs(denominator.toLong())
    sb.append(a / b)
    a %= b
    if (a == 0L) {
      return sb.toString()
    }
    sb.append(".")
    val d: Map<Long, Int> = HashMap()
    while (a != 0L) {
      d.put(a, sb.length)
      a *= 10
      sb.append(a / b)
      a %= b
      if (d.containsKey(a)) {
        sb.insert(d[a]!!, "(")
        sb.append(")")
        break
      }
    }
    return sb.toString()
  }
}
