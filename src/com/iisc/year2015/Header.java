package com.iisc.year2015;

import org.dom4j.Element;

/**
 * Created by Dmitry on 16.11.2015.
 */
public class Header {

    String Cert;
    String Hash;
    String Sign;
    public Header(String SendCert, String SendHash, String SendSign) {
        Cert = SendCert;
        Hash = SendHash;
        Sign = SendSign;
    }

    public void CreateHeader(Element root) {
        Element Header = root.addElement("soap:Header");
        Element Security = Header.addElement("wsse:Security");
        Security.addAttribute("soap:actor", "http://smev.gosuslugi.ru/actors/smev");
        Element BinarySecurityToken = Security.addElement("wsse:BinarySecurityToken");
        BinarySecurityToken.addAttribute("EncodingType", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary");
        BinarySecurityToken.addAttribute("ValueType", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-x509-token-profile-1.0#X509v3");
        BinarySecurityToken.addAttribute("wsu:Id", "CertId-1");
        BinarySecurityToken.addAttribute("xmlns:wsu", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
        BinarySecurityToken.addText(Cert);
        Element Signature = Security.addElement("ds:Signature");
        Signature.addAttribute("Id", "Signature-1");
        Element SignedInfo = Signature.addElement("ds:SignedInfo");
        Element CanonicalizationMethod = SignedInfo.addElement("ds:CanonicalizationMethod");
        CanonicalizationMethod.addAttribute("Algorithm", "http://www.w3.org/2001/10/xml-exc-c14n#");
        Element SignatureMethod = SignedInfo.addElement("ds:SignatureMethod");
        SignatureMethod.addAttribute("Algorithm", "http://www.w3.org/2001/04/xmldsig-more#gostr34102001-gostr3411");
        Element Reference = SignedInfo.addElement("ds:Reference");
        Reference.addAttribute("URI", "#body");
        Element Transforms = Reference.addElement("ds:Transforms");
        Element Transform = Transforms.addElement("ds:Transform");
        Element DigestMethod = Reference.addElement("ds:DigestMethod");
        Element DigestValue = Reference.addElement("ds:DigestValue");
        DigestValue.addText(Hash);
        Element SignatureValue = Signature.addElement("ds:SignatureValue");
        SignatureValue.addText(Sign);
        Element KeyInfo = Signature.addElement("ds:KeyInfo");
        KeyInfo.addAttribute("Id", "KeyId-1");
        Element SecurityTokenReference = KeyInfo.addElement("wsse:SecurityTokenReference");
        SecurityTokenReference.addAttribute("wsu:Id", "STRId-1");
        SecurityTokenReference.addAttribute("xmlns:wsu", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
        Element Reference1 = SecurityTokenReference.addElement("wsse:Reference");
        Reference1.addAttribute("URI","#CertId-1");
        Reference1.addAttribute("ValueType","http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-x509-token-profile-1.0#X509v3");
    }


}
