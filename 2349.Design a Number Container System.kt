internal class NumberContainers {
  private val d: Map<Int, Int> = HashMap()
  private val g: Map<Int, TreeSet<Int>> = HashMap()

  fun change(index: Int, number: Int) {
    if (d.containsKey(index)) {
      val oldNumber = d[index]!!
      g[oldNumber].remove(index)
    }
    d.put(index, number)
    g.computeIfAbsent(number) { k -> TreeSet() }.add(index)
  }

  fun find(number: Int): Int {
    val ids: Unit = g[number]
    return if (ids == null || ids.isEmpty()) -1 else ids.first()
  }
}
/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
