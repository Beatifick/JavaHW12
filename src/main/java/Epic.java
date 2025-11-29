public class Epic extends Task {
    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        String q = query.toLowerCase();
        for (String sub : subtasks) {
            if (sub.toLowerCase().contains(q)) {
                return true;
            }
        }
        return false;
    }
}
