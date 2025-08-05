package User;

import Group.Group;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@AllArgsConstructor
@Accessors(chain = true, fluent = true)
public class User {
    private UserId userId;
    private String name;
    private List<Group> groups;
}
