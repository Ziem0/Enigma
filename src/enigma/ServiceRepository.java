package enigma;

import registry.ServiceProvider;
import services.EnigmaService;

import java.util.List;

public class ServiceRepository implements ServiceProvider, registry.ServiceRegistry{

    List<EnigmaService> services;

    @Override
    public List<String> listAll() {
        return null;
    }

    @Override
    public EnigmaService getByName(String name) {
        return null;
    }

    @Override
    public void register(EnigmaService service) {

    }
}