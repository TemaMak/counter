package temaMak.counters.converter;

import org.springframework.core.convert.converter.Converter;
import temaMak.counters.domain.CounterAction;
import temaMak.counters.exception.UnknownCounterActionException;

public class CounterActionConverter implements Converter<String, CounterAction> {

    @Override
    public CounterAction convert(String source) {
        if(source != null){
            try {
                return CounterAction.valueOf(source.toUpperCase());
            } catch(Exception e) {
                throw new UnknownCounterActionException();
            }
        }
        throw new UnknownCounterActionException();
    }

}
