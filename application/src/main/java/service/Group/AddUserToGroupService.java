package service.Group;

import Group.Group;
import Group.GroupId;
import User.User;
import ports.in.AddUserToGroupUseCase;
import ports.out.GroupRepository;

import java.util.Objects;

public class AddUserToGroupService implements AddUserToGroupUseCase {

    private final GroupRepository groupRepository;

    public AddUserToGroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Group addUserToGroup(GroupId id, User user) {
        Objects.requireNonNull(id, "id darf nicht null sein");
        Objects.requireNonNull(user, "user darf nicht null sein");

        try {
            Group group = groupRepository.findById(id);
            group.addAssignee(user.userId());
            return groupRepository.save(group);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
