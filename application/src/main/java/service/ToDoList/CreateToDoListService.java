package service.ToDoList;

import ToDoList.ToDoList;
import ports.in.CreateToDoListUseCase;
import ports.out.ToDoListRepository;

import java.util.ArrayList;

public class CreateToDoListService implements CreateToDoListUseCase {

    ToDoListRepository toDoListRepository;

    public CreateToDoListService(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    @Override
    public ToDoList create(String name) {
        ToDoList newList = new ToDoList(name, new ArrayList<>());
        toDoListRepository.save(newList);
        return newList;
    }
}
