package ports.in;

import Group.Group;
import Group.GroupId;
import User.User;

public interface AddUserToGroupUseCase {
    Group addUserToGroup(GroupId id, User user);
}
