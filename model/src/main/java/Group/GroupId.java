package Group;

public record GroupId(int id) {
    public GroupId {
        if (id() < 1) { // insert any validation here
            throw new IllegalArgumentException("id must be positive number");
        }
    }
}
