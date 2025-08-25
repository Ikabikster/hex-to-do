package service.Group;

import Group.Group;
import Group.GroupId;
import ports.in.GetGroupsUseCase;
import ports.out.GroupRepository;

import java.util.List;
import java.util.Objects;

public class GetGroupsService implements GetGroupsUseCase {

    private final GroupRepository groupRepository;

    public GetGroupsService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Group getGroup(GroupId id) {
        Objects.requireNonNull(id, "id darf nicht null sein");
        try {
            return groupRepository.findById(id);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Group> getAllGroups() {
        try {
            return groupRepository.findAll();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
