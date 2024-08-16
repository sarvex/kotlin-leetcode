class ZigzagIterator(v1: List<Int?>?, v2: List<Int?>?) {
  private var cur = 0
  private val size = 2
  private val indexes: List<Int> = ArrayList()
  private val vectors: List<List<Int>> = ArrayList()

  init {
    indexes.add(0)
    indexes.add(0)
    vectors.add(v1)
    vectors.add(v2)
  }

  fun next(): Int {
    val vector = vectors[cur]
    val index = indexes[cur]
    val res = vector[index]
    indexes.set(cur, index + 1)
    cur = (cur + 1) % size
    return res
  }

  fun hasNext(): Boolean {
    val start = cur
    while (indexes[cur] === vectors[cur].size()) {
      cur = (cur + 1) % size
      if (start == cur) {
        return false
      }
    }
    return true
  }
}
/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
