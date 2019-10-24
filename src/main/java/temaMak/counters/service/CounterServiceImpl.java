package temaMak.counters.service;

import org.springframework.stereotype.Service;
import temaMak.counters.domain.Counter;
import temaMak.counters.exception.NoFoundCounterException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CounterServiceImpl implements CounterService {

    protected static final Integer DEFAULT_COUNTER_VALUE = 0;
    protected static final Integer COUNTER_STEP= 1;
    protected ConcurrentHashMap<String,Integer> counterHolder = new ConcurrentHashMap<String,Integer>();

    @Override
    public Counter create(String counterName) {
        counterHolder.put(counterName,DEFAULT_COUNTER_VALUE);
        return get(counterName);
    }

    @Override
    public Counter increase(String counterName) {
        Counter currentCounter = get(counterName);
        counterHolder.put(counterName,currentCounter.getValue() + COUNTER_STEP);
        return get(counterName);
    }

    @Override
    public Counter decrease(String counterName) {
        Counter currentCounter = get(counterName);
        counterHolder.put(counterName,currentCounter.getValue() - COUNTER_STEP);
        return get(counterName);
    }

    @Override
    public Counter get(String counterName) {
        if (!counterHolder.containsKey(counterName)) {
            throw new NoFoundCounterException();
        }

        return new Counter(
            counterName,
            counterHolder.get(counterName)
        );
    }

    @Override
    public void drop(String counterName) throws NoFoundCounterException {
        Integer oldValue = counterHolder.remove(counterName);
        if(oldValue == null){
            throw new NoFoundCounterException();
        }
    }

    @Override
    public List<String> getNames() {
        return new ArrayList<String>(counterHolder.keySet());
    }

    @Override
    public Integer sum() {
        return counterHolder.values().stream().reduce(0, Integer::sum);
    }

}
