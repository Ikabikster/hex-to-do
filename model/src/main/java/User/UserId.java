package User;

public record UserId(int id) {

    public UserId {
        if (id() < 1) { // insert any validation here
            throw new IllegalArgumentException("id must be positive number");
        }
    }
}
