package deansoffice;

public class Studies {
    private String name;
    private String description;
    private int totalSemesters;
    private int maxAllowedITNs;

    public Studies(String name, String description, int totalSemesters, int maxAllowedITNs) {
        this.name = name;
        this.description = description;
        this.totalSemesters = totalSemesters;
        this.maxAllowedITNs = maxAllowedITNs;
    }

    public int getTotalSemesters() {
        return totalSemesters;
    }

    public int getMaxAllowedITNs() {
        return maxAllowedITNs;
    }
}
