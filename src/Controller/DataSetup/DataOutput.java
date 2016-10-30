package Controller.DataSetup;


import java.io.File;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DataOutput {
	
	private String outputFileName; 
	
	private Map<String, String> data;
	public DataOutput(String outputFileName, Map<String, String> data) {
		this.outputFileName=outputFileName.replaceAll(" ", "_");
		this.data = data;
		writeXML();
	}
	

	/**
	 * create a new xml in data folder 
	 * write the current workspace into xml file created
	 */
	public void writeXML(){
		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("root");
			doc.appendChild(rootElement);
			
			for (int i=0; i<DataSetup.generalInfo.length; i++){
				Element currentState = doc.createElement(DataSetup.generalInfo[i]);
				currentState.appendChild(doc.createTextNode(data.get(DataSetup.generalInfo[i])));
				rootElement.appendChild(currentState);	
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("data/"+outputFileName));

			transformer.transform(source, result);

			System.out.println("File saved!");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe){
			tfe.printStackTrace();
		}

	}


}
