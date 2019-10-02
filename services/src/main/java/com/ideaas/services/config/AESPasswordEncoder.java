package com.ideaas.services.config;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.engines.RijndaelEngine;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.paddings.ZeroBytePadding;
import org.bouncycastle.crypto.params.KeyParameter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;


public class AESPasswordEncoder implements PasswordEncoder {

    private final String key = "f2d2r3c4#EDC4rfv";

    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    /**
     * @param charSequence password sent via login
     * @param password encrypted DB password
     *
     * @return
     */
    @Override
    public boolean matches(CharSequence charSequence, String password) {
        String encryptedCharSequence = null;
        try {
            encryptedCharSequence = encrypt(charSequence.toString());
        } catch (InvalidCipherTextException e) {
            e.printStackTrace();
        }
        return password.equals(encryptedCharSequence);
    }

    /**
     * Step 1: password and key are converted to bytes in order to be processed by the cypher.
     *
     * Step 2: a KeyParameter is created with the key bytes.
     *
     * Step 3: a PaddedBufferedBlockCipher statement is assigned with Rijndael 256 algorithm and ZeroBytePadding, this padder adds NULL byte padding to a block.
     *
     * Step 4: the bufferedBlockCipher is then initialized with parameters "true" meaning Encryption mode, and the KeyParameter.
     * This initialization prepares the bufferedBlock with the parameters needed for encryption.
     *
     * Step 5: a variable "buffer" stores the length in bytes the output should have
     *
     * Step 6: the processed bytes are calculated and stored, buffer now stores the value of the password
     *
     * Step 7: the encryption is finalized, the plus equals sign ensures that the output is multiple of 32
     *
     * Step 8: the buffer and processedBytes are converted into an array of bytes and then a String
     *
     * @param password
     *
     * @return
     */

    public String encrypt(String password) throws InvalidCipherTextException {
        byte[] data = password.getBytes();
        byte[] encryptionKey = key.getBytes();

        KeyParameter keyParameter = new KeyParameter(encryptionKey);

        PaddedBufferedBlockCipher bufferedBlockCipher = new PaddedBufferedBlockCipher(new RijndaelEngine(256), new ZeroBytePadding());
        bufferedBlockCipher.init(true, keyParameter);

        byte[] buffer = new byte[bufferedBlockCipher.getOutputSize(data.length)];
        int processedBytes = bufferedBlockCipher.processBytes(data, 0, data.length, buffer, 0);
        processedBytes += bufferedBlockCipher.doFinal(buffer, processedBytes);

        byte[] result = Arrays.copyOfRange(buffer, 0, processedBytes);
        String output = Base64.encodeBase64String(result);

        return output;
    }


}
