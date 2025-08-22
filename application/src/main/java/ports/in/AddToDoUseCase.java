package ports.in;

import ToDo.ToDo;
import ToDoList.ToDoList;
import ToDoList.ToDoListId;

public interface AddToDoUseCase {
    ToDoList addToDo(ToDoListId id, ToDo toDo);
}
