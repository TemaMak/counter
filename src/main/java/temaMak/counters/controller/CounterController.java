package temaMak.counters.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import temaMak.counters.domain.Counter;
import temaMak.counters.domain.CounterAction;
import temaMak.counters.service.CounterService;

import java.util.List;

@RestController
public class CounterController {

    @Autowired
    CounterService  counterService;

    @RequestMapping(value = "/counter/{counterName}", method = RequestMethod.PUT)
    public ResponseEntity<Counter> create(
        @PathVariable String counterName
    ) throws Throwable {

        return ResponseEntity
            .ok()
            .body(
                counterService.create(counterName)
            );
    }

    @RequestMapping(value = "/counter/{counterName}", method = RequestMethod.GET)
    public ResponseEntity<Counter> get(
            @PathVariable String counterName
    ) throws Throwable {

        return ResponseEntity
                .ok()
                .body(
                    counterService.get(counterName)
                );
    }

    @RequestMapping(value = "/counter/{counterName}", method = RequestMethod.DELETE)
    public ResponseEntity delete(
            @PathVariable String counterName
    ) throws Throwable {

        counterService.drop(counterName);
        return ResponseEntity.ok().body(null);
    }

    @RequestMapping(value = "/counter/{counterName}/action/{action}", method = RequestMethod.PATCH)
    public ResponseEntity<Counter> update(
        @PathVariable String counterName,
        @PathVariable CounterAction action
    ) throws Throwable{
        Counter currentCounter;
        switch(action){
            case DECREASE:
                currentCounter = counterService.decrease(counterName);
                break;
            case INCREASE:
            default:
                currentCounter = counterService.increase(counterName);
                break;
        }

        return ResponseEntity
            .ok()
            .body(currentCounter);
    }

    @RequestMapping(value = "/counter", method = RequestMethod.GET)
    public ResponseEntity<List<String>> allList() throws Throwable {

        return ResponseEntity
                .ok()
                .body(
                    counterService.getNames()
                );
    }

    @RequestMapping(value = "/sum", method = RequestMethod.GET)
    public ResponseEntity<Integer> agregate() throws Throwable {

        return ResponseEntity
                .ok()
                .body(
                    counterService.sum()
                );
    }
}
