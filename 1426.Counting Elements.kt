internal class Solution {
  fun countElements(arr: IntArray): Int {
    val cnt = IntArray(1001)
    for (x in arr) {
      ++cnt[x]
    }
    var ans = 0
    for (x in 0..999) {
      if (cnt[x + 1] > 0) {
        ans += cnt[x]
      }
    }
    return ans
  }
}
