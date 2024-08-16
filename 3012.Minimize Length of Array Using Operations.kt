import java.util.*

internal class Solution {
  fun minimumArrayLength(nums: IntArray): Int {
    val mi = Arrays.stream(nums).min().asInt
    var cnt = 0
    for (x in nums) {
      if (x % mi != 0) {
        return 1
      }
      if (x == mi) {
        ++cnt
      }
    }
    return (cnt + 1) / 2
  }
}
