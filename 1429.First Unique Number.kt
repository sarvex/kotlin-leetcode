internal class FirstUnique(nums: IntArray) {
  private val cnt: Map<Int, Int> = HashMap()
  private val unique: Set<Int> = LinkedHashSet()

  init {
    for (v in nums) {
      cnt.put(v, cnt.getOrDefault(v, 0) + 1)
    }
    for (v in nums) {
      if (cnt[v] === 1) {
        unique.add(v)
      }
    }
  }

  fun showFirstUnique(): Int {
    return if (unique.isEmpty()) -1 else unique.iterator().next()
  }

  fun add(value: Int) {
    cnt.put(value, cnt.getOrDefault(value, 0) + 1)
    if (cnt[value] === 1) {
      unique.add(value)
    } else {
      unique.remove(value)
    }
  }
}
/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
