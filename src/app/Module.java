package app;

import exceptions.WrongKeyEx;
import registry.ServiceProvider;

public interface Module {

    void initialize(ServiceProvider provider);
    String getName();
    void start() throws WrongKeyEx;
}
