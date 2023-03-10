package helpers.enums;

public class StateEnums {

    public enum State {
        AA("AA"),
        AE("AE"),
        ALABAMA("Alabama"),
        ALASKA("Alaska");

        private final String stateEnums;

        State(String stateEnums) {
            this.stateEnums = stateEnums;
        }
        public String getState() {
            return this.stateEnums;
        }
    }
}
