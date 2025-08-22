package ports.in;

import ToDoList.ToDoList;

public interface CreateToDoListUseCase {
    ToDoList create(String name);
}
