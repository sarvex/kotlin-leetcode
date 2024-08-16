internal class FileSharing(private val chunks: Int) {
  private var cur = 0
  private val reused: TreeSet<Int>
  private val userChunks: TreeMap<Int, Set<Int>>

  init {
    reused = TreeSet()
    userChunks = TreeMap()
  }

  fun join(ownedChunks: List<Int?>?): Int {
    val userID: Int
    if (reused.isEmpty()) {
      ++cur
      userID = cur
    } else {
      userID = reused.pollFirst()
    }
    userChunks.put(userID, HashSet(ownedChunks))
    return userID
  }

  fun leave(userID: Int) {
    reused.add(userID)
    userChunks.remove(userID)
  }

  fun request(userID: Int, chunkID: Int): List<Int> {
    if (chunkID < 1 || chunkID > chunks) {
      return Collections.emptyList()
    }
    val res: List<Int> = ArrayList()
    for (entry in userChunks.entrySet()) {
      if (entry.getValue().contains(chunkID)) {
        res.add(entry.getKey())
      }
    }
    if (!res.isEmpty()) {
      userChunks.computeIfAbsent(userID) { k -> HashSet() }.add(chunkID)
    }
    return res
  }
}
/**
 * Your FileSharing object will be instantiated and called as such:
 * FileSharing obj = new FileSharing(m);
 * int param_1 = obj.join(ownedChunks);
 * obj.leave(userID);
 * List<Integer> param_3 = obj.request(userID,chunkID);
</Integer> */
