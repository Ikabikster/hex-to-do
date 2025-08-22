package service.Group;

import Group.Group;
import Group.GroupId;
import ports.in.GetGroupsUseCase;
import ports.out.GroupRepository;

import java.util.List;

public class GetGroupsService implements GetGroupsUseCase {

    private GroupRepository groupRepository;

    public GetGroupsService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Group getGroup(GroupId id) {
        return groupRepository.findById(id);
    }

    @Override
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }
}
