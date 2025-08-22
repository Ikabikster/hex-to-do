package ToDo;

import Group.Group;
import User.UserId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@Accessors(chain = true, fluent = true)
public class ToDo {
    private ToDoId id;
    @NonNull
    private String title;
    private String notes;
    private Day dueDay;
    private UserId assignee;
    private PRIO prio;
    private List<Group> groups;
    private boolean done;

    public enum PRIO {LOW, NORMAL, HIGH}

    public ToDo(String title, String notes, Day day) {
        this(null, title, notes, day, null, PRIO.NORMAL, null, false);
    }

    public PRIO getPrio() {
        if (!(this.dueDay.date().isBefore(LocalDate.now()) || this.done)) {
            this.prio = PRIO.HIGH;
        }
        return prio;
    }

    public DayOfWeek getWeekday() {
        return this.dueDay.weekday();
    }

    public LocalDate getDate() {
        return this.dueDay.date();
    }
}
