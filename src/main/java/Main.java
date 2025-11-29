public class Main {
    public static void main(String[] args) {

        SimpleTask callParents = new SimpleTask(1, "Позвонить родителям");

        Epic groceries = new Epic(
                2,
                new String[]{"Молоко", "Хлеб", "Яйца"}
        );

        Meeting releaseMeeting = new Meeting(
                3,
                "Релиз новой версии",
                "Проект Банка",
                "В четверг утром"
        );

        Todos todos = new Todos();

        todos.add(callParents);
        todos.add(groceries);
        todos.add(releaseMeeting);

        System.out.println("Все задачи:");
        for (Task t : todos.findAll()) {
            System.out.println("- " + t.getId());
        }

        System.out.println("Поиск по запросу Банк:");
        for (Task t : todos.search("Банк")) {
            System.out.println("- " + t.getId());
        }
    }
}
