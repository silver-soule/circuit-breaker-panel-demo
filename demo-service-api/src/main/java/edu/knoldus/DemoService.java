package edu.knoldus;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.restCall;
import static com.lightbend.lagom.javadsl.api.transport.Method.GET;

public interface DemoService extends Service {
    
    ServiceCall<NotUsed, String> getHelloOrFail(int index);
    
    @Override
    default Descriptor descriptor() {
        return named("circuit-breaker-demo")
                .withCalls(
                        restCall(GET, "/random/:index", this::getHelloOrFail)
                );
    }
}
