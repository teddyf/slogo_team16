package Controller.DataSetup;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;



public class DataSetup {
	private static String[] generalInfo = {"title", "initialType","initialState","dimensionx", "dimensiony","width","height","probability"};
	private String dataFilePath;
	
	public String getDataFilePath() {
		return dataFilePath;
	}

	public void setDataFilePath(String dataFilePath) {
		this.dataFilePath = dataFilePath;
	}

	public DataSetup(String dataFilePath){
		this.dataFilePath=dataFilePath;
	}
	
	public DataSetup(){
		
	}
	
	/**
	 * read in Document from xml
	 */
	public Document setUpDocumentToParse() throws ParserConfigurationException, SAXException, IOException{
		File file = new File (dataFilePath);

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(file);
		
		return document;
	}
	
	/**
	 * read info by each tag name
	 */
	public String readFileForTag(String tagName){
		try {
			Document document = setUpDocumentToParse();
			String result = document.getElementsByTagName(tagName).item(0).getTextContent().trim();
			if(result == null){
				result = "0" ; // set up the default value if some tags are missing
			}
			return result;			
		}
		catch (Exception e) {
			return "tag " + tagName + " is missing";
		}

	}
	
	
	/**
	 * initialize the info for all the simulation into the HashMap
	 */
	public HashMap<String,String> getGeneralInfo(){
		HashMap<String,String> info = new HashMap<String,String>();
		for (int i=0; i<generalInfo.length; i++){
			info.put(generalInfo[i], readFileForTag(generalInfo[i]));
		}
		//System.out.println("============================");
		//String temp = readFileForTag("sniffThreshold");
		//System.out.println("parse in double: " + Double.parseDouble(temp));
			return info;
	}
	
	
	/**
	 * initialize the states for workspace
	 */
	public void setInitialStates(){
		
	}

}