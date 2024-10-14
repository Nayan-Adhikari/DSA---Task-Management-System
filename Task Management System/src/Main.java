import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        // Example Menu
        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Search Task by Title");
            System.out.println("5. Mark Task as Completed");
            System.out.println("6. Filter Tasks by Priority");
            System.out.println("7. Undo");
            System.out.println("8. Redo");
            System.out.println("9. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter priority (1-10): ");
                    int priority = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter deadline (YYYY-MM-DD): ");
                    String deadline = scanner.nextLine();

                    Task task = new Task(title, description, priority, deadline);
                    manager.addTask(task);
                    break;
                case 2:
                    System.out.print("Enter task title to remove: ");
                    String removeTitle = scanner.nextLine();
                    manager.removeTask(removeTitle);
                    break;
                case 3:
                    manager.displayTasks();
                    break;
                case 4:
                    // Search task by title
                    System.out.print("Enter keyword to search: ");
                    String keyword = scanner.nextLine();
                    manager.searchTaskByTitle(keyword);
                    break;

                case 5:
                    // Mark task as completed
                    System.out.print("Enter Task Title to mark as completed: ");
                    String taskTitle = scanner.nextLine();
                    manager.markTaskAsCompleted(taskTitle);
                    break;

                case 6:
                    // Filter tasks by priority
                    System.out.print("Enter Priority Level to Filter: ");
                    int priorityLevel = scanner.nextInt();
                    scanner.nextLine();  // consume newline
                    manager.filterByPriority(priorityLevel);
                    break;

                case 7:
                    manager.undo();
                    break;
                case 8:
                    manager.redo();
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
