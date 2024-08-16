internal class ThroneInheritance(private val king: String) {
  private val dead: Set<String> = HashSet()
  private val g: Map<String, List<String>> = HashMap()
  private val ans: List<String> = ArrayList()

  fun birth(parentName: String?, childName: String?) {
    g.computeIfAbsent(parentName) { k -> ArrayList() }.add(childName)
  }

  fun death(name: String?) {
    dead.add(name)
  }

  val inheritanceOrder: List<String>
    get() {
      ans.clear()
      dfs(king)
      return ans
    }

  private fun dfs(x: String) {
    if (!dead.contains(x)) {
      ans.add(x)
    }
    for (y in g.getOrDefault(x, List.of())) {
      dfs(y)
    }
  }
}
/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
</String> */
