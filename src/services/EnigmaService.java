package services;

import exceptions.WrongKeyEx;

public interface EnigmaService {

    String encipher(String text);

    String decipher(String text);

    boolean isKeyRequired();

    String getName();

    void setKey(String key) throws WrongKeyEx;
}

