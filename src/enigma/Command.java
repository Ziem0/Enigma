package enigma;

import exceptions.InvalidCommandTypeEx;

import java.util.List;

public class Command {

    private static final int TYPE_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int KEY_INDEX = 2;

    private static final String CMD_LIST = "-l";
    private static final String CMD_ENCIPHER = "-e";
    private static final String CMD_DECIPHER = "-d";

    private String[] command;
    private boolean isCmdList;
    private boolean isCmdEncipher;
    private String moduleName;
    private String key;


    public Command(String[] command) {
        this.command = command;
    }

    public boolean getIsCmdList() {
        return isCmdList;
    }

    public boolean getIsCmdEncipher() {
        return isCmdEncipher;
    }

    public String getModuleName() {
        return moduleName;
    }

    public String getKey() {
        return key;
    }

    public void resolverInput(List<String> repo) throws InvalidCommandTypeEx {
        if (isCmdList()) {
            isCmdList = true;
            isCmdEncipher = false;
        } else if (isCmdEncipher()) {
            isCmdList = false;
            isCmdEncipher = true;
            assignKey();
            assignModuleName(repo);
        } else if (!isCmdEncipher && !isCmdList) {
            isCmdList = false;
            isCmdEncipher = false;
            assignKey();
            assignModuleName(repo);
        } else {
            throw new InvalidCommandTypeEx("Invalid type of command (-e|-d|-l)");
        }
    }

    private void assignModuleName(List<String> repo) throws InvalidCommandTypeEx {
        for (String name : repo) {
            if (command[NAME_INDEX].compareToIgnoreCase(name) == 0) {
                moduleName = name;
            }
        }
        if (moduleName == null) {
            throw new InvalidCommandTypeEx("There is no enigma like that");
        }

    }

    private void assignKey() {
        if (command.length > 2) {
            key = command[KEY_INDEX];
        }
    }

    private boolean isCmdEncipher() {
        return command.length >= 2 && command[TYPE_INDEX].matches(CMD_ENCIPHER);
    }

    private boolean isCmdList() {
        return command.length == 1 && command[TYPE_INDEX].matches(CMD_LIST);
    }


}

