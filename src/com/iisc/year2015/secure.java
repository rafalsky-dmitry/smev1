package com.iisc.year2015;

import org.apache.commons.codec.binary.Base64;
import ru.infotecs.crypto.ViPNetProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;

/**
 * Created by Dmitry on 23.11.2015.
 */
public class secure {
    public static void main(String[] args) throws NoSuchProviderException, NoSuchAlgorithmException, KeyStoreException, IOException, CertificateException, UnrecoverableKeyException {
        Security.addProvider(new ViPNetProvider());
        MessageDigest messageDigest = MessageDigest.getInstance("GOST3411-94", "ViPNet");
        messageDigest.update("".getBytes());
        byte[] digestValue = messageDigest.digest();
        System.out.printf(Base64.encodeBase64URLSafeString(digestValue));

        KeyStore keyStore = KeyStore.getInstance("ViPNetContainer","ViPNet");
        keyStore.load(null, null);
        InputStream inputStream = new FileInputStream("C:\\token");
        keyStore.load(inputStream, null);

        String alias = "key";
        char[] password = "1234567890".toCharArray();
        PrivateKey pKey = (PrivateKey) keyStore.getKey(alias, password);
        //System.out.println(keyStore);
        //System.out.println(pKey);

    }
}
