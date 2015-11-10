
/**
 * SendInvitationHashWithDateObject.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5  Built on : Apr 30, 2009 (06:07:47 EDT)
 */
            
                package org.sakaiproject.videoconference.openmeetings.service.axis.services;
            

            /**
            *  SendInvitationHashWithDateObject bean class
            */
        
        public  class SendInvitationHashWithDateObject
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://services.axis.openmeetings.org",
                "sendInvitationHashWithDateObject",
                "ns9");

            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://services.axis.openmeetings.org")){
                return "ns9";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for SID
                        */

                        
                                    protected java.lang.String localSID ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSIDTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSID(){
                               return localSID;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SID
                               */
                               public void setSID(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localSIDTracker = true;
                                       } else {
                                          localSIDTracker = true;
                                              
                                       }
                                   
                                            this.localSID=param;
                                    

                               }
                            

                        /**
                        * field for Username
                        */

                        
                                    protected java.lang.String localUsername ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localUsernameTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getUsername(){
                               return localUsername;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Username
                               */
                               public void setUsername(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localUsernameTracker = true;
                                       } else {
                                          localUsernameTracker = true;
                                              
                                       }
                                   
                                            this.localUsername=param;
                                    

                               }
                            

                        /**
                        * field for Message
                        */

                        
                                    protected java.lang.String localMessage ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMessageTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getMessage(){
                               return localMessage;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Message
                               */
                               public void setMessage(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localMessageTracker = true;
                                       } else {
                                          localMessageTracker = true;
                                              
                                       }
                                   
                                            this.localMessage=param;
                                    

                               }
                            

                        /**
                        * field for Baseurl
                        */

                        
                                    protected java.lang.String localBaseurl ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBaseurlTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getBaseurl(){
                               return localBaseurl;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Baseurl
                               */
                               public void setBaseurl(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localBaseurlTracker = true;
                                       } else {
                                          localBaseurlTracker = true;
                                              
                                       }
                                   
                                            this.localBaseurl=param;
                                    

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
                        * field for Subject
                        */

                        
                                    protected java.lang.String localSubject ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSubjectTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSubject(){
                               return localSubject;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Subject
                               */
                               public void setSubject(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localSubjectTracker = true;
                                       } else {
                                          localSubjectTracker = true;
                                              
                                       }
                                   
                                            this.localSubject=param;
                                    

                               }
                            

                        /**
                        * field for Room_id
                        */

                        
                                    protected long localRoom_id ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRoom_idTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getRoom_id(){
                               return localRoom_id;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Room_id
                               */
                               public void setRoom_id(long param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Long.MIN_VALUE) {
                                           localRoom_idTracker = false;
                                              
                                       } else {
                                          localRoom_idTracker = true;
                                       }
                                   
                                            this.localRoom_id=param;
                                    

                               }
                            

                        /**
                        * field for Conferencedomain
                        */

                        
                                    protected java.lang.String localConferencedomain ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localConferencedomainTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getConferencedomain(){
                               return localConferencedomain;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Conferencedomain
                               */
                               public void setConferencedomain(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localConferencedomainTracker = true;
                                       } else {
                                          localConferencedomainTracker = true;
                                              
                                       }
                                   
                                            this.localConferencedomain=param;
                                    

                               }
                            

                        /**
                        * field for IsPasswordProtected
                        */

                        
                                    protected boolean localIsPasswordProtected ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIsPasswordProtectedTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getIsPasswordProtected(){
                               return localIsPasswordProtected;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsPasswordProtected
                               */
                               public void setIsPasswordProtected(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (false) {
                                           localIsPasswordProtectedTracker = false;
                                              
                                       } else {
                                          localIsPasswordProtectedTracker = true;
                                       }
                                   
                                            this.localIsPasswordProtected=param;
                                    

                               }
                            

                        /**
                        * field for Invitationpass
                        */

                        
                                    protected java.lang.String localInvitationpass ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localInvitationpassTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getInvitationpass(){
                               return localInvitationpass;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Invitationpass
                               */
                               public void setInvitationpass(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localInvitationpassTracker = true;
                                       } else {
                                          localInvitationpassTracker = true;
                                              
                                       }
                                   
                                            this.localInvitationpass=param;
                                    

                               }
                            

                        /**
                        * field for Valid
                        */

                        
                                    protected int localValid ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localValidTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getValid(){
                               return localValid;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Valid
                               */
                               public void setValid(int param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localValidTracker = false;
                                              
                                       } else {
                                          localValidTracker = true;
                                       }
                                   
                                            this.localValid=param;
                                    

                               }
                            

                        /**
                        * field for FromDate
                        */

                        
                                    protected java.util.Calendar localFromDate ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFromDateTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getFromDate(){
                               return localFromDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FromDate
                               */
                               public void setFromDate(java.util.Calendar param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localFromDateTracker = true;
                                       } else {
                                          localFromDateTracker = true;
                                              
                                       }
                                   
                                            this.localFromDate=param;
                                    

                               }
                            

                        /**
                        * field for ToDate
                        */

                        
                                    protected java.util.Calendar localToDate ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localToDateTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getToDate(){
                               return localToDate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ToDate
                               */
                               public void setToDate(java.util.Calendar param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localToDateTracker = true;
                                       } else {
                                          localToDateTracker = true;
                                              
                                       }
                                   
                                            this.localToDate=param;
                                    

                               }
                            

                        /**
                        * field for Language_id
                        */

                        
                                    protected long localLanguage_id ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localLanguage_idTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getLanguage_id(){
                               return localLanguage_id;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Language_id
                               */
                               public void setLanguage_id(long param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Long.MIN_VALUE) {
                                           localLanguage_idTracker = false;
                                              
                                       } else {
                                          localLanguage_idTracker = true;
                                       }
                                   
                                            this.localLanguage_id=param;
                                    

                               }
                            

                        /**
                        * field for SendMail
                        */

                        
                                    protected boolean localSendMail ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSendMailTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getSendMail(){
                               return localSendMail;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SendMail
                               */
                               public void setSendMail(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (false) {
                                           localSendMailTracker = false;
                                              
                                       } else {
                                          localSendMailTracker = true;
                                       }
                                   
                                            this.localSendMail=param;
                                    

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
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       SendInvitationHashWithDateObject.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);
            
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
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://services.axis.openmeetings.org");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":sendInvitationHashWithDateObject",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "sendInvitationHashWithDateObject",
                           xmlWriter);
                   }

               
                   }
                if (localSIDTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"SID", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"SID");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("SID");
                                    }
                                

                                          if (localSID==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSID);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localUsernameTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"username", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"username");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("username");
                                    }
                                

                                          if (localUsername==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localUsername);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localMessageTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"message", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"message");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("message");
                                    }
                                

                                          if (localMessage==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localMessage);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localBaseurlTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"baseurl", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"baseurl");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("baseurl");
                                    }
                                

                                          if (localBaseurl==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localBaseurl);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localEmailTracker){
                                    namespace = "http://services.axis.openmeetings.org";
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
                             } if (localSubjectTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"subject", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"subject");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("subject");
                                    }
                                

                                          if (localSubject==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSubject);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRoom_idTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"room_id", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"room_id");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("room_id");
                                    }
                                
                                               if (localRoom_id==java.lang.Long.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("room_id cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRoom_id));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localConferencedomainTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"conferencedomain", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"conferencedomain");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("conferencedomain");
                                    }
                                

                                          if (localConferencedomain==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localConferencedomain);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIsPasswordProtectedTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"isPasswordProtected", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"isPasswordProtected");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("isPasswordProtected");
                                    }
                                
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("isPasswordProtected cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsPasswordProtected));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localInvitationpassTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"invitationpass", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"invitationpass");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("invitationpass");
                                    }
                                

                                          if (localInvitationpass==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localInvitationpass);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localValidTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"valid", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"valid");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("valid");
                                    }
                                
                                               if (localValid==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("valid cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localValid));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localFromDateTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"fromDate", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"fromDate");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("fromDate");
                                    }
                                

                                          if (localFromDate==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFromDate));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localToDateTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"toDate", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"toDate");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("toDate");
                                    }
                                

                                          if (localToDate==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localToDate));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localLanguage_idTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"language_id", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"language_id");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("language_id");
                                    }
                                
                                               if (localLanguage_id==java.lang.Long.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("language_id cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLanguage_id));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSendMailTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"sendMail", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"sendMail");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("sendMail");
                                    }
                                
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("sendMail cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSendMail));
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

                 if (localSIDTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "SID"));
                                 
                                         elementList.add(localSID==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSID));
                                    } if (localUsernameTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "username"));
                                 
                                         elementList.add(localUsername==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localUsername));
                                    } if (localMessageTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "message"));
                                 
                                         elementList.add(localMessage==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMessage));
                                    } if (localBaseurlTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "baseurl"));
                                 
                                         elementList.add(localBaseurl==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBaseurl));
                                    } if (localEmailTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "email"));
                                 
                                         elementList.add(localEmail==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEmail));
                                    } if (localSubjectTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "subject"));
                                 
                                         elementList.add(localSubject==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSubject));
                                    } if (localRoom_idTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "room_id"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRoom_id));
                            } if (localConferencedomainTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "conferencedomain"));
                                 
                                         elementList.add(localConferencedomain==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localConferencedomain));
                                    } if (localIsPasswordProtectedTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "isPasswordProtected"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsPasswordProtected));
                            } if (localInvitationpassTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "invitationpass"));
                                 
                                         elementList.add(localInvitationpass==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localInvitationpass));
                                    } if (localValidTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "valid"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localValid));
                            } if (localFromDateTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "fromDate"));
                                 
                                         elementList.add(localFromDate==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFromDate));
                                    } if (localToDateTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "toDate"));
                                 
                                         elementList.add(localToDate==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localToDate));
                                    } if (localLanguage_idTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "language_id"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLanguage_id));
                            } if (localSendMailTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "sendMail"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSendMail));
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
        public static SendInvitationHashWithDateObject parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            SendInvitationHashWithDateObject object =
                new SendInvitationHashWithDateObject();

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
                    
                            if (!"sendInvitationHashWithDateObject".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (SendInvitationHashWithDateObject)org.sakaiproject.videoconference.openmeetings.service.app.data.beans.basic.xsd.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","SID").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSID(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","username").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setUsername(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","message").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMessage(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","baseurl").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setBaseurl(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","email").equals(reader.getName())){
                                
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","subject").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSubject(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","room_id").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRoom_id(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setRoom_id(java.lang.Long.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","conferencedomain").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setConferencedomain(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","isPasswordProtected").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsPasswordProtected(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","invitationpass").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setInvitationpass(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","valid").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setValid(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setValid(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","fromDate").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFromDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","toDate").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setToDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","language_id").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLanguage_id(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setLanguage_id(java.lang.Long.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","sendMail").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSendMail(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
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
           
          