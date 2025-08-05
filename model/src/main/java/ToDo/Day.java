package ToDo;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

import java.time.DayOfWeek;
import java.time.LocalDate;

@AllArgsConstructor
@Accessors(chain = true, fluent = true)
public class Day {
    private DayOfWeek weekday; // 1-7 Mo-So
    private LocalDate date;

    public Day (DayOfWeek weekday) {
        this.weekday = weekday;
        this.date = null;
    }

    public Day (LocalDate date) {
        this.date = date;
        this.weekday = date.getDayOfWeek();
    }

}
