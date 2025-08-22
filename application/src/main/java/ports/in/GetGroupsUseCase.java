package ports.in;

import Group.Group;
import Group.GroupId;

import java.util.List;

public interface GetGroupsUseCase {
    Group getGroup(GroupId id);
    List<Group> getAllGroups();
}
