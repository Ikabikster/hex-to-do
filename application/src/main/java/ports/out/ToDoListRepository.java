package ports.out;

import ToDoList.ToDoList;
import ToDoList.ToDoListId;

import java.util.List;

public interface ToDoListRepository {
    ToDoList findById(ToDoListId id);

    ToDoList save(ToDoList list);

    List<ToDoList> findAll();
}
