package ports.in;

import ToDoList.ToDoList;
import ToDoList.ToDoListId;

import java.util.List;

public interface GetToDoListUseCase {
    ToDoList getToDoList(ToDoListId id);
    List<ToDoList> getToDoLists();
}
