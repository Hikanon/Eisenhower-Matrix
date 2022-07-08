package eisenhowermatrix;

public class Goal {
    private String taskName;
    private boolean important;
    private boolean urgently;

    public Goal(String taskName, boolean important, boolean urgently) {
        this.taskName = taskName;
        this.important = important;
        this.urgently = urgently;
    }


    public String getTaskName() {
        return taskName;
    }

    public boolean isImportant() {
        return important;
    }

    public boolean isUrgently() {
        return urgently;
    }

    @Override
    public String toString() {
        return taskName + "&" + important + "&" + urgently;
    }
}

