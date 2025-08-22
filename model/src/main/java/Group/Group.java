package Group;

import User.UserId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true, fluent = true)
@AllArgsConstructor
public class Group {
    private GroupId id;
    private String name;
    private List<UserId> assignees;

    public Group addAssignee(UserId userId) {
        if (this.assignees.contains(userId)) {
            return this;
        }
        this.assignees.add(userId);
        return this;
    }
}
