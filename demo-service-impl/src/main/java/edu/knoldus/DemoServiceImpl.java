package edu.knoldus;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.client.CircuitBreakersPanel;
import edu.knoldus.Random.Random;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;

public class DemoServiceImpl implements DemoService {
    
    private Random random;
    
    CircuitBreakersPanel circuitBreaker;
    
    @Inject
    public DemoServiceImpl(Random random, CircuitBreakersPanel circuitBreaker) {
        this.random = random;
        this.circuitBreaker = circuitBreaker;
        
    }
    
    @Override
    public ServiceCall<NotUsed, String> getHelloOrFail(int index) {
        return (request) -> circuitBreaker
                .withCircuitBreaker("breakerA", () -> CompletableFuture.completedFuture(random.getSomethingRandom(index)));
    }
}
