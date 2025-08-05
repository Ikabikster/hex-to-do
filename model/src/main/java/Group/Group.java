package Group;

import User.UserId;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Accessors(chain = true, fluent = true)
@AllArgsConstructor
public class Group {
    private GroupId id;
    private String name;
    private List<UserId> assignees;
}
