package ToDo;

public record ToDoId(int id) {

    public ToDoId {
        if (id() < 1) { // insert any validation here
            throw new IllegalArgumentException("id must be positive number");
        }
    }
}
