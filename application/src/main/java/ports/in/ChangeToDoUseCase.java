package ports.in;

import ToDo.ToDo;
import ToDo.ToDoId;

public interface ChangeToDoUseCase {
    ToDo changeToDo(ToDoId id, ToDo toDo);
}
