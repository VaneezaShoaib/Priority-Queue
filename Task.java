// Name: Vaneeza Shoaib
// Computing ID: ZHW9ZC@virginia.edu
// Homework Name: HW 12
// Resources used: ChatAI- equals method assistance

public class Task implements Comparable<Task> {
    private final String taskName;
    private final int priority;

    public Task(String taskName, int priority) { // constructor
        this.taskName = taskName;
        this.priority = priority;
    }
    public String getTask() { // Accessors
        return taskName;
    }

    public int getPriority() {
        return priority;
    }

    // Implementing Comparable interface to compare tasks based on priority
    @Override
    public int compareTo(Task otherTask) {
        return Integer.compare(this.priority, otherTask.getPriority());
    }

    @Override
    public String toString() {
        return "[" + taskName + "," + priority + "]";
    }

    // equals method (assuming tasks are equal if both task name and priority are the same)
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Task otherTask = (Task) obj;
        return priority == otherTask.priority && taskName.equals(otherTask.taskName);
    }
}
