package service.ToDoList;

import ToDoList.ToDoList;
import ToDoList.ToDoListId;
import ports.in.GetToDoListUseCase;
import ports.out.ToDoListRepository;

import java.util.List;

public class GetToDoListService implements GetToDoListUseCase {

    ToDoListRepository toDoListRepository;

    public GetToDoListService(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    @Override
    public ToDoList getToDoList(ToDoListId id) {
        return toDoListRepository.findById(id);
    }

    @Override
    public List<ToDoList> getToDoLists() {
        return toDoListRepository.findAll();
    }
}
