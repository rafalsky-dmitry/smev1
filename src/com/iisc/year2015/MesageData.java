package com.iisc.year2015;

import org.dom4j.Element;

/**
 * Created by Dmitry on 16.11.2015.
 */
public class MesageData {

    public static void CreateMesageData (Element root) {
        Element MessageData = root.addElement("smev:MessageData")
                .addAttribute("xmlns:smev", "http://smev.gosuslugi.ru/rev120315");
        Element AppData = MessageData.addElement("smev:AppData");
        Element DictionaryId = AppData.addElement("atc:DictionaryId");
        DictionaryId.addText("xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx");
    }
}
