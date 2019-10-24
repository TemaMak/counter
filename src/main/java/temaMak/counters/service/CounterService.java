package temaMak.counters.service;

import temaMak.counters.domain.Counter;
import temaMak.counters.exception.NoFoundCounterException;

import java.util.List;

public interface CounterService {

    Counter create(String counterName);
    Counter increase(String counterName) throws NoFoundCounterException;
    Counter decrease(String counterName) throws NoFoundCounterException;
    Counter get(String counterName) throws NoFoundCounterException;
    void drop(String counterName) throws NoFoundCounterException;
    List<String> getNames();
    Integer sum();
}
