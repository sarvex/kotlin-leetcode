internal class Solution {
  fun findMinStep(board: String, hand: String): Int {
    val zuma = Zuma.create(board, hand)
    val visited: HashSet<Long> = HashSet()
    val init: ArrayList<Zuma> = ArrayList()

    visited.add(zuma.board)
    init.add(zuma)
    return bfs(init, 0, visited)
  }

  private fun bfs(curr: ArrayList<Zuma>, k: Int, visited: HashSet<Long>): Int {
    if (curr.isEmpty()) {
      return -1
    }

    val next: ArrayList<Zuma> = ArrayList()

    for (zuma in curr) {
      val neib: ArrayList<Zuma> = zuma.getNextLevel(k, visited) ?: return k + 1

      next.addAll(neib)
    }
    return bfs(next, k + 1, visited)
  }
}

@kotlin.jvm.JvmRecord
internal data class Zuma(val board: Long, val hand: Long) {
  fun getNextLevel(depth: Int, visited: HashSet<Long>): ArrayList<Zuma>? {
    val next: ArrayList<Zuma> = ArrayList()
    val handList: ArrayList<LongArray> = this.buildHandList()
    val boardList = LongArray(32)
    val size = this.buildBoardList(boardList)

    for (pair in handList) {
      for (i in 0 until size) {
        val rawBoard = pruningCheck(boardList[i], pair[0], i * 3, depth)
        if (rawBoard == -1L) {
          continue
        }

        val nextBoard = updateBoard(rawBoard)
        if (nextBoard == 0L) {
          return null
        }

        if (pair[1] == 0L || visited.contains(nextBoard)) {
          continue
        }

        visited.add(nextBoard)
        next.add(Zuma(nextBoard, pair[1]))
      }
    }
    return next
  }

  private fun pruningCheck(insBoard: Long, ball: Long, pos: Int, depth: Int): Long {
    val L = (insBoard shr (pos + 3)) and 0x7L
    val R = (insBoard shr (pos - 3)) and 0x7L

    if (depth == 0 && (ball != R) && (L != R) || depth > 0 && (ball != R)) {
      return -1
    }
    return insBoard or (ball shl pos)
  }

  private fun updateBoard(board: Long): Long {
    var stack: Long = 0

    var i = 0
    while (i < 64) {
      val curr = (board shr i) and 0x7L
      val top = (stack) and 0x7L

      // pop (if possible)
      if ((top > 0) && (curr != top) && (stack and 0x3FL) == ((stack shr 3) and 0x3FL)) {
        stack = stack shr 9
        if ((stack and 0x7L) == top) stack = stack shr 3
      }

      if (curr == 0L) {
        // done
        break
      }
      // push and continue
      stack = (stack shl 3) or curr
      i += 3
    }
    return stack
  }

  private fun buildHandList(): ArrayList<LongArray> {
    val handList: ArrayList<LongArray> = ArrayList()
    var prevBall: Long = 0
    var ballMask: Long = 0

    var i = 0
    while (i < 16) {
      val currBall = (this.hand shr i) and 0x7L
      if (currBall == 0L) {
        break
      }

      if (currBall != prevBall) {
        prevBall = currBall
        handList.add(
          longArrayOf(currBall, ((this.hand shr 3) and ballMask.inv()) or (this.hand and ballMask))
        )
      }
      ballMask = (ballMask shl 3) or 0x7L
      i += 3
    }
    return handList
  }

  private fun buildBoardList(buffer: LongArray): Int {
    var ptr = 0
    var ballMask: Long = 0x7
    var insBoard = this.board shl 3
    buffer[ptr++] = insBoard

    while (true) {
      val currBall = this.board and ballMask
      if (currBall == 0L) {
        break
      }

      ballMask = ballMask shl 3
      insBoard = (insBoard or currBall) and ballMask.inv()
      buffer[ptr++] = insBoard
    }
    return ptr
  }

  companion object {
    fun create(boardStr: String, handStr: String): Zuma {
      return Zuma(encode(boardStr, false), encode(handStr, true))
    }

    private fun encode(stateStr: String, sortFlag: Boolean): Long {
      val stateChars: CharArray = stateStr.toCharArray()
      if (sortFlag) {
        Arrays.sort(stateChars)
      }

      var stateBits: Long = 0
      for (ch in stateChars) {
        stateBits = (stateBits shl 3) or encode(ch)
      }
      return stateBits
    }

    private fun encode(ch: Char): Long {
      return when (ch) {
        'R' -> 0x1
        'G' -> 0x2
        'B' -> 0x3
        'W' -> 0x4
        'Y' -> 0x5
        ' ' -> 0x0
        else -> throw IllegalArgumentException("Invalid char: $ch")
      }
    }
  }
}
