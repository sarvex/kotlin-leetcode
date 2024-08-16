internal class Solution {
  fun maximumElementAfterDecrementingAndRearranging(arr: IntArray): Int {
    Arrays.sort(arr)
    arr[0] = 1
    var ans = 1
    for (i in 1 until arr.size) {
      val d: Int = max(0, arr[i] - arr[i - 1] - 1)
      arr[i] -= d
      ans = max(ans, arr[i])
    }
    return ans
  }
}
