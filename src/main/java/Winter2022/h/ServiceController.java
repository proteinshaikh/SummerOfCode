package Winter2022.h;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    @CircuitBreaker(name = "backendA")
    @Retry(name = "backendA")
    public String callServiceA() {
        // Call service A
        return null;
    }

    @CircuitBreaker(name = "backendB")
    @Retry(name = "backendB")
    public String callServiceB() {
        // Call service B
        return null;
    }

}
