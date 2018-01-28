package enigma;

import app.Module;
import exceptions.InvalidCommandTypeEx;
import exceptions.WrongKeyEx;

public class App{

    public static void main(String[] args) {
        ServiceRepository repo = new ServiceRepository();
        repo.register(new CesarEnigma());

        Command cmd = new Command(args);
        try {
            cmd.resolverInput(repo.listAll());
        } catch (InvalidCommandTypeEx invalidCommandTypeEx) {
            invalidCommandTypeEx.printStackTrace();
        }

        Module module = new TerminalTranslator(cmd.getIsCmdList(), cmd.getIsCmdEncipher(), cmd.getModuleName(), cmd.getKey());
        module.initialize(repo);
        try {
            module.start();
        } catch (WrongKeyEx wrongKeyEx) {
            wrongKeyEx.printStackTrace();
        }

    }
}
