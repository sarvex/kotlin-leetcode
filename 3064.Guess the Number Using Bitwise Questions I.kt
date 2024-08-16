/**
 * Definition of commonSetBits API (defined in the parent class Problem).
 * int commonSetBits(int num);
 */
class Solution : Problem() {
  fun findNumber(): Int {
    var n = 0
    for (i in 0..31) {
      if (commonSetBits(1 shl i) > 0) {
        n = n or (1 shl i)
      }
    }
    return n
  }
}
