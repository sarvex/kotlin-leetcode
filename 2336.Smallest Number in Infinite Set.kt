internal class SmallestInfiniteSet {
  private val s: TreeSet<Int> = TreeSet()

  init {
    for (i in 1..1000) {
      s.add(i)
    }
  }

  fun popSmallest(): Int {
    return s.pollFirst()
  }

  fun addBack(num: Int) {
    s.add(num)
  }
}
/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
