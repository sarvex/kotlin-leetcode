internal class Solution {
  fun maximumEnergy(energy: IntArray, k: Int): Int {
    var ans = -(1 shl 30)
    val n = energy.size
    for (i in n - k until n) {
      var j: Int = i
      var s = 0
      while (j >= 0) {
        s += energy[j]
        ans = max(ans, s)
        j -= k
      }
    }
    return ans
  }
}
