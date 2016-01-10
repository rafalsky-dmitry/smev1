package com.iisc.year2015;

import org.apache.commons.codec.binary.Base64;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
//import ru.infotecs.crypto.ViPNetProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;

public class Main {
    public static void main(String[] args) throws NoSuchProviderException, NoSuchAlgorithmException, KeyStoreException, IOException, CertificateException, UnrecoverableKeyException {
        /*
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
        */

        Document xml = DocumentHelper.createDocument(); //создаем
        Element root = xml.addElement("soap:Envelope"); // добавляем
        root.addNamespace("soap", "http://schemas.xmlsoap.org/soap/envelope/");
        root.addNamespace("wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
        root.addNamespace("wsu", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
        root.addNamespace("ds", "http://www.w3.org/2000/09/xmldsig#");
        root.addNamespace("atc", "http://at-sibir.ru/getDictionary");
        root.addNamespace("smev", "http://smev.gosuslugi.ru/rev120315");
        Header header = new Header("Cert", "Hash", "Sign");
        header.CreateHeader(root);
        Element Body = root.addElement("soap:Body");
        Body.addAttribute("wsu:Id", "body");
        Body.addAttribute("xmlns:wsu", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
        Element getDictionary = Body.addElement("atc:getDictionary");
        getDictionary.addAttribute("xmlns:atc", "http://at-sibir.ru/getDictionary");
        Message message = new Message("a", "1", "b", "2", "c", "3");
        message.CreateMessage(getDictionary);
        MesageData mesagedata = new MesageData("DId");
        mesagedata.CreateMesageData(getDictionary);
        System.out.println(root.asXML()); // выводим



    }


}
