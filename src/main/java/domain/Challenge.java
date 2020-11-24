package domain;

public class Challenge {
    private String id;
    private String title;
    private String parameters;

    public Challenge(String id, String title, String parameters) {
        this.id = id;
        this.title = title;
        this.parameters = parameters;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getParameters() {
        return parameters;
    }

    @Override
    public String toString() {
        return getId();
    }
}
