internal class Solution {
  fun maxFrequencyElements(nums: IntArray): Int {
    val cnt = IntArray(101)
    for (x in nums) {
      ++cnt[x]
    }
    var ans = 0
    var mx = -1
    for (x in cnt) {
      if (mx < x) {
        mx = x
        ans = x
      } else if (mx == x) {
        ans += x
      }
    }
    return ans
  }
}
