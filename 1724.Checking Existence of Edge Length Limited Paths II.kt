internal class PersistentUnionFind(n: Int) {
  private val inf = 1 shl 30
  private val rank = IntArray(n)
  private val parent = IntArray(n)
  private val version = IntArray(n)

  init {
    for (i in 0 until n) {
      parent[i] = i
      version[i] = inf
    }
  }

  fun find(x: Int, t: Int): Int {
    if (parent[x] == x || version[x] >= t) {
      return x
    }
    return find(parent[x], t)
  }

  fun union(a: Int, b: Int, t: Int): Boolean {
    val pa = find(a, inf)
    val pb = find(b, inf)
    if (pa == pb) {
      return false
    }
    if (rank[pa] > rank[pb]) {
      version[pb] = t
      parent[pb] = pa
    } else {
      version[pa] = t
      parent[pa] = pb
      if (rank[pa] == rank[pb]) {
        rank[pb]++
      }
    }
    return true
  }
}

class DistanceLimitedPathsExist(n: Int, edgeList: Array<IntArray>) {
  private val puf = PersistentUnionFind(n)

  init {
    Arrays.sort(edgeList) { a, b -> a.get(2) - b.get(2) }
    for (e in edgeList) {
      puf.union(e[0], e[1], e[2])
    }
  }

  fun query(p: Int, q: Int, limit: Int): Boolean {
    return puf.find(p, limit) == puf.find(q, limit)
  }
}
/**
 * Your DistanceLimitedPathsExist object will be instantiated and called as such:
 * DistanceLimitedPathsExist obj = new DistanceLimitedPathsExist(n, edgeList);
 * boolean param_1 = obj.query(p,q,limit);
 */
