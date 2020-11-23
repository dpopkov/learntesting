package learn.junitia.ch02core.assumptions;

public class SystemUT {
    private Job currentJob;

    public void run(Job job) {
        currentJob = job;
    }

    public boolean hasJobToRun() {
        return currentJob != null;
    }
}
