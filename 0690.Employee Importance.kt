/*
// Definition for Employee.
class Employee {
   public int id;
   public int importance;
   public List<Integer> subordinates;
};
*/
internal class Solution {
  private val d: Map<Int, Employee> = HashMap()

  fun getImportance(employees: List<Employee?>, id: Int): Int {
    for (e in employees) {
      d.put(e.id, e)
    }
    return dfs(id)
  }

  private fun dfs(i: Int): Int {
    val e: Employee = d[i]
    var s: Int = e.importance
    for (j in e.subordinates) {
      s += dfs(j)
    }
    return s
  }
}
