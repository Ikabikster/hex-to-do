package service.ToDoList;

import ToDoList.ToDoList;
import ports.in.CreateToDoListUseCase;
import ports.out.ToDoListRepository;

import java.util.ArrayList;
import java.util.Objects;

public class CreateToDoListService implements CreateToDoListUseCase {

    ToDoListRepository toDoListRepository;

    public CreateToDoListService(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    @Override
    public ToDoList create(String name) {
        Objects.requireNonNull(name, "Name darf nicht null sein");

        ToDoList newList = new ToDoList(name, new ArrayList<>());
        try {
            toDoListRepository.save(newList);
            return newList;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
