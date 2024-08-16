internal class RandomizedSet {
  private val d: Map<Int, Int> = HashMap()
  private val q: List<Int> = ArrayList()
  private val rnd: Random = Random()

  fun insert(`val`: Int): Boolean {
    if (d.containsKey(`val`)) {
      return false
    }
    d.put(`val`, q.size())
    q.add(`val`)
    return true
  }

  fun remove(`val`: Int): Boolean {
    if (!d.containsKey(`val`)) {
      return false
    }
    val i = d[`val`]!!
    d.put(q[q.size() - 1], i)
    q.set(i, q[q.size() - 1])
    q.remove(q.size() - 1)
    d.remove(`val`)
    return true
  }

  val random: Int
    get() = q[rnd.nextInt(q.size())]
}
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
