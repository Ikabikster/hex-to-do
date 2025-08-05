package ToDo;

import User.UserId;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Accessors(chain = true, fluent = true)
public class Todo {
    private TodoId id;
    private String title;
    private String notes;
    private Day day;
    private UserId assignee;


    public Todo(String title, String notes, Day day) {
        this(null, title, notes, day, null);
    }

}
