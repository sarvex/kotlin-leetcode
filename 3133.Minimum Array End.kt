internal class Solution {
  fun minEnd(n: Int, x: Int): Long {
    var n = n
    --n
    var ans = x.toLong()
    for (i in 0..30) {
      if ((x shr i and 1) == 0) {
        ans = ans or ((n and 1) shl i).toLong()
        n = n shr 1
      }
    }
    ans = ans or (n.toLong() shl 31)
    return ans
  }
}
