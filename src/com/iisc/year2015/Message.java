package com.iisc.year2015;

import org.dom4j.Element;

/**
 * Created by Dmitry on 16.11.2015.
 */
public class Message {


    public static void CreateMessage (Element root) {
        Element Message = root.addElement("smev:Message");
        Message.addAttribute("xmlns:smev","http://smev.gosuslugi.ru/rev120315");

        Element Sender = Message.addElement("smev:Sender");
        Element Code = Sender.addElement("smev:Code")
                .addText("000000541");
        Element Name = Sender.addElement("smev:Name")
                .addText("Sender Name");

        Element Recipient = Message.addElement("smev:Recipient");
        Code = Recipient.addElement("smev:Code")
                .addText("000000542");
        Name = Recipient.addElement("smev:Name")
                .addText("Recipient Code");

        Element Originator = Message.addElement("smev:Originator");
        Code = Originator.addElement("smev:Code")
                .addText("000000541");
        Name = Originator.addElement("smev:Name")
                .addText("Sender Name");

        Element TypeCode = Message.addElement("smev:TypeCode")
                .addText("GSRV");
        Element Status = Message.addElement("smev:Status")
                .addText("REQUEST");
        Element Date = Message.addElement("smev:Date")
                .addText("2000-01-01T00:00:00");
        Element ExchangeType = Message.addElement("smev:ExchangeType")
                .addText("3");
        Element ServiceCode = Message.addElement("smev:ServiceCode")
                .addText("5440100010000545045");
        Element CaseNumber = Message.addElement("smev:CaseNumber")
                .addText("70263950");
    }
}
