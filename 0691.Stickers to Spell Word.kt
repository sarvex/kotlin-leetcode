import java.util.*

internal class Solution {
  fun minStickers(stickers: Array<String>, target: String): Int {
    val n = target.length
    val q: Deque<Int> = ArrayDeque()
    q.offer(0)
    val vis = BooleanArray(1 shl n)
    vis[0] = true
    var ans = 0
    while (!q.isEmpty()) {
      for (m in q.size() downTo 1) {
        val cur = q.poll()
        if (cur == (1 shl n) - 1) {
          return ans
        }
        for (s in stickers) {
          val cnt = IntArray(26)
          var nxt = cur
          for (c in s.toCharArray()) {
            ++cnt[c.code - 'a'.code]
          }
          for (i in 0 until n) {
            val j: Int = target[i].code - 'a'.code
            if ((cur shr i and 1) == 0 && cnt[j] > 0) {
              --cnt[j]
              nxt = nxt or (1 shl i)
            }
          }
          if (!vis[nxt]) {
            vis[nxt] = true
            q.offer(nxt)
          }
        }
      }
      ++ans
    }
    return -1
  }
}
