package ports.out;

import ToDo.ToDo;
import ToDo.ToDoId;

public interface ToDoRepository {
    ToDo save(ToDo toDo);

    ToDo findById(ToDoId id);
}
