internal class Trie {
  var name: String? = null
  var isFile: Boolean = false
  var content: StringBuilder = StringBuilder()
  var children: Map<String, Trie> = HashMap()

  fun insert(path: String, isFile: Boolean): Trie {
    var node = this
    val ps: Array<String> = path.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    for (i in 1 until ps.size) {
      val p = ps[i]
      if (!node.children.containsKey(p)) {
        node.children.put(p, Trie())
      }
      node = node.children[p]
    }
    node.isFile = isFile
    if (isFile) {
      node.name = ps[ps.size - 1]
    }
    return node
  }

  fun search(path: String): Trie? {
    var node = this
    val ps: Array<String> = path.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    for (i in 1 until ps.size) {
      val p = ps[i]
      if (!node.children.containsKey(p)) {
        return null
      }
      node = node.children[p]
    }
    return node
  }
}

internal class FileSystem {
  private val root = Trie()

  fun ls(path: String): List<String> {
    val ans: List<String> = ArrayList()
    val node = root.search(path) ?: return ans
    if (node.isFile) {
      ans.add(node.name)
      return ans
    }
    for (v in node.children.keySet()) {
      ans.add(v)
    }
    Collections.sort(ans)
    return ans
  }

  fun mkdir(path: String) {
    root.insert(path, false)
  }

  fun addContentToFile(filePath: String, content: String?) {
    val node = root.insert(filePath, true)
    node.content.append(content)
  }

  fun readContentFromFile(filePath: String): String {
    val node = root.search(filePath)
    return node.content.toString()
  }
}
/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
</String> */
