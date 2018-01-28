package registry;

import services.EnigmaService;

import java.util.List;

public interface ServiceProvider {
    List<String> listAll();
    EnigmaService getByName(String name);
}