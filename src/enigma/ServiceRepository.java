package enigma;

import registry.ServiceProvider;
import registry.ServiceRegistry;
import services.EnigmaService;

import java.util.LinkedList;
import java.util.List;

public class ServiceRepository implements ServiceRegistry, ServiceProvider{
    List<EnigmaService> services = new LinkedList<>();


    @Override
    public void register(EnigmaService service) {
        services.add(service);
    }

    @Override
    public List<String> listAll() {
        List<String> result = new LinkedList<>();
        for (EnigmaService service : services) {
            result.add(service.getName());
        }
        return result;
    }

    @Override
    public EnigmaService getByName(String name) {
        for (EnigmaService service : services) {
            if (service.getName().equals(name)) {
                return service;
            }
        }
        return null;
    }
}