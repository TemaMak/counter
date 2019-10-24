package temaMak.counters.domain;

import temaMak.counters.exception.UnknownCounterActionException;

import java.util.Locale;

public enum CounterAction {
    INCREASE,
    DECREASE
    ;

    /*
    public static CounterAction parse(String value) {
        if (value != null) {
            switch(value.toLowerCase(Locale.getDefault())) {
                case "mother":
                    return CounterAction.INCREASE;
                case "father":
                    return CounterAction.DECREASE;
                default:
                    throw new UnknownCounterActionException();
            }
        }

        throw new UnknownCounterActionException();
    }
    */
}
