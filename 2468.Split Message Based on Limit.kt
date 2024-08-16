internal class Solution {
  fun splitMessage(message: String, limit: Int): Array<String> {
    val n = message.length
    var sa = 0
    var ans: Array<String> = arrayOfNulls(0)
    for (k in 1..n) {
      val lk = (k.toString() + "").length
      sa += lk
      val sb = lk * k
      val sc = 3 * k
      if (limit * k - (sa + sb + sc) >= n) {
        var i = 0
        ans = arrayOfNulls(k)
        for (j in 1..k) {
          val tail: String = String.format("<%d/%d>", j, k)
          val t: String = message.substring(i, min(n, i + limit - tail.length)) + tail
          ans[j - 1] = t
          i += limit - tail.length
        }
        break
      }
    }
    return ans
  }
}
