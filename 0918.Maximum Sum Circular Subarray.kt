internal class Solution {
  fun maxSubarraySumCircular(nums: IntArray): Int {
    val inf = 1 shl 30
    var pmi = 0
    var pmx = -inf
    var ans = -inf
    var s = 0
    var smi = inf
    for (x in nums) {
      s += x
      ans = max(ans, s - pmi)
      smi = min(smi, s - pmx)
      pmi = min(pmi, s)
      pmx = max(pmx, s)
    }
    return max(ans, s - smi)
  }
}
