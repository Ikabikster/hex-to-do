package service.ToDoList;

import ToDo.ToDo;
import ToDoList.ToDoList;
import ToDoList.ToDoListId;
import ports.in.AddToDoUseCase;
import ports.out.ToDoListRepository;
import ports.out.ToDoRepository;

public class AddToDoService implements AddToDoUseCase {

    private ToDoRepository toDoRepository;
    private ToDoListRepository toDoListRepository;

    public AddToDoService(ToDoRepository toDoRepository, ToDoListRepository toDoListRepository) {
        this.toDoRepository = toDoRepository;
        this.toDoListRepository = toDoListRepository;
    }

    @Override
    public ToDoList addToDo(ToDoListId id, ToDo toDo) {
        ToDoList list = toDoListRepository.findById(id);
        try {
            list.addToDo(toDo);
            toDoRepository.save(toDo);
            return toDoListRepository.save(list);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
