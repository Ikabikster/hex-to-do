package service.ToDoList;

import ToDoList.ToDoList;
import ToDoList.ToDoListId;
import ports.in.GetToDoListUseCase;
import ports.out.ToDoListRepository;

import java.util.List;
import java.util.Objects;

public class GetToDoListService implements GetToDoListUseCase {

    ToDoListRepository toDoListRepository;

    public GetToDoListService(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    @Override
    public ToDoList getToDoList(ToDoListId id) {
        Objects.requireNonNull(id, "id darf nicht null sein");
        try {
        return toDoListRepository.findById(id);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ToDoList> getToDoLists() {
        try {
            return toDoListRepository.findAll();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
