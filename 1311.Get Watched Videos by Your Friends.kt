internal class Solution {
  fun watchedVideosByFriends(
    watchedVideos: List<List<String>>, friends: Array<IntArray>, id: Int, level: Int
  ): List<String> {
    var level = level
    val q: Deque<Int> = ArrayDeque()
    q.offer(id)
    val n = friends.size
    val vis = BooleanArray(n)
    vis[id] = true
    while (level-- > 0) {
      for (k in q.size() downTo 1) {
        val i: Int = q.poll()
        for (j in friends[i]) {
          if (!vis[j]) {
            vis[j] = true
            q.offer(j)
          }
        }
      }
    }
    val cnt: Map<String, Int> = HashMap()
    for (i in q) {
      for (v in watchedVideos[i]) {
        cnt.merge(v, 1) { a: Int, b: Int -> Integer.sum(a, b) }
      }
    }
    val ans: List<String> = ArrayList(cnt.keySet())
    ans.sort { a, b ->
      val x = cnt[a]!!
      val y = cnt[b]!!
      if (x == y) a.compareTo(b) else Integer.compare(x, y)
    }
    return ans
  }
}
