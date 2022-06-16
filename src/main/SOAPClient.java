package main;

import java.util.HashMap;

import org.jrichardsz.soapeasier.SimpleHttpSoapClient;
import org.jrichardsz.soapeasier.core.impl.SoapClasspathMessage;

public class SOAPClient {

	public static void main(String[] args) throws Exception {
		System.setProperty("http.proxyHost", "127.0.0.1");
	    System.setProperty("https.proxyHost", "127.0.0.1");
	    System.setProperty("http.proxyPort", "8866");
	    System.setProperty("https.proxyPort", "8866");

		simpleHttpSoapClientTest();
		System.out.println();
		simpleHttpSoapClientWithParametersTest();
		System.out.println();
		simpleHttpsSoapClientTest();
		System.out.println();
		simpleHttpsSoapClientWithBasicAuthTest();
	}

	private static void simpleHttpSoapClientTest() throws Exception {
		SimpleHttpSoapClient client = new SimpleHttpSoapClient();

		client.setServiceUrl("http://www.crcind.com/csp/samples/SOAP.Demo.cls");
		client.setContentType("text/xml; charset=utf-8");
		client.setSoapAction("http://tempuri.org/SOAP.Demo.AddInteger");

		client.configure();

		SoapClasspathMessage message = new SoapClasspathMessage();
		message.setXmlLocation("/resources/soap-message-sample.xml");
		String response = client.performOperation(message);

		System.out.println(response);
	}

	private static void simpleHttpSoapClientWithParametersTest() throws Exception {
		SimpleHttpSoapClient client = new SimpleHttpSoapClient();

		client.setServiceUrl("http://www.crcind.com/csp/samples/SOAP.Demo.cls");
		client.setContentType("text/xml; charset=utf-8");
		client.setSoapAction("http://tempuri.org/SOAP.Demo.AddInteger");

		client.configure();

		SoapClasspathMessage message = new SoapClasspathMessage();
		message.setXmlLocation("/resources/soap-message-sample-with-parameters.xml");

		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("addend1", 5);
		parameters.put("addend2", 140);   

		String response = client.performOperation(message, parameters);

		System.out.println(response);
	}

	private static void simpleHttpsSoapClientTest() throws Exception {
		SimpleHttpSoapClient client = new SimpleHttpSoapClient();

		client.setServiceUrl("http://www.crcind.com/csp/samples/SOAP.Demo.cls");
		client.setContentType("text/xml; charset=utf-8");
		client.setSoapAction("http://tempuri.org/SOAP.Demo.AddInteger");

		client.setSkipCertificateValidation(true);
		client.setAllowedStringHostnames("crcind.com");

		client.configure();

		SoapClasspathMessage message = new SoapClasspathMessage();
		message.setXmlLocation("/resources/soap-message-sample.xml");
		String response = client.performOperation(message);

		System.out.println(response);
	}

	private static void simpleHttpsSoapClientWithBasicAuthTest() throws Exception {
		SimpleHttpSoapClient client = new SimpleHttpSoapClient();

		client.setServiceUrl("http://www.crcind.com/csp/samples/SOAP.Demo.cls");
		client.setContentType("text/xml; charset=utf-8");
		client.setSoapAction("http://tempuri.org/SOAP.Demo.AddInteger");

		client.setSkipCertificateValidation(true);
		client.setAllowedStringHostnames("crcind.com");

		client.setBasicAuthUser("jane");
		client.setBasicAuthPassword("doe");

		client.configure();

		SoapClasspathMessage message = new SoapClasspathMessage();
		message.setXmlLocation("/resources/soap-message-sample.xml");

		String response = client.performOperation(message);

		System.out.println(response);;
	}
}