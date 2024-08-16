/**
 * Definition of commonBits API (defined in the parent class Problem).
 * int commonBits(int num);
 */
class Solution : Problem() {
  fun findNumber(): Int {
    var n = 0
    for (i in 0..31) {
      val count1: Int = commonBits(1 shl i)
      val count2: Int = commonBits(1 shl i)
      if (count1 > count2) {
        n = n or (1 shl i)
      }
    }
    return n
  }
}
