package service.ToDoList;

import ToDo.ToDo;
import ToDoList.ToDoList;
import ToDoList.ToDoListId;
import ports.in.AddToDoUseCase;
import ports.out.ToDoListRepository;
import ports.out.ToDoRepository;

import java.util.Objects;

public class AddToDoService implements AddToDoUseCase {

    private final ToDoRepository toDoRepository;
    private final ToDoListRepository toDoListRepository;

    public AddToDoService(ToDoRepository toDoRepository, ToDoListRepository toDoListRepository) {
        this.toDoRepository = toDoRepository;
        this.toDoListRepository = toDoListRepository;
    }

    @Override
    public ToDoList addToDo(ToDoListId id, ToDo toDo) {
        Objects.requireNonNull(toDo, "ToDO darf nicht null sein");
        Objects.requireNonNull(id, "ID darf nicht null sein");

        ToDoList list = toDoListRepository.findById(id);
        if (list.contains(toDo)) {
            throw new IllegalArgumentException("ToDo already exists");
        }
        try {
            list.addToDo(toDo);
            toDoRepository.save(toDo);
            return toDoListRepository.save(list);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
