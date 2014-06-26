package example.documentation;

public enum Story {
    GTR101(FunctionalArea.AREA51),
    GTR102(FunctionalArea.AREA51),
    GTR103(FunctionalArea.AREA51);

    private FunctionalArea functionalArea;

    Story(FunctionalArea functionalArea) {
        this.functionalArea = functionalArea;
    }

    public FunctionalArea getFunctionalArea() {
        return functionalArea;
    }

}
