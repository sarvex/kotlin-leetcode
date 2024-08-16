import java.util.*

internal class Solution {
  fun minMutation(startGene: String, endGene: String, bank: Array<String>): Int {
    val q: Deque<String> = ArrayDeque()
    q.offer(startGene)
    val vis: Set<String> = HashSet()
    vis.add(startGene)
    var depth = 0
    while (!q.isEmpty()) {
      for (m in q.size() downTo 1) {
        val gene = q.poll()
        if (gene == endGene) {
          return depth
        }
        for (next in bank) {
          var c = 2
          var k = 0
          while (k < 8 && c > 0) {
            if (gene[k] != next[k]) {
              --c
            }
            ++k
          }
          if (c > 0 && !vis.contains(next)) {
            q.offer(next)
            vis.add(next)
          }
        }
      }
      ++depth
    }
    return -1
  }
}
