
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5  Built on : Apr 30, 2009 (06:07:47 EDT)
 */

            package org.sakaiproject.videoconference.openmeetings.service.app.hibernate.beans.basic.xsd;
            /**
            *  ExtensionMapper class
            */
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://basic.beans.data.app.openmeetings.org/xsd".equals(namespaceURI) &&
                  "ErrorResult".equals(typeName)){
                   
                            return  org.sakaiproject.videoconference.openmeetings.service.app.data.beans.basic.xsd.ErrorResult.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://basic.beans.data.app.openmeetings.org/xsd".equals(namespaceURI) &&
                  "SearchResult".equals(typeName)){
                   
                            return  org.sakaiproject.videoconference.openmeetings.service.app.data.beans.basic.xsd.SearchResult.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://basic.beans.hibernate.app.openmeetings.org/xsd".equals(namespaceURI) &&
                  "Sessiondata".equals(typeName)){
                   
                            return  org.sakaiproject.videoconference.openmeetings.service.app.hibernate.beans.basic.xsd.Sessiondata.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    