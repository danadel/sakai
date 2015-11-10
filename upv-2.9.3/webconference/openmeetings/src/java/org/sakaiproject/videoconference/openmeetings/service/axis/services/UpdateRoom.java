
/**
 * UpdateRoom.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5  Built on : Apr 30, 2009 (06:07:47 EDT)
 */
            
                package org.sakaiproject.videoconference.openmeetings.service.axis.services;
            

            /**
            *  UpdateRoom bean class
            */
        
        public  class UpdateRoom
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://services.axis.openmeetings.org",
                "updateRoom",
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
                        * field for Rooms_id
                        */

                        
                                    protected long localRooms_id ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRooms_idTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getRooms_id(){
                               return localRooms_id;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Rooms_id
                               */
                               public void setRooms_id(long param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Long.MIN_VALUE) {
                                           localRooms_idTracker = false;
                                              
                                       } else {
                                          localRooms_idTracker = true;
                                       }
                                   
                                            this.localRooms_id=param;
                                    

                               }
                            

                        /**
                        * field for Name
                        */

                        
                                    protected java.lang.String localName ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNameTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getName(){
                               return localName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Name
                               */
                               public void setName(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localNameTracker = true;
                                       } else {
                                          localNameTracker = true;
                                              
                                       }
                                   
                                            this.localName=param;
                                    

                               }
                            

                        /**
                        * field for Roomtypes_id
                        */

                        
                                    protected long localRoomtypes_id ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRoomtypes_idTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getRoomtypes_id(){
                               return localRoomtypes_id;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Roomtypes_id
                               */
                               public void setRoomtypes_id(long param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Long.MIN_VALUE) {
                                           localRoomtypes_idTracker = false;
                                              
                                       } else {
                                          localRoomtypes_idTracker = true;
                                       }
                                   
                                            this.localRoomtypes_id=param;
                                    

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
                        * field for NumberOfPartizipants
                        */

                        
                                    protected long localNumberOfPartizipants ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNumberOfPartizipantsTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getNumberOfPartizipants(){
                               return localNumberOfPartizipants;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NumberOfPartizipants
                               */
                               public void setNumberOfPartizipants(long param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Long.MIN_VALUE) {
                                           localNumberOfPartizipantsTracker = false;
                                              
                                       } else {
                                          localNumberOfPartizipantsTracker = true;
                                       }
                                   
                                            this.localNumberOfPartizipants=param;
                                    

                               }
                            

                        /**
                        * field for Ispublic
                        */

                        
                                    protected boolean localIspublic ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIspublicTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getIspublic(){
                               return localIspublic;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Ispublic
                               */
                               public void setIspublic(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (false) {
                                           localIspublicTracker = false;
                                              
                                       } else {
                                          localIspublicTracker = true;
                                       }
                                   
                                            this.localIspublic=param;
                                    

                               }
                            

                        /**
                        * field for VideoPodWidth
                        */

                        
                                    protected int localVideoPodWidth ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localVideoPodWidthTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getVideoPodWidth(){
                               return localVideoPodWidth;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param VideoPodWidth
                               */
                               public void setVideoPodWidth(int param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localVideoPodWidthTracker = false;
                                              
                                       } else {
                                          localVideoPodWidthTracker = true;
                                       }
                                   
                                            this.localVideoPodWidth=param;
                                    

                               }
                            

                        /**
                        * field for VideoPodHeight
                        */

                        
                                    protected int localVideoPodHeight ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localVideoPodHeightTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getVideoPodHeight(){
                               return localVideoPodHeight;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param VideoPodHeight
                               */
                               public void setVideoPodHeight(int param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localVideoPodHeightTracker = false;
                                              
                                       } else {
                                          localVideoPodHeightTracker = true;
                                       }
                                   
                                            this.localVideoPodHeight=param;
                                    

                               }
                            

                        /**
                        * field for VideoPodXPosition
                        */

                        
                                    protected int localVideoPodXPosition ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localVideoPodXPositionTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getVideoPodXPosition(){
                               return localVideoPodXPosition;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param VideoPodXPosition
                               */
                               public void setVideoPodXPosition(int param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localVideoPodXPositionTracker = false;
                                              
                                       } else {
                                          localVideoPodXPositionTracker = true;
                                       }
                                   
                                            this.localVideoPodXPosition=param;
                                    

                               }
                            

                        /**
                        * field for VideoPodYPosition
                        */

                        
                                    protected int localVideoPodYPosition ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localVideoPodYPositionTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getVideoPodYPosition(){
                               return localVideoPodYPosition;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param VideoPodYPosition
                               */
                               public void setVideoPodYPosition(int param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localVideoPodYPositionTracker = false;
                                              
                                       } else {
                                          localVideoPodYPositionTracker = true;
                                       }
                                   
                                            this.localVideoPodYPosition=param;
                                    

                               }
                            

                        /**
                        * field for ModerationPanelXPosition
                        */

                        
                                    protected int localModerationPanelXPosition ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localModerationPanelXPositionTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getModerationPanelXPosition(){
                               return localModerationPanelXPosition;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ModerationPanelXPosition
                               */
                               public void setModerationPanelXPosition(int param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localModerationPanelXPositionTracker = false;
                                              
                                       } else {
                                          localModerationPanelXPositionTracker = true;
                                       }
                                   
                                            this.localModerationPanelXPosition=param;
                                    

                               }
                            

                        /**
                        * field for ShowWhiteBoard
                        */

                        
                                    protected boolean localShowWhiteBoard ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localShowWhiteBoardTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getShowWhiteBoard(){
                               return localShowWhiteBoard;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ShowWhiteBoard
                               */
                               public void setShowWhiteBoard(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (false) {
                                           localShowWhiteBoardTracker = false;
                                              
                                       } else {
                                          localShowWhiteBoardTracker = true;
                                       }
                                   
                                            this.localShowWhiteBoard=param;
                                    

                               }
                            

                        /**
                        * field for WhiteBoardPanelXPosition
                        */

                        
                                    protected int localWhiteBoardPanelXPosition ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localWhiteBoardPanelXPositionTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getWhiteBoardPanelXPosition(){
                               return localWhiteBoardPanelXPosition;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param WhiteBoardPanelXPosition
                               */
                               public void setWhiteBoardPanelXPosition(int param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localWhiteBoardPanelXPositionTracker = false;
                                              
                                       } else {
                                          localWhiteBoardPanelXPositionTracker = true;
                                       }
                                   
                                            this.localWhiteBoardPanelXPosition=param;
                                    

                               }
                            

                        /**
                        * field for WhiteBoardPanelYPosition
                        */

                        
                                    protected int localWhiteBoardPanelYPosition ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localWhiteBoardPanelYPositionTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getWhiteBoardPanelYPosition(){
                               return localWhiteBoardPanelYPosition;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param WhiteBoardPanelYPosition
                               */
                               public void setWhiteBoardPanelYPosition(int param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localWhiteBoardPanelYPositionTracker = false;
                                              
                                       } else {
                                          localWhiteBoardPanelYPositionTracker = true;
                                       }
                                   
                                            this.localWhiteBoardPanelYPosition=param;
                                    

                               }
                            

                        /**
                        * field for WhiteBoardPanelHeight
                        */

                        
                                    protected int localWhiteBoardPanelHeight ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localWhiteBoardPanelHeightTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getWhiteBoardPanelHeight(){
                               return localWhiteBoardPanelHeight;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param WhiteBoardPanelHeight
                               */
                               public void setWhiteBoardPanelHeight(int param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localWhiteBoardPanelHeightTracker = false;
                                              
                                       } else {
                                          localWhiteBoardPanelHeightTracker = true;
                                       }
                                   
                                            this.localWhiteBoardPanelHeight=param;
                                    

                               }
                            

                        /**
                        * field for WhiteBoardPanelWidth
                        */

                        
                                    protected int localWhiteBoardPanelWidth ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localWhiteBoardPanelWidthTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getWhiteBoardPanelWidth(){
                               return localWhiteBoardPanelWidth;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param WhiteBoardPanelWidth
                               */
                               public void setWhiteBoardPanelWidth(int param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localWhiteBoardPanelWidthTracker = false;
                                              
                                       } else {
                                          localWhiteBoardPanelWidthTracker = true;
                                       }
                                   
                                            this.localWhiteBoardPanelWidth=param;
                                    

                               }
                            

                        /**
                        * field for ShowFilesPanel
                        */

                        
                                    protected boolean localShowFilesPanel ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localShowFilesPanelTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getShowFilesPanel(){
                               return localShowFilesPanel;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ShowFilesPanel
                               */
                               public void setShowFilesPanel(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (false) {
                                           localShowFilesPanelTracker = false;
                                              
                                       } else {
                                          localShowFilesPanelTracker = true;
                                       }
                                   
                                            this.localShowFilesPanel=param;
                                    

                               }
                            

                        /**
                        * field for FilesPanelXPosition
                        */

                        
                                    protected int localFilesPanelXPosition ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFilesPanelXPositionTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getFilesPanelXPosition(){
                               return localFilesPanelXPosition;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FilesPanelXPosition
                               */
                               public void setFilesPanelXPosition(int param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localFilesPanelXPositionTracker = false;
                                              
                                       } else {
                                          localFilesPanelXPositionTracker = true;
                                       }
                                   
                                            this.localFilesPanelXPosition=param;
                                    

                               }
                            

                        /**
                        * field for FilesPanelYPosition
                        */

                        
                                    protected int localFilesPanelYPosition ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFilesPanelYPositionTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getFilesPanelYPosition(){
                               return localFilesPanelYPosition;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FilesPanelYPosition
                               */
                               public void setFilesPanelYPosition(int param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localFilesPanelYPositionTracker = false;
                                              
                                       } else {
                                          localFilesPanelYPositionTracker = true;
                                       }
                                   
                                            this.localFilesPanelYPosition=param;
                                    

                               }
                            

                        /**
                        * field for FilesPanelHeight
                        */

                        
                                    protected int localFilesPanelHeight ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFilesPanelHeightTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getFilesPanelHeight(){
                               return localFilesPanelHeight;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FilesPanelHeight
                               */
                               public void setFilesPanelHeight(int param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localFilesPanelHeightTracker = false;
                                              
                                       } else {
                                          localFilesPanelHeightTracker = true;
                                       }
                                   
                                            this.localFilesPanelHeight=param;
                                    

                               }
                            

                        /**
                        * field for FilesPanelWidth
                        */

                        
                                    protected int localFilesPanelWidth ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFilesPanelWidthTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getFilesPanelWidth(){
                               return localFilesPanelWidth;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FilesPanelWidth
                               */
                               public void setFilesPanelWidth(int param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localFilesPanelWidthTracker = false;
                                              
                                       } else {
                                          localFilesPanelWidthTracker = true;
                                       }
                                   
                                            this.localFilesPanelWidth=param;
                                    

                               }
                            

                        /**
                        * field for Appointment
                        */

                        
                                    protected boolean localAppointment ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAppointmentTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getAppointment(){
                               return localAppointment;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Appointment
                               */
                               public void setAppointment(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (false) {
                                           localAppointmentTracker = false;
                                              
                                       } else {
                                          localAppointmentTracker = true;
                                       }
                                   
                                            this.localAppointment=param;
                                    

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
                       UpdateRoom.this.serialize(MY_QNAME,factory,xmlWriter);
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
                           namespacePrefix+":updateRoom",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "updateRoom",
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
                             } if (localRooms_idTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"rooms_id", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"rooms_id");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("rooms_id");
                                    }
                                
                                               if (localRooms_id==java.lang.Long.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("rooms_id cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRooms_id));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localNameTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"name", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"name");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("name");
                                    }
                                

                                          if (localName==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRoomtypes_idTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"roomtypes_id", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"roomtypes_id");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("roomtypes_id");
                                    }
                                
                                               if (localRoomtypes_id==java.lang.Long.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("roomtypes_id cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRoomtypes_id));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCommentTracker){
                                    namespace = "http://services.axis.openmeetings.org";
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
                             } if (localNumberOfPartizipantsTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"numberOfPartizipants", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"numberOfPartizipants");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("numberOfPartizipants");
                                    }
                                
                                               if (localNumberOfPartizipants==java.lang.Long.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("numberOfPartizipants cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNumberOfPartizipants));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIspublicTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"ispublic", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"ispublic");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("ispublic");
                                    }
                                
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("ispublic cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIspublic));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localVideoPodWidthTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"videoPodWidth", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"videoPodWidth");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("videoPodWidth");
                                    }
                                
                                               if (localVideoPodWidth==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("videoPodWidth cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVideoPodWidth));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localVideoPodHeightTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"videoPodHeight", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"videoPodHeight");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("videoPodHeight");
                                    }
                                
                                               if (localVideoPodHeight==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("videoPodHeight cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVideoPodHeight));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localVideoPodXPositionTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"videoPodXPosition", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"videoPodXPosition");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("videoPodXPosition");
                                    }
                                
                                               if (localVideoPodXPosition==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("videoPodXPosition cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVideoPodXPosition));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localVideoPodYPositionTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"videoPodYPosition", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"videoPodYPosition");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("videoPodYPosition");
                                    }
                                
                                               if (localVideoPodYPosition==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("videoPodYPosition cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVideoPodYPosition));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localModerationPanelXPositionTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"moderationPanelXPosition", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"moderationPanelXPosition");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("moderationPanelXPosition");
                                    }
                                
                                               if (localModerationPanelXPosition==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("moderationPanelXPosition cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localModerationPanelXPosition));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localShowWhiteBoardTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"showWhiteBoard", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"showWhiteBoard");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("showWhiteBoard");
                                    }
                                
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("showWhiteBoard cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localShowWhiteBoard));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localWhiteBoardPanelXPositionTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"whiteBoardPanelXPosition", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"whiteBoardPanelXPosition");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("whiteBoardPanelXPosition");
                                    }
                                
                                               if (localWhiteBoardPanelXPosition==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("whiteBoardPanelXPosition cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localWhiteBoardPanelXPosition));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localWhiteBoardPanelYPositionTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"whiteBoardPanelYPosition", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"whiteBoardPanelYPosition");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("whiteBoardPanelYPosition");
                                    }
                                
                                               if (localWhiteBoardPanelYPosition==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("whiteBoardPanelYPosition cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localWhiteBoardPanelYPosition));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localWhiteBoardPanelHeightTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"whiteBoardPanelHeight", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"whiteBoardPanelHeight");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("whiteBoardPanelHeight");
                                    }
                                
                                               if (localWhiteBoardPanelHeight==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("whiteBoardPanelHeight cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localWhiteBoardPanelHeight));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localWhiteBoardPanelWidthTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"whiteBoardPanelWidth", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"whiteBoardPanelWidth");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("whiteBoardPanelWidth");
                                    }
                                
                                               if (localWhiteBoardPanelWidth==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("whiteBoardPanelWidth cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localWhiteBoardPanelWidth));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localShowFilesPanelTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"showFilesPanel", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"showFilesPanel");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("showFilesPanel");
                                    }
                                
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("showFilesPanel cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localShowFilesPanel));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localFilesPanelXPositionTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"filesPanelXPosition", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"filesPanelXPosition");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("filesPanelXPosition");
                                    }
                                
                                               if (localFilesPanelXPosition==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("filesPanelXPosition cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFilesPanelXPosition));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localFilesPanelYPositionTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"filesPanelYPosition", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"filesPanelYPosition");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("filesPanelYPosition");
                                    }
                                
                                               if (localFilesPanelYPosition==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("filesPanelYPosition cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFilesPanelYPosition));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localFilesPanelHeightTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"filesPanelHeight", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"filesPanelHeight");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("filesPanelHeight");
                                    }
                                
                                               if (localFilesPanelHeight==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("filesPanelHeight cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFilesPanelHeight));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localFilesPanelWidthTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"filesPanelWidth", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"filesPanelWidth");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("filesPanelWidth");
                                    }
                                
                                               if (localFilesPanelWidth==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("filesPanelWidth cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFilesPanelWidth));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localAppointmentTracker){
                                    namespace = "http://services.axis.openmeetings.org";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"appointment", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"appointment");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("appointment");
                                    }
                                
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("appointment cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAppointment));
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
                                    } if (localRooms_idTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "rooms_id"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRooms_id));
                            } if (localNameTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "name"));
                                 
                                         elementList.add(localName==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localName));
                                    } if (localRoomtypes_idTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "roomtypes_id"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRoomtypes_id));
                            } if (localCommentTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "comment"));
                                 
                                         elementList.add(localComment==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localComment));
                                    } if (localNumberOfPartizipantsTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "numberOfPartizipants"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNumberOfPartizipants));
                            } if (localIspublicTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "ispublic"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIspublic));
                            } if (localVideoPodWidthTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "videoPodWidth"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVideoPodWidth));
                            } if (localVideoPodHeightTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "videoPodHeight"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVideoPodHeight));
                            } if (localVideoPodXPositionTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "videoPodXPosition"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVideoPodXPosition));
                            } if (localVideoPodYPositionTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "videoPodYPosition"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVideoPodYPosition));
                            } if (localModerationPanelXPositionTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "moderationPanelXPosition"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localModerationPanelXPosition));
                            } if (localShowWhiteBoardTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "showWhiteBoard"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localShowWhiteBoard));
                            } if (localWhiteBoardPanelXPositionTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "whiteBoardPanelXPosition"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localWhiteBoardPanelXPosition));
                            } if (localWhiteBoardPanelYPositionTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "whiteBoardPanelYPosition"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localWhiteBoardPanelYPosition));
                            } if (localWhiteBoardPanelHeightTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "whiteBoardPanelHeight"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localWhiteBoardPanelHeight));
                            } if (localWhiteBoardPanelWidthTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "whiteBoardPanelWidth"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localWhiteBoardPanelWidth));
                            } if (localShowFilesPanelTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "showFilesPanel"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localShowFilesPanel));
                            } if (localFilesPanelXPositionTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "filesPanelXPosition"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFilesPanelXPosition));
                            } if (localFilesPanelYPositionTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "filesPanelYPosition"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFilesPanelYPosition));
                            } if (localFilesPanelHeightTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "filesPanelHeight"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFilesPanelHeight));
                            } if (localFilesPanelWidthTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "filesPanelWidth"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFilesPanelWidth));
                            } if (localAppointmentTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://services.axis.openmeetings.org",
                                                                      "appointment"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAppointment));
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
        public static UpdateRoom parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            UpdateRoom object =
                new UpdateRoom();

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
                    
                            if (!"updateRoom".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (UpdateRoom)org.sakaiproject.videoconference.openmeetings.service.app.data.beans.basic.xsd.ExtensionMapper.getTypeObject(
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","rooms_id").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRooms_id(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setRooms_id(java.lang.Long.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","name").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","roomtypes_id").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRoomtypes_id(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setRoomtypes_id(java.lang.Long.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","comment").equals(reader.getName())){
                                
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","numberOfPartizipants").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setNumberOfPartizipants(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setNumberOfPartizipants(java.lang.Long.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","ispublic").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIspublic(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","videoPodWidth").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setVideoPodWidth(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setVideoPodWidth(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","videoPodHeight").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setVideoPodHeight(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setVideoPodHeight(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","videoPodXPosition").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setVideoPodXPosition(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setVideoPodXPosition(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","videoPodYPosition").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setVideoPodYPosition(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setVideoPodYPosition(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","moderationPanelXPosition").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setModerationPanelXPosition(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setModerationPanelXPosition(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","showWhiteBoard").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setShowWhiteBoard(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","whiteBoardPanelXPosition").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setWhiteBoardPanelXPosition(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setWhiteBoardPanelXPosition(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","whiteBoardPanelYPosition").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setWhiteBoardPanelYPosition(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setWhiteBoardPanelYPosition(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","whiteBoardPanelHeight").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setWhiteBoardPanelHeight(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setWhiteBoardPanelHeight(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","whiteBoardPanelWidth").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setWhiteBoardPanelWidth(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setWhiteBoardPanelWidth(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","showFilesPanel").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setShowFilesPanel(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","filesPanelXPosition").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFilesPanelXPosition(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setFilesPanelXPosition(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","filesPanelYPosition").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFilesPanelYPosition(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setFilesPanelYPosition(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","filesPanelHeight").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFilesPanelHeight(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setFilesPanelHeight(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","filesPanelWidth").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFilesPanelWidth(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setFilesPanelWidth(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://services.axis.openmeetings.org","appointment").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setAppointment(
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
           
          