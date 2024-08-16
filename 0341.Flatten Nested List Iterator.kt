/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
</NestedInteger> */
class NestedIterator(nestedList: List<NestedInteger>) : Iterator<Int?> {
  private val nums: List<Int> = ArrayList()
  private var i = -1

  init {
    dfs(nestedList)
  }

  override fun next(): Int {
    return nums[++i]
  }

  override fun hasNext(): Boolean {
    return i + 1 < nums.size()
  }

  private fun dfs(ls: List<NestedInteger>) {
    for (x in ls) {
      if (x.isInteger()) {
        nums.add(x.getInteger())
      } else {
        dfs(x.getList())
      }
    }
  }
}
/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
