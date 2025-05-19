package application.model.BatchIndhold;

public enum WhiskyTyper {
    SINGLE_CASK("Single cask"), SINGLE_MALT("Single malt"), BLENDED("Blended"), CASK_STRENGTH("Cask strength");
    private String display;

    WhiskyTyper(String display){
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }
}
