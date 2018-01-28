package enigma;

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
    
}
