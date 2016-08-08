package com.saveTofile;

//Store accounts in xml, csv and any SQL DB (in all 3 data storages)

public class SaveToXML {

    private String outputFile = "src/logs/accounts.xml";

    public void saveToXML(String username, String password) {
//        try {
//            Document document = new Document();
//            Element acc = new Element("account");
//            child.addContent(new Element("email").setText(username));
//            child.addContent(new Element("password").setText(password));
//            document.setContent(acc);
//
//            TransformerFactory tranFactory = TransformerFactory.newInstance();
//            Transformer aTransformer = tranFactory.newTransformer();
//            Source src = new DOMSource(document);
//            Result dest = new StreamResult(new File(outputFile));
//            aTransformer.transform(src, dest);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

}