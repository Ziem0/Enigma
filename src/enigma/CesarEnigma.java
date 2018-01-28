package enigma;

import exceptions.WrongKeyEx;
import services.EnigmaService;

public class CesarEnigma implements EnigmaService {
    public static final String NAME = "CesarEnigma";
    public static final boolean IS_KEY_REQUIRED = true;
    private static final int CHAR_TOTAL = 26;
    private int shift;

    public CesarEnigma() {
        this.shift = 0;
    }

    @Override
    public String encipher(String text) {
        String ciphered = "";

        for (char ch : text.toCharArray()) {
            boolean isLower = String.valueOf(ch).matches("[a-z]");
            ch += shift;

            if (isLower && ch > 'z' || !isLower && ch > 'Z') {
                ch -= CHAR_TOTAL;
                ciphered += ch;
            } else {
                ciphered += ch;
            }
        }
        return ciphered;
    }

    @Override
    public String decipher(String text) {
        String deciphered = "";

        for (char ch : text.toCharArray()) {
            boolean isLower = String.valueOf(ch).matches("[a-z]");
            ch -= shift;

            if (isLower && ch < 'a' || !isLower && ch < 'A') {
                ch += CHAR_TOTAL;
                deciphered += ch;
            } else {
                deciphered += ch;
            }
        }

        return deciphered;
    }

    @Override
    public boolean isKeyRequired() {
        return IS_KEY_REQUIRED;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void setKey(String key) throws WrongKeyEx {
        try {
            this.shift = Integer.parseInt(key, 10);
        } catch (NumberFormatException e) {
            throw new WrongKeyEx("Wrong key. Application terminated");
        }
    }


//    public static void main(String[] args) throws WrongKeyEx {
//
//        CesarEnigma e = new CesarEnigma();
//        e.setKey("1");
//
//        System.out.println(e.decipher("Ajfnp"));
//
//    }

}
