package User;

import Group.Group;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@AllArgsConstructor
@Accessors(chain = true, fluent = true)
public class User {
    private UserId userId;
    private String name;
    private List<Group> groups;
}
