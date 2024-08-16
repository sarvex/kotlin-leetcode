internal class Solution {
  fun duplicateNumbersXOR(nums: IntArray): Int {
    val cnt = IntArray(51)
    var ans = 0
    for (x in nums) {
      if (++cnt[x] == 2) {
        ans = ans xor x
      }
    }
    return ans
  }
}
