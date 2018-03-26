package edu.knoldus;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.client.CircuitBreakersPanel;
import edu.knoldus.Random.SillyRepository;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;

public class DemoServiceImpl implements DemoService {
    
    private SillyRepository sillyRepository;
    
    private CircuitBreakersPanel circuitBreaker;
    
    @Inject
    public DemoServiceImpl(SillyRepository sillyRepository, CircuitBreakersPanel circuitBreaker) {
        this.sillyRepository = sillyRepository;
        this.circuitBreaker = circuitBreaker;
    }
    
    @Override
    public ServiceCall<NotUsed, String> getHelloOrFail(int index) {
        return (request) -> circuitBreaker
                .withCircuitBreaker("breakerA",
                        () -> CompletableFuture.completedFuture(sillyRepository.getSomethingRandom(index)));
    }
}
