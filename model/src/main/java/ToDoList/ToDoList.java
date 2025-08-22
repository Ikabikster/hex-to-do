package ToDoList;

import ToDo.ToDo;
import ToDo.ToDoId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Data
@Accessors(chain = true, fluent = true)
@AllArgsConstructor
public class ToDoList {

    private ToDoListId id;
    private String name;
    private List<ToDo> toDos;


    // generalized Filter for ToDos
    public List<ToDo> getFilteredToDos(Predicate<ToDo> filter) {
        return toDos.stream().filter(filter).collect(Collectors.toList());
    }

    public ToDo getToDoById(ToDoId toDoId) {
        for (ToDo toDo : toDos) {
            if (toDo.id.equals(toDoId)) {
                return toDo;
            }
        }
        return null;
    }

    // inclusive timespan, more in my line of thinking :)
    public List<ToDo> getToDosFor(LocalDate from, LocalDate to) {
        List<ToDo> returnList = new ArrayList<>();

        for (ToDo toDo : toDos) {
            if (toDo.getDate().isAfter(from.minusDays(1)) && toDo.getDate().isBefore(to.plusDays(1))) {
                returnList.add(toDo);
            }
        }
        return returnList;
    }

    public List<ToDo> getToDosFor(LocalDate day) {
        return getFilteredToDos(toDo -> toDo.getDate().equals(day));
    }

    public List<ToDo> getToDoBy(ToDo.ToDo.PRIO prio) {
        return getFilteredToDos(toDo -> toDo.getPrio().equals(prio));
    }

    public List<ToDo> changeStatus(ToDoId toDoId) {
        ToDo toDo = getToDoById(toDoId);
        if (toDo != null) {
            toDo.setDone();
        }
        return toDos;
    };

}
