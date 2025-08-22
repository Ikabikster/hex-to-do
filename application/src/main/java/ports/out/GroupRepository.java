package ports.out;

import Group.Group;
import Group.GroupId;

import java.util.List;

public interface GroupRepository {

    Group findById(GroupId id);

    Group save(Group group);

    List<Group> findAll();
}
