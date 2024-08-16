internal class Solution {
  private val g: Map<String, List<String>> = HashMap()
  private val ans: List<String> = ArrayList()

  fun findItinerary(tickets: List<List<String?>>): List<String> {
    Collections.sort(tickets) { a, b -> b.get(1).compareTo(a.get(1)) }
    for (ticket in tickets) {
      g.computeIfAbsent(ticket[0]) { k -> ArrayList() }.add(ticket[1])
    }
    dfs("JFK")
    Collections.reverse(ans)
    return ans
  }

  private fun dfs(f: String) {
    while (g.containsKey(f) && !g[f]!!.isEmpty()) {
      val t: String = g[f].remove(g[f]!!.size() - 1)
      dfs(t)
    }
    ans.add(f)
  }
}
