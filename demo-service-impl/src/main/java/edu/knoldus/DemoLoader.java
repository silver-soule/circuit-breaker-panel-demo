package edu.knoldus;

import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;
import edu.knoldus.repository.SillyRepository;
import edu.knoldus.repository.SillyRepositoryImpl;

public class DemoLoader extends AbstractModule implements ServiceGuiceSupport {
    
    @Override
    protected void configure() {
        bindService(DemoService.class, DemoServiceImpl.class);
        bind(SillyRepository.class).to(SillyRepositoryImpl.class);
    }
}
