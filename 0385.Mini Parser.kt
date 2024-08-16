/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * // Constructor initializes an empty nested list.
 * public NestedInteger();
 *
 * // Constructor initializes a single integer.
 * public NestedInteger(int value);
 *
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // Set this NestedInteger to hold a single integer.
 * public void setInteger(int value);
 *
 * // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 * public void add(NestedInteger ni);
 *
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
</NestedInteger> */
internal class Solution {
  fun deserialize(s: String): NestedInteger {
    if ("" == s || "[]" == s) {
      return NestedInteger()
    }
    if (s[0] != '[') {
      return NestedInteger(s.toInt())
    }
    val ans: NestedInteger = NestedInteger()
    var depth = 0
    var i = 1
    var j = 1
    while (i < s.length) {
      if (depth == 0 && (s[i] == ',' || i == s.length - 1)) {
        ans.add(deserialize(s.substring(j, i)))
        j = i + 1
      } else if (s[i] == '[') {
        ++depth
      } else if (s[i] == ']') {
        --depth
      }
      ++i
    }
    return ans
  }
}
