package registry;

import services.EnigmaService;

public interface ServiceRegistry {
    void register(EnigmaService service);
}