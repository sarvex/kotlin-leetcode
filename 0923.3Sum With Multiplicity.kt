internal class Solution {
  fun threeSumMulti(arr: IntArray, target: Int): Int {
    val mod = 1e9.toInt() + 7
    val cnt = IntArray(101)
    for (x in arr) {
      ++cnt[x]
    }
    val n = arr.size
    var ans = 0
    for (j in 0 until n) {
      --cnt[arr[j]]
      for (i in 0 until j) {
        val c = target - arr[i] - arr[j]
        if (c >= 0 && c < cnt.size) {
          ans = (ans + cnt[c]) % mod
        }
      }
    }
    return ans
  }
}
