internal class Solution {
  fun singleDivisorTriplet(nums: IntArray): Long {
    val cnt = IntArray(101)
    for (x in nums) {
      ++cnt[x]
    }
    var ans: Long = 0
    for (a in 1..100) {
      for (b in 1..100) {
        for (c in 1..100) {
          val s = a + b + c
          val x = cnt[a]
          val y = cnt[b]
          val z = cnt[c]
          var t = 0
          t += if (s % a == 0) 1 else 0
          t += if (s % b == 0) 1 else 0
          t += if (s % c == 0) 1 else 0
          if (t == 1) {
            ans += if (a == b) {
              1L * x * (x - 1) * z
            } else if (a == c) {
              1L * x * (x - 1) * y
            } else if (b == c) {
              1L * x * y * (y - 1)
            } else {
              1L * x * y * z
            }
          }
        }
      }
    }
    return ans
  }
}
