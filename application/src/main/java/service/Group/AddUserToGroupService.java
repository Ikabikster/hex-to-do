package service.Group;

import Group.Group;
import Group.GroupId;
import User.User;
import ports.in.AddUserToGroupUseCase;
import ports.out.GroupRepository;
import ports.out.UserRepository;

public class AddUserToGroupService implements AddUserToGroupUseCase {

    private UserRepository userRepository;
    private GroupRepository groupRepository;

    public AddUserToGroupService(UserRepository userRepository, GroupRepository groupRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
    }

    @Override
    public Group addUserToGroup(GroupId id, User user) {
        Group group = groupRepository.findById(id);
        group.addAssignee(user.userId());
        return groupRepository.save(group);
    }
}
