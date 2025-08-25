package service.ToDoList;

import ToDo.ToDo;
import ToDo.ToDoId;
import ports.in.ChangeToDoUseCase;
import ports.out.ToDoRepository;

import java.util.Objects;

public class ChangeToDoService implements ChangeToDoUseCase {

    private final ToDoRepository toDoRepository;

    public ChangeToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public ToDo changeToDo(ToDoId id, ToDo newToDo) {
        Objects.requireNonNull(newToDo, "ToDo darf nicht null sein");

        try {
            ToDo toDo = toDoRepository.findById(id);

            if (newToDo.title().equals(toDo.title())) {
                toDo.title(newToDo.title());}

            if (newToDo.notes() != null && !newToDo.notes().equals(toDo.notes())) {
                toDo.notes(newToDo.notes());}

            if (newToDo.dueDay() != null && !newToDo.dueDay().equals(toDo.dueDay())) {
                toDo.dueDay(newToDo.dueDay());}

            if (newToDo.assignee() != null && !newToDo.assignee().equals(toDo.assignee())) {
                toDo.assignee(newToDo.assignee());}

            if (newToDo.prio() != null && !newToDo.prio().equals(toDo.prio())) {
                toDo.prio(newToDo.prio());}

            if (newToDo.groups() != null && !newToDo.groups().equals(toDo.groups())) {
                toDo.groups(newToDo.groups());}

            if (newToDo.done() != toDo.done()) {
                toDo.done(newToDo.done());}

            return toDoRepository.save(toDo);
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}

