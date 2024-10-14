import java.util.*;
public class TaskManager {
    private List<Task> taskList;           // use ArrayList to store task
    private Stack<Task> undoStack;         // Undo Stack
    private Stack<Task> redoStack;         // Redo Stack

    //Constructors
    public TaskManager(){
        taskList = new ArrayList<>();
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public void addTask(Task task){
        taskList.add(task);
        undoStack.push(task);
        System.out.println("Task added: "+task.getTitle());

    }

    public void removeTask(String title){
        for(Task task : taskList){
            if(task.getTitle().equalsIgnoreCase(title)){
                taskList.remove(task);
                undoStack.push(task);
                System.out.println("Task removed: "+task.getTitle());
                return;
            }
        }
        System.out.println("Task not found");
    }

    public void undo(){
        if(!undoStack.isEmpty()){
            Task lastTask = undoStack.pop();
            redoStack.push(lastTask);
            taskList.remove(lastTask);
            System.out.println("Undo actionn performed. Task removed: "+lastTask.getTitle());
        }
        else{
            System.out.println("No actions to do");
        }
    }

    public void redo(){
        if(!redoStack.isEmpty()){
            Task taskToRedo = redoStack.pop();
            taskList.add(taskToRedo);
            undoStack.push(taskToRedo);
            System.out.println("Redo action performed. Task added: "+taskToRedo.getTitle());
        }
        else{
            System.out.println("No actions to redo.");
        }
    }

    public void displayTasks(){
        if(taskList.isEmpty()){
            System.out.println("No task available.");
        }else{
            for(Task task : taskList){
                System.out.println(task);
            }
        }
    }

    public void markTaskAsCompleted(String title) {
        for (Task task : taskList) {
            if (task.getTitle().equalsIgnoreCase(title)) {
                task.markAsCompleted();
                System.out.println("Task marked as completed: " + task.getTitle());
                return;
            }
        }
        System.out.println("Task not found.");
    }
    
    public void filterByCategory(String category) {
        for (Task task : taskList) {
            if (task.getCategory().equalsIgnoreCase(category)) {
                System.out.println(task);
            }
        }
    }

    public void searchTaskByTitle(String keyword) {
        for (Task task : taskList) {
            if (task.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(task);
            }
        }
    }
    
    public void filterByPriority(int priorityLevel) {
        for (Task task : taskList) {
            if (task.getPriority() == priorityLevel) {
                System.out.println(task);
            }
        }
    }
    

    public void sortByTitle() {
        taskList.sort(Comparator.comparing(Task::getTitle));
        System.out.println("Tasks sorted by title.");
    }
    
    public void sortByDeadline() {
        taskList.sort(Comparator.comparing(Task::getDeadline));
        System.out.println("Tasks sorted by deadline.");
    }
    
}
