package wtf.sikelio;

public enum Stage {
    Benin,
    Moderate,
    Dangerous,
    Severe;

    public Stage next() {
        Stage[] stages = Stage.values();
        int nextOrdinal = (this.ordinal() + 1) % stages.length;

        return stages[nextOrdinal];
    }
}
