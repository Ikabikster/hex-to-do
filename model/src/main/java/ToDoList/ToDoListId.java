package ToDoList;

public record ToDoListId(int id) {
    public ToDoListId {
        if (id() < 1) { // insert any validation here
            throw new IllegalArgumentException("id must be positive number");
        }
    }
}
