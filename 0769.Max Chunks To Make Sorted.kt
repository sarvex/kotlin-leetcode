internal class Solution {
  fun maxChunksToSorted(arr: IntArray): Int {
    var ans = 0
    var mx = 0
    for (i in arr.indices) {
      mx = max(mx, arr[i])
      if (i == mx) {
        ++ans
      }
    }
    return ans
  }
}
