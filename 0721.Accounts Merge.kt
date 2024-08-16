internal class UnionFind(n: Int) {
  private val p = IntArray(n)
  private val size = IntArray(n)

  init {
    for (i in 0 until n) {
      p[i] = i
      size[i] = 1
    }
  }

  fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }

  fun union(a: Int, b: Int): Boolean {
    val pa = find(a)
    val pb = find(b)
    if (pa == pb) {
      return false
    }
    if (size[pa] > size[pb]) {
      p[pb] = pa
      size[pa] += size[pb]
    } else {
      p[pa] = pb
      size[pb] += size[pa]
    }
    return true
  }
}

internal class Solution {
  fun accountsMerge(accounts: List<List<String?>>): List<List<String>> {
    val n: Int = accounts.size()
    val uf = UnionFind(n)
    val d: Map<String?, Int> = HashMap()
    for (i in 0 until n) {
      for (j in 1 until accounts[i].size()) {
        val email = accounts[i][j]
        if (d.containsKey(email)) {
          uf.union(i, d[email]!!)
        } else {
          d.put(email, i)
        }
      }
    }
    val g: Map<Int, Set<String>> = HashMap()
    for (i in 0 until n) {
      val root = uf.find(i)
      g.computeIfAbsent(root) { k -> HashSet() }
        .addAll(accounts[i].subList(1, accounts[i].size()))
    }
    val ans: List<List<String>> = ArrayList()
    for (e in g.entrySet()) {
      val emails: List<String> = ArrayList(e.getValue())
      Collections.sort(emails)
      ans.add(ArrayList())
      ans[ans.size() - 1].add(accounts[e.getKey()][0])
      ans[ans.size() - 1].addAll(emails)
    }
    return ans
  }
}
