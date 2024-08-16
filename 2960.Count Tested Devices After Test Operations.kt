internal class Solution {
  fun countTestedDevices(batteryPercentages: IntArray): Int {
    var ans = 0
    for (x in batteryPercentages) {
      ans += if (x > ans) 1 else 0
    }
    return ans
  }
}
