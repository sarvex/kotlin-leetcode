import java.util.*

internal class Solution {
  private var cookies: IntArray
  private var cnt: IntArray
  private var k = 0
  private var n = 0
  private var ans = 1 shl 30

  fun distributeCookies(cookies: IntArray, k: Int): Int {
    n = cookies.size
    cnt = IntArray(k)
    // 升序排列
    Arrays.sort(cookies)
    this.cookies = cookies
    this.k = k
    // 这里搜索顺序是 n-1, n-2,...0
    dfs(n - 1)
    return ans
  }

  private fun dfs(i: Int) {
    if (i < 0) {
      // ans = Arrays.stream(cnt).max().getAsInt();
      ans = 0
      for (v in cnt) {
        ans = max(ans, v)
      }
      return
    }
    for (j in 0 until k) {
      if (cnt[j] + cookies[i] >= ans || (j > 0 && cnt[j] == cnt[j - 1])) {
        continue
      }
      cnt[j] += cookies[i]
      dfs(i - 1)
      cnt[j] -= cookies[i]
    }
  }
}
