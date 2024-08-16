internal class Solution {
  private var p: IntArray

  fun friendRequests(n: Int, restrictions: Array<IntArray>, requests: Array<IntArray>): BooleanArray {
    p = IntArray(n)
    for (i in 0 until n) {
      p[i] = i
    }
    val m = requests.size
    val ans = BooleanArray(m)
    for (i in 0 until m) {
      val u = requests[i][0]
      val v = requests[i][1]
      val pu = find(u)
      val pv = find(v)
      if (pu == pv) {
        ans[i] = true
      } else {
        var ok = true
        for (r in restrictions) {
          val px = find(r[0])
          val py = find(r[1])
          if ((pu == px && pv == py) || (pu == py && pv == px)) {
            ok = false
            break
          }
        }
        if (ok) {
          ans[i] = true
          p[pu] = pv
        }
      }
    }
    return ans
  }

  private fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }
}
