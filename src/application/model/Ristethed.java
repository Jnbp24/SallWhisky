package application.model;

public enum Ristethed {
    IKKE_RISTET("Ikke ristet"), LET_RISTET("Let ristet"), SVÆRT_RISTET("Svært ristet");
    private String display;

    Ristethed(String display) {

    }

    public String getDisplay() {
        return display;
    }
}
