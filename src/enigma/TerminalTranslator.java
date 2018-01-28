package enigma;

import app.Module;
import exceptions.WrongKeyEx;
import registry.ServiceProvider;
import services.EnigmaService;

import java.util.List;
import java.util.Scanner;

public class TerminalTranslator implements Module {
    private ServiceProvider provider;
    private EnigmaService enigma;
    private String cipher;
    private String key;
    private boolean listServices;
    private boolean encipher;

    public TerminalTranslator(boolean listServices, boolean encipher, String cipher, String key) {
        this.cipher = cipher;
        this.key = key;
        this.listServices = listServices;
        this.encipher = encipher;
    }


    @Override
    public void initialize(ServiceProvider provider) {
        this.provider = provider;
    }

    @Override
    public String getName() {
        return "Terminal Translator";
    }

    @Override
    public void start() throws WrongKeyEx {
        if (listServices) {
            List<String> allServices = provider.listAll();
            for (String nameService : allServices) {
                System.out.println(nameService);
            }
        } else {
            enigma = provider.getByName(cipher);

            if (enigma.isKeyRequired()) {
                enigma.setKey(key);
            }
        }

        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            if (encipher) {
                System.out.println(enigma.encipher(in.nextLine()));
            } else {
                System.out.println(enigma.decipher(in.nextLine()));
            }
        }
        in.close();
    }
}