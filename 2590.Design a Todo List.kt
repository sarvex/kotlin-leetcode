internal class Task(var taskId: Int, var taskName: String, var dueDate: Int, var tags: Set<String>) {
  var finish: Boolean = false
}

internal class TodoList {
  private var i = 1
  private val tasks: Map<Int, TreeSet<Task>> = HashMap()

  fun addTask(userId: Int, taskDescription: String, dueDate: Int, tags: List<String?>?): Int {
    val task = Task(i++, taskDescription, dueDate, HashSet(tags))
    tasks.computeIfAbsent(userId) { k -> TreeSet(Comparator.comparingInt { a -> a.dueDate }) }
      .add(task)
    return task.taskId
  }

  fun getAllTasks(userId: Int): List<String> {
    val ans: List<String> = ArrayList()
    if (tasks.containsKey(userId)) {
      for (task in tasks[userId]) {
        if (!task.finish) {
          ans.add(task.taskName)
        }
      }
    }
    return ans
  }

  fun getTasksForTag(userId: Int, tag: String): List<String> {
    val ans: List<String> = ArrayList()
    if (tasks.containsKey(userId)) {
      for (task in tasks[userId]) {
        if (task.tags.contains(tag) && !task.finish) {
          ans.add(task.taskName)
        }
      }
    }
    return ans
  }

  fun completeTask(userId: Int, taskId: Int) {
    if (tasks.containsKey(userId)) {
      for (task in tasks[userId]) {
        if (task.taskId == taskId) {
          task.finish = true
          break
        }
      }
    }
  }
}
/**
 * Your TodoList object will be instantiated and called as such:
 * TodoList obj = new TodoList();
 * int param_1 = obj.addTask(userId,taskDescription,dueDate,tags);
 * List<String> param_2 = obj.getAllTasks(userId);
 * List<String> param_3 = obj.getTasksForTag(userId,tag);
 * obj.completeTask(userId,taskId);
</String></String> */
