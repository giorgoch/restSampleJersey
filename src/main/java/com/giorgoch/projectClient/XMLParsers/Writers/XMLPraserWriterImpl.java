package com.giorgoch.projectClient.XMLParsers.Writers;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.stereotype.Service;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.giorgoch.projectClient.Model.User;

@Service("xmlParserReaderWriterImpl")
public class XMLPraserWriterImpl implements XMLParserWriter {

	@Override
	public void createXMLFormFormData(User user) {

		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("User");
			doc.appendChild(rootElement);

			// staff elements
			Element userdetails = doc.createElement("user");
			rootElement.appendChild(userdetails);

			// set attribute to staff element
			Attr attr = doc.createAttribute("id");
			attr.setValue("1");
			userdetails.setAttributeNode(attr);

			// shorten way
			// staff.setAttribute("id", "1");

			// firstname elements
			Element firstname = doc.createElement("firstname");
			firstname.appendChild(doc.createTextNode(user.getName()));
			userdetails.appendChild(firstname);

			// lastname elements
			Element lastname = doc.createElement("lastname");
			lastname.appendChild(doc.createTextNode(user.getLname()));
			userdetails.appendChild(lastname);

			// nickname elements
			Element address = doc.createElement("Address");
			address.appendChild(doc.createTextNode(user.getAddress()));
			userdetails.appendChild(address);

			// salary elements
			Element postcode = doc.createElement("Postcode");
			postcode.appendChild(doc.createTextNode(user.getPostcode()));
			userdetails.appendChild(postcode);

			Element city = doc.createElement("City");
			city.appendChild(doc.createTextNode(user.getCity()));
			userdetails.appendChild(city);

			Element tel = doc.createElement("Tel");
			tel.appendChild(doc.createTextNode(user.getTel()));
			userdetails.appendChild(tel);

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			// For develpmenet only to be formatet otherwise it's size is bigger
			// therefore without Outputkeys is one line format reduce the size
			// transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			StreamResult result = new StreamResult(new File("D:\\xmloutput\\file.xml"));

			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

			System.out.println("File saved!");
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}

}
