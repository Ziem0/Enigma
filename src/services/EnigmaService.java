package services;

public interface EnigmaService {

    String encipher(String text);
    String decipher(String text);
    String getName();
    boolean isKeyRequired();
    void setKey(String text);

}
