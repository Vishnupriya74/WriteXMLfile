package jsonproject;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.Result;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

import java.io.File;
import java.lang.System.Logger.Level;
import java.util.logging.Logger;

import javax.lang.model.element.Element;
import javax.xml.parsers.DocumentBuilder;

public class XMLWrite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    String path="src\\app\\student.xml";
    File f =new File(path);
    DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
    try {
    	DocumentBuilder builder=dbf.newDocumentBuilder();
    	Document doc=builder.newDocument();
    	Element root=(Element) doc.createElement("StudentList");
    	Element student=(Element) doc.createElement("Student");
    	
    	Element studentid=(Element) doc.createElement("StudentID");
    	Text idValue=doc.createTextNode("aoo1");
    	((Node) studentid).appendChild(idValue);
    	
    	Element studentname=(Element) doc.createElement("StudentName");
    	Text nameValue=doc.createTextNode("Demo");
    	((Node) studentname).appendChild(nameValue);
    	
    	Element Mark=(Element) doc.createElement("Mark");
    	Text markValue=doc.createTextNode("30");
    	((Node) Mark).appendChild(markValue);
    	
    	((Node) studentid).appendChild((Node) studentid);
    	((Node) studentid).appendChild((Node) studentname);
    	((Node) studentid).appendChild((Node) Mark);
    	
    	((Node) root).appendChild((Node) student);
    	
    	doc.appendChild((Node) root);
    	
    	DOMSource source = new DOMSource(doc);
    	String path1 = "src\\app\\student.xml";
    	TransformerFactory transformerfactory= TransformerFactory.newInstance();
    	Transformer transformer= transformerfactory.newTransformer();
    	transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
    	transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    	Object result;
		transformer.transform(source, (Result) result);
    	System.out.println("write data success to file "+path1);
    }catch(TransformerException ex)
    {
    	Logger.getLogger(XMLWrite.class.getName()).log(Level.SEVERE, null, ex);
    }catch (ParserConfigurationException ex)
    {
    	Logger.getLogger(XMLWrite.class.getName()).log(Level.SEVERE, null, ex);
    }
	}

}
