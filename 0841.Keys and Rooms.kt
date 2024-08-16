internal class Solution {
  private var cnt = 0
  private var vis: BooleanArray
  private var g: List<List<Int>>? = null

  fun canVisitAllRooms(rooms: List<List<Int>>?): Boolean {
    g = rooms
    vis = BooleanArray(g!!.size())
    dfs(0)
    return cnt == g!!.size()
  }

  private fun dfs(i: Int) {
    if (vis[i]) {
      return
    }
    vis[i] = true
    ++cnt
    for (j in g!![i]) {
      dfs(j)
    }
  }
}
