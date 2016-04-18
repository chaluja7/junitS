package cz.cvut.junit.security;

import java.security.MessageDigest;

/**
 * Helper class for hash comutation.
 *
 * @author jakubchalupa
 * @since 24.11.14.
 */
public class HashUtils {

    public static final String BCRYPT = "BCRYPT";
    public static final String SHA = "SHA";
    private static final int SALT_LENGTH = 12;

    public static String getHash(String s, String method) {
        if (method.equals(BCRYPT)) {
            return computeBcryptHash(s);
        } else {
            return computeSHAHash(s);
        }
    }

    public static boolean matchHash(String original, String hashed, String method) {
        if (method.equals(BCRYPT)) {
            return matchBcryptHash(original, hashed);
        } else {
            return matchSHAHash(original, hashed);
        }
    }

    private static boolean matchSHAHash(String original, String hashed) {
        String originalHash = computeSHAHash(original);
        return originalHash.equals(hashed);
    }

    private static String convertToHex(byte[] data) {
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int twoHalfs = 0;

            do {
                if ((0 <= halfbyte) && (halfbyte <= 9)) {
                    builder.append((char) ('0' + halfbyte));
                } else {
                    builder.append((char) ('a' + (halfbyte - 10)));
                }
                halfbyte = data[i] & 0x0F;

            } while (twoHalfs++ < 1);
        }

        return builder.toString();
    }

    private static String computeSHAHash(String s) {
        if(s == null) {
            return null;
        }

        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            md.update(s.getBytes("utf8"), 0, s.length());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        byte[] sha256hash = md.digest();
        return convertToHex(sha256hash);
    }

    private static String computeBcryptHash (String s) {
        return BCrypt.hashpw(s, BCrypt.gensalt(SALT_LENGTH));
    }

    private static boolean matchBcryptHash (String original, String hashed) {
        return BCrypt.checkpw(original, hashed);
    }


}
