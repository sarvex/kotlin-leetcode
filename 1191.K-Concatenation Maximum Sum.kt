internal class Solution {
  fun kConcatenationMaxSum(arr: IntArray, k: Int): Int {
    var s: Long = 0
    var mxPre: Long = 0
    var miPre: Long = 0
    var mxSub: Long = 0
    for (x in arr) {
      s += x.toLong()
      mxPre = max(mxPre, s)
      miPre = min(miPre, s)
      mxSub = max(mxSub, s - miPre)
    }
    var ans = mxSub
    val mod = 1e9.toInt() + 7
    if (k == 1) {
      return (ans % mod).toInt()
    }
    val mxSuf = s - miPre
    ans = max(ans, mxPre + mxSuf)
    if (s > 0) {
      ans = max(ans, (k - 2) * s + mxPre + mxSuf)
    }
    return (ans % mod).toInt()
  }
}
