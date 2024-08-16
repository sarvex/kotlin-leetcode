internal class Solution {
  fun minFlips(a: Int, b: Int, c: Int): Int {
    var ans = 0
    for (i in 0..31) {
      val x = a shr i and 1
      val y = b shr i and 1
      val z = c shr i and 1
      ans += if (z == 0) x + y else (if (x == 0 && y == 0) 1 else 0)
    }
    return ans
  }
}
