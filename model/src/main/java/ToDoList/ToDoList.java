package ToDoList;

import ToDo.ToDo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true, fluent = true)
@AllArgsConstructor
public class ToDoList {
    private ToDoListId id;
    private String name;
    private List<ToDo> toDos;
}
