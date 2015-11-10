package org.sakaiproject.videoconference.adobeconnect.service;

import java.io.InputStream;

import javax.xml.parsers.*;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Parser 
{
	
	private Document document;
	
	public Parser(InputStream resultStream) 
	{
		try 
		{
			DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();

			document = parser.parse(resultStream);
			
			//System.out.println("-------------------------------------");
			//printDocument(document);

		} catch (Exception e) {
			System.out.println("error in setting up parser feature");
			document = null;
		}
	}
	
	public Document getDocument() { return document; }
	
	public String getNodeValue(String name, Node node)
	{
		if (node == null)
            return "";

        int type = node.getNodeType();
        if(type == Node.DOCUMENT_NODE)
        	return getNodeValue(name,((Document)node).getDocumentElement());
          
        if(type == Node.TEXT_NODE)
        	return "";
        
        if(node.getNodeName().equals(name))
        	return node.getTextContent();             
        
        String ret = "";
        NodeList children = node.getChildNodes();
		if (children != null) {
            int len = children.getLength();
            for (int i = 0; i < len; i++) 
            {
               Node n = children.item(i);               
               ret = getNodeValue(name,n);
               
               if(ret != "")
            	   break;
            }
        }
		
		return ret;
	}
	
	
	public String getNodeAttribute(String name, String attribute, Node node)
	{
		if (node == null)
            return "";

		
        int type = node.getNodeType();
        if(type == Node.DOCUMENT_NODE)
        	return getNodeAttribute(name, attribute, ((Document)node).getDocumentElement());          
        
        if(type == Node.TEXT_NODE)
        	return "";
        
        if(node.getNodeName().equals(name))
        {
        	Node res = node.getAttributes().getNamedItem(attribute);
        	if(res != null)
        		return res.getNodeValue();
        	return "";
        }
        
        String ret = "";
        NodeList children = node.getChildNodes();
		if (children != null) {
            int len = children.getLength();
            for (int i = 0; i < len; i++) 
            {
               Node n = children.item(i);               
               ret = getNodeAttribute(name,attribute,n);
               
               if(ret != "")
            	   break;
            }
        }
		
		return ret;
	}

	
	public String  getNodeValue(String name)
	{
		try
		{
			NodeList l = document.getElementsByTagName(name);
		
			if(l != null)
			{
				Node n = l.item(0);
				return n.getTextContent();
			}
			return "";
		}catch (Exception e) {
			return "";
		}
	}
	
	public String getNodeAttribute(String name, String attribute)
	{
		try
		{
			NodeList l = document.getElementsByTagName(name);
		
			if(l != null)
			{
				Node res = l.item(0).getAttributes().getNamedItem(attribute);
	        	if(res != null)
	        		return res.getNodeValue();	        	
			}
			return "";
		}catch (Exception e) {
			return "";
		}
	}
	
	public String getNodeByXPath(String xPath_expr)
	{
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		
		try {
			XPathExpression xp = xpath.compile(xPath_expr);
			return xp.evaluate(document);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public NodeList getNodeListByXPath(String xPath_expr)
	{
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		
		try {
			XPathExpression xp = xpath.compile(xPath_expr);
			return (NodeList)xp.evaluate(document,XPathConstants.NODESET);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public void printDocument(Node node)
	{
		printDocument(node, 0);
	}
	public void printDocument(Node node, int nivel)
	{
		if (node == null)
            return ;

        int type = node.getNodeType();
        if(type == Node.DOCUMENT_NODE)
        {
        	printDocument(((Document)node).getDocumentElement(),nivel);
        	return;
        }
          
        for(int i=0; i < nivel; i++)
        	System.out.print("\t");
        if(type == Node.TEXT_NODE)
        {
        	System.out.println(node.getNodeValue().trim().replaceAll("\n", ""));
        	return;
        }
       
        
        System.out.print("<"+node.getNodeName());
        NamedNodeMap nnm = node.getAttributes();
        for(int j=0; j< nnm.getLength(); j++)
        {
        	Node attr = nnm.item(j);
        	System.out.print(" "+attr.getNodeName()+"="+attr.getNodeValue());
        }
        System.out.println(">");
        
        String ret = "";
        NodeList children = node.getChildNodes();
		if (children != null) {
            int len = children.getLength();
            for (int i = 0; i < len; i++) 
            {
               Node n = children.item(i);               
               printDocument(n,nivel+1);               
            }
        }
		for(int i=0; i < nivel; i++)
        	System.out.print("\t");
		System.out.println("</"+node.getNodeName()+">");
	}

}
