package app;


import registry.ServiceProvider;

public interface Module {

    void initialize(ServiceProvider serviceProvider);
    String getName();
    void start();
}
