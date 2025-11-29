import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    Todos todos = new Todos();

    @Test
    public void shouldAddThreeTasksOfDifferentType() {

        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOnlySimpleTaskByQuery() {

        SimpleTask simple = new SimpleTask(1, "Позвонить маме");
        Epic epic = new Epic(2, new String[]{"Молоко", "Хлеб"});
        Meeting meeting = new Meeting(3, "Совещание", "Проект", "Утро");

        todos.add(simple);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simple};
        Task[] actual = todos.search("маме");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSeveralTasks() {

        SimpleTask simple = new SimpleTask(1, "Купить молоко");
        Epic epic = new Epic(2, new String[]{"Молоко", "Хлеб"});
        Meeting meeting = new Meeting(3, "Совещание", "Проект", "Утро");

        todos.add(simple);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simple, epic};
        Task[] actual = todos.search("Молоко");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyArrayIfNothingFound() {

        todos.add(new SimpleTask(1, "Позвонить маме"));

        Task[] expected = {};
        Task[] actual = todos.search("папе");

        Assertions.assertArrayEquals(expected, actual);
    }
}
