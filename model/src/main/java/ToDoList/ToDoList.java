package ToDoList;

import ToDo.ToDo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true, fluent = true)
@AllArgsConstructor
public class ToDoList {
    private ToDoListId id;
    private String name;
    private List<ToDo> toDos;

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
        List<ToDo> returnList = new ArrayList<>();

        for (ToDo toDo : toDos) {
            if (toDo.getDate().equals(day)) {
                returnList.add(toDo);
            }
        }
        return returnList;
    }

    public List<ToDo> getToDoByPrio(ToDo.ToDo.PRIO prio) {
        List<ToDo> returnList = new ArrayList<>();

        for (ToDo toDo : toDos) {
            if (toDo.getPrio().equals(prio)) {
                returnList.add(toDo);
            }
        }
        return returnList;
    }
}
