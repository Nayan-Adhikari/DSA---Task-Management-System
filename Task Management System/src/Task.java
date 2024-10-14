public class Task {
    private String title;
    private String description;
    private int priority; // 1 is lowest & 5 is highest
    private String deadline; // YYYY-MM-DD this will be the format
    private boolean isCompleted;
    private String category;

    //constructors
    Task(String title, String description, int priority, String deadline){
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.deadline = deadline;
    }

    //getters & setters
    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;   
    }

    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;   
    }

    public int getPriority(){
        return this.priority;
    }
    public void setPriority(int priority){
        this.priority = priority;   
    }

    public String getDeadline(){
        return this.deadline;
    }
    public void setDeadline(String deadline){
        this.deadline = deadline;   
    }

    public String getCategory() {
         return category; 
    }
    public void setCategory(String category) { 
        this.category = category; 
    }

    @Override
    public String toString(){
        return "Task [Title: "+title+" , Description: "+description+" , Priority: "+priority+" , Deadline: "+deadline+ "]";
    }

    public boolean isCompleted() { 
        return isCompleted; 
    }
    public void markAsCompleted() { 
        this.isCompleted = true; 
    }
    
}
