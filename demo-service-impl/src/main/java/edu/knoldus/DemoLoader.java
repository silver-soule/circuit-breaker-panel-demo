package edu.knoldus;

import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;
import edu.knoldus.Random.Random;
import edu.knoldus.Random.RandomImpl;

public class DemoLoader extends AbstractModule implements ServiceGuiceSupport {
    
    @Override
    protected void configure() {
        bindService(DemoService.class, DemoServiceImpl.class);
        bind(Random.class).to(RandomImpl.class);
    }
}
