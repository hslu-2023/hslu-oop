package ch.hslu.oop.sw08.chemistry;

public enum PhysicalState {
    SOLID("solid"), LIQUID("liquid"), GAS("gaseous");

    private final String state;

    PhysicalState(final String state) {
        this.state = state;
    }

    public String getResult(ChemicalElement element, float temperature) {
        return String.format("%s is %s at %.2f°C.", element.getClass().getSimpleName(), this.state, temperature);
    }
}
