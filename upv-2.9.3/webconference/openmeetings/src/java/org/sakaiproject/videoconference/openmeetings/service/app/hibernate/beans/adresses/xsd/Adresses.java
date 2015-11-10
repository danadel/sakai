
/**
 * Adresses.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5  Built on : Apr 30, 2009 (06:07:47 EDT)
 */
            
                package org.sakaiproject.videoconference.openmeetings.service.app.hibernate.beans.adresses.xsd;
            

            /**
            *  Adresses bean class
            */
        
        public  class Adresses
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = Adresses
                Namespace URI = http://adresses.beans.hibernate.app.openmeetings.org/xsd
                Namespace Prefix = ns2
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://adresses.beans.hibernate.app.openmeetings.org/xsd")){
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Additionalname
                        */

                        
                                    protected java.lang.String localAdditionalname ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAdditionalnameTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getAdditionalname(){
                               return localAdditionalname;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Additionalname
                               */
                               public void setAdditionalname(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localAdditionalnameTracker = true;
                                       } else {
                                          localAdditionalnameTracker = true;
                                              
                                       }
                                   
                                            this.localAdditionalname=param;
                                    

                               }
                            

                        /**
                        * field for Adresses_id
                        */

                        
                                    protected long localAdresses_id ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAdresses_idTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getAdresses_id(){
                               return localAdresses_id;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Adresses_id
                               */
                               public void setAdresses_id(long param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Long.MIN_VALUE) {
                                           localAdresses_idTracker = true;
                                              
                                       } else {
                                          localAdresses_idTracker = true;
                                       }
                                   
                                            this.localAdresses_id=param;
                                    

                               }
                            

                        /**
                        * field for Comment
                        */

                        
                                    protected java.lang.String localComment ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCommentTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getComment(){
                               return localComment;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Comment
                               */
                               public void setComment(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localCommentTracker = true;
                                       } else {
                                          localCommentTracker = true;
                                              
                                       }
                                   
                                            this.localComment=param;
                                    

                               }
                            

                        /**
                        * field for Deleted
                        */

                        
                                    protected java.lang.String localDeleted ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDeletedTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDeleted(){
                               return localDeleted;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Deleted
                               */
                               public void setDeleted(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localDeletedTracker = true;
                                       } else {
                                          localDeletedTracker = true;
                                              
                                       }
                                   
                                            this.localDeleted=param;
                                    

                               }
                            

                        /**
                        * field for Email
                        */

                        
                                    protected java.lang.String localEmail ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localEmailTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getEmail(){
                               return localEmail;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Email
                               */
                               public void setEmail(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localEmailTracker = true;
                                       } else {
                                          localEmailTracker = true;
                                              
                                       }
                                   
                                            this.localEmail=param;
                                    

                               }
                            

                        /**
                        * field for Fax
                        */

                        
                                    protected java.lang.String localFax ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFaxTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getFax(){
                               return localFax;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Fax
                               */
                               public void setFax(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localFaxTracker = true;
                                       } else {
                                          localFaxTracker = true;
                                              
                                       }
                                   
                                            this.localFax=param;
                                    

                               }
                            

                        /**
                        * field for Phone
                        */

                        
                                    protected java.lang.String localPhone ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPhoneTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPhone(){
                               return localPhone;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Phone
                               */
                               public void setPhone(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localPhoneTracker = true;
                                       } else {
                                          localPhoneTracker = true;
                                              
                                       }
                                   
                                            this.localPhone=param;
                                    

                               }
                            

                        /**
                        * field for Starttime
                        */

                        
                                    protected java.util.Calendar localStarttime ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localStarttimeTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getStarttime(){
                               return localStarttime;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Starttime
                               */
                               public void setStarttime(java.util.Calendar param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localStarttimeTracker = true;
                                       } else {
                                          localStarttimeTracker = true;
                                              
                                       }
                                   
                                            this.localStarttime=param;
                                    

                               }
                            

                        /**
                        * field for States
                        */

                        
                                    protected org.sakaiproject.videoconference.openmeetings.service.app.hibernate.beans.adresses.xsd.States localStates ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localStatesTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return org.sakaiproject.videoconference.openmeetings.service.app.hibernate.beans.adresses.xsd.States
                           */
                           public  org.sakaiproject.videoconference.openmeetings.service.app.hibernate.beans.adresses.xsd.States getStates(){
                               return localStates;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param States
                               */
                               public void setStates(org.sakaiproject.videoconference.openmeetings.service.app.hibernate.beans.adresses.xsd.States param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localStatesTracker = true;
                                       } else {
                                          localStatesTracker = true;
                                              
                                       }
                                   
                                            this.localStates=param;
                                    

                               }
                            

                        /**
                        * field for Street
                        */

                        
                                    protected java.lang.String localStreet ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localStreetTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getStreet(){
                               return localStreet;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Street
                               */
                               public void setStreet(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localStreetTracker = true;
                                       } else {
                                          localStreetTracker = true;
                                              
                                       }
                                   
                                            this.localStreet=param;
                                    

                               }
                            

                        /**
                        * field for Town
                        */

                        
                                    protected java.lang.String localTown ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTownTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getTown(){
                               return localTown;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Town
                               */
                               public void setTown(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localTownTracker = true;
                                       } else {
                                          localTownTracker = true;
                                              
                                       }
                                   
                                            this.localTown=param;
                                    

                               }
                            

                        /**
                        * field for Updatetime
                        */

                        
                                    protected java.util.Calendar localUpdatetime ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localUpdatetimeTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getUpdatetime(){
                               return localUpdatetime;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Updatetime
                               */
                               public void setUpdatetime(java.util.Calendar param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localUpdatetimeTracker = true;
                                       } else {
                                          localUpdatetimeTracker = true;
                                              
                                       }
                                   
                                            this.localUpdatetime=param;
                                    

                               }
                            

                        /**
                        * field for Zip
                        */

                        
                                    protected java.lang.String localZip ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localZipTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getZip(){
                               return localZip;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Zip
                               */
                               public void setZip(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localZipTracker = true;
                                       } else {
                                          localZipTracker = true;
                                              
                                       }
                                   
                                            this.localZip=param;
                                    

                               }
                            

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
               org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,parentQName){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       Adresses.this.serialize(parentQName,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               parentQName,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                


                java.lang.String prefix = null;
                java.lang.String namespace = null;
                

                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://adresses.beans.hibernate.app.openmeetings.org/xsd");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":Adresses",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "Adresses",
                           xmlWriter);
                   }

               
                   }
                if (localAdditionalnameTracker){
                                    namespace = "http://adresses.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"additionalname", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"additionalname");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("additionalname");
                                    }
                                

                                          if (localAdditionalname==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localAdditionalname);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localAdresses_idTracker){
                                    namespace = "http://adresses.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"adresses_id", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"adresses_id");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("adresses_id");
                                    }
                                
                                               if (localAdresses_id==java.lang.Long.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAdresses_id));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCommentTracker){
                                    namespace = "http://adresses.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"comment", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"comment");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("comment");
                                    }
                                

                                          if (localComment==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localComment);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDeletedTracker){
                                    namespace = "http://adresses.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"deleted", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"deleted");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("deleted");
                                    }
                                

                                          if (localDeleted==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDeleted);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localEmailTracker){
                                    namespace = "http://adresses.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"email", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"email");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("email");
                                    }
                                

                                          if (localEmail==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localEmail);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localFaxTracker){
                                    namespace = "http://adresses.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"fax", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"fax");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("fax");
                                    }
                                

                                          if (localFax==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localFax);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPhoneTracker){
                                    namespace = "http://adresses.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"phone", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"phone");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("phone");
                                    }
                                

                                          if (localPhone==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPhone);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localStarttimeTracker){
                                    namespace = "http://adresses.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"starttime", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"starttime");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("starttime");
                                    }
                                

                                          if (localStarttime==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStarttime));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localStatesTracker){
                                    if (localStates==null){

                                            java.lang.String namespace2 = "http://adresses.beans.hibernate.app.openmeetings.org/xsd";

                                        if (! namespace2.equals("")) {
                                            java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                            if (prefix2 == null) {
                                                prefix2 = generatePrefix(namespace2);

                                                xmlWriter.writeStartElement(prefix2,"states", namespace2);
                                                xmlWriter.writeNamespace(prefix2, namespace2);
                                                xmlWriter.setPrefix(prefix2, namespace2);

                                            } else {
                                                xmlWriter.writeStartElement(namespace2,"states");
                                            }

                                        } else {
                                            xmlWriter.writeStartElement("states");
                                        }


                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localStates.serialize(new javax.xml.namespace.QName("http://adresses.beans.hibernate.app.openmeetings.org/xsd","states"),
                                        factory,xmlWriter);
                                    }
                                } if (localStreetTracker){
                                    namespace = "http://adresses.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"street", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"street");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("street");
                                    }
                                

                                          if (localStreet==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localStreet);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localTownTracker){
                                    namespace = "http://adresses.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"town", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"town");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("town");
                                    }
                                

                                          if (localTown==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localTown);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localUpdatetimeTracker){
                                    namespace = "http://adresses.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"updatetime", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"updatetime");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("updatetime");
                                    }
                                

                                          if (localUpdatetime==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localUpdatetime));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localZipTracker){
                                    namespace = "http://adresses.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"zip", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"zip");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("zip");
                                    }
                                

                                          if (localZip==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localZip);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                    xmlWriter.writeEndElement();
               

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (localAdditionalnameTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://adresses.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "additionalname"));
                                 
                                         elementList.add(localAdditionalname==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAdditionalname));
                                    } if (localAdresses_idTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://adresses.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "adresses_id"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAdresses_id));
                            } if (localCommentTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://adresses.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "comment"));
                                 
                                         elementList.add(localComment==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localComment));
                                    } if (localDeletedTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://adresses.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "deleted"));
                                 
                                         elementList.add(localDeleted==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDeleted));
                                    } if (localEmailTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://adresses.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "email"));
                                 
                                         elementList.add(localEmail==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEmail));
                                    } if (localFaxTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://adresses.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "fax"));
                                 
                                         elementList.add(localFax==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFax));
                                    } if (localPhoneTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://adresses.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "phone"));
                                 
                                         elementList.add(localPhone==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPhone));
                                    } if (localStarttimeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://adresses.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "starttime"));
                                 
                                         elementList.add(localStarttime==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStarttime));
                                    } if (localStatesTracker){
                            elementList.add(new javax.xml.namespace.QName("http://adresses.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "states"));
                            
                            
                                    elementList.add(localStates==null?null:
                                    localStates);
                                } if (localStreetTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://adresses.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "street"));
                                 
                                         elementList.add(localStreet==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStreet));
                                    } if (localTownTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://adresses.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "town"));
                                 
                                         elementList.add(localTown==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTown));
                                    } if (localUpdatetimeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://adresses.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "updatetime"));
                                 
                                         elementList.add(localUpdatetime==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localUpdatetime));
                                    } if (localZipTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://adresses.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "zip"));
                                 
                                         elementList.add(localZip==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localZip));
                                    }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
            
            

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static Adresses parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Adresses object =
                new Adresses();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                
                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
                    
                            if (!"Adresses".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (Adresses)org.sakaiproject.videoconference.openmeetings.service.app.data.beans.basic.xsd.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://adresses.beans.hibernate.app.openmeetings.org/xsd","additionalname").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setAdditionalname(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://adresses.beans.hibernate.app.openmeetings.org/xsd","adresses_id").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setAdresses_id(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setAdresses_id(java.lang.Long.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setAdresses_id(java.lang.Long.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://adresses.beans.hibernate.app.openmeetings.org/xsd","comment").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setComment(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://adresses.beans.hibernate.app.openmeetings.org/xsd","deleted").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDeleted(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://adresses.beans.hibernate.app.openmeetings.org/xsd","email").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setEmail(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://adresses.beans.hibernate.app.openmeetings.org/xsd","fax").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFax(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://adresses.beans.hibernate.app.openmeetings.org/xsd","phone").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPhone(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://adresses.beans.hibernate.app.openmeetings.org/xsd","starttime").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setStarttime(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://adresses.beans.hibernate.app.openmeetings.org/xsd","states").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setStates(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setStates(org.sakaiproject.videoconference.openmeetings.service.app.hibernate.beans.adresses.xsd.States.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://adresses.beans.hibernate.app.openmeetings.org/xsd","street").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setStreet(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://adresses.beans.hibernate.app.openmeetings.org/xsd","town").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTown(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://adresses.beans.hibernate.app.openmeetings.org/xsd","updatetime").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setUpdatetime(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://adresses.beans.hibernate.app.openmeetings.org/xsd","zip").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setZip(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                  
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            
                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          