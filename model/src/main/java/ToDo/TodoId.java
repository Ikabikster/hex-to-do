package ToDo;

public record TodoId(int id) {

    public TodoId {
        if (id() < 1) { // insert any validation here
            throw new IllegalArgumentException("id must be positive number");
        }
    }
}
