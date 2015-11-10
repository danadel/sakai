
/**
 * FlvRecording.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5  Built on : Apr 30, 2009 (06:07:47 EDT)
 */
            
                package org.sakaiproject.videoconference.openmeetings.service.app.hibernate.beans.flvrecord.xsd;
            

            /**
            *  FlvRecording bean class
            */
        
        public  class FlvRecording
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = FlvRecording
                Namespace URI = http://flvrecord.beans.hibernate.app.openmeetings.org/xsd
                Namespace Prefix = ns7
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd")){
                return "ns7";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for AlternateDownload
                        */

                        
                                    protected java.lang.String localAlternateDownload ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAlternateDownloadTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getAlternateDownload(){
                               return localAlternateDownload;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AlternateDownload
                               */
                               public void setAlternateDownload(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localAlternateDownloadTracker = true;
                                       } else {
                                          localAlternateDownloadTracker = true;
                                              
                                       }
                                   
                                            this.localAlternateDownload=param;
                                    

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
                        * field for Creator
                        */

                        
                                    protected org.sakaiproject.videoconference.openmeetings.service.app.hibernate.beans.user.xsd.Users localCreator ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCreatorTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return org.sakaiproject.videoconference.openmeetings.service.app.hibernate.beans.user.xsd.Users
                           */
                           public  org.sakaiproject.videoconference.openmeetings.service.app.hibernate.beans.user.xsd.Users getCreator(){
                               return localCreator;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Creator
                               */
                               public void setCreator(org.sakaiproject.videoconference.openmeetings.service.app.hibernate.beans.user.xsd.Users param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localCreatorTracker = true;
                                       } else {
                                          localCreatorTracker = true;
                                              
                                       }
                                   
                                            this.localCreator=param;
                                    

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
                        * field for FileHash
                        */

                        
                                    protected java.lang.String localFileHash ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFileHashTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getFileHash(){
                               return localFileHash;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FileHash
                               */
                               public void setFileHash(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localFileHashTracker = true;
                                       } else {
                                          localFileHashTracker = true;
                                              
                                       }
                                   
                                            this.localFileHash=param;
                                    

                               }
                            

                        /**
                        * field for FileName
                        */

                        
                                    protected java.lang.String localFileName ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFileNameTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getFileName(){
                               return localFileName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FileName
                               */
                               public void setFileName(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localFileNameTracker = true;
                                       } else {
                                          localFileNameTracker = true;
                                              
                                       }
                                   
                                            this.localFileName=param;
                                    

                               }
                            

                        /**
                        * field for FileSize
                        */

                        
                                    protected long localFileSize ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFileSizeTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getFileSize(){
                               return localFileSize;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FileSize
                               */
                               public void setFileSize(long param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Long.MIN_VALUE) {
                                           localFileSizeTracker = true;
                                              
                                       } else {
                                          localFileSizeTracker = true;
                                       }
                                   
                                            this.localFileSize=param;
                                    

                               }
                            

                        /**
                        * field for FlvHeight
                        */

                        
                                    protected int localFlvHeight ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFlvHeightTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getFlvHeight(){
                               return localFlvHeight;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FlvHeight
                               */
                               public void setFlvHeight(int param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localFlvHeightTracker = true;
                                              
                                       } else {
                                          localFlvHeightTracker = true;
                                       }
                                   
                                            this.localFlvHeight=param;
                                    

                               }
                            

                        /**
                        * field for FlvRecordingId
                        */

                        
                                    protected long localFlvRecordingId ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFlvRecordingIdTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getFlvRecordingId(){
                               return localFlvRecordingId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FlvRecordingId
                               */
                               public void setFlvRecordingId(long param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Long.MIN_VALUE) {
                                           localFlvRecordingIdTracker = false;
                                              
                                       } else {
                                          localFlvRecordingIdTracker = true;
                                       }
                                   
                                            this.localFlvRecordingId=param;
                                    

                               }
                            

                        /**
                        * field for FlvRecordingLog
                        */

                        
                                    protected org.apache.axiom.om.OMElement localFlvRecordingLog ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFlvRecordingLogTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return org.apache.axiom.om.OMElement
                           */
                           public  org.apache.axiom.om.OMElement getFlvRecordingLog(){
                               return localFlvRecordingLog;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FlvRecordingLog
                               */
                               public void setFlvRecordingLog(org.apache.axiom.om.OMElement param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localFlvRecordingLogTracker = true;
                                       } else {
                                          localFlvRecordingLogTracker = true;
                                              
                                       }
                                   
                                            this.localFlvRecordingLog=param;
                                    

                               }
                            

                        /**
                        * field for FlvRecordingMetaData
                        */

                        
                                    protected org.apache.axiom.om.OMElement localFlvRecordingMetaData ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFlvRecordingMetaDataTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return org.apache.axiom.om.OMElement
                           */
                           public  org.apache.axiom.om.OMElement getFlvRecordingMetaData(){
                               return localFlvRecordingMetaData;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FlvRecordingMetaData
                               */
                               public void setFlvRecordingMetaData(org.apache.axiom.om.OMElement param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localFlvRecordingMetaDataTracker = true;
                                       } else {
                                          localFlvRecordingMetaDataTracker = true;
                                              
                                       }
                                   
                                            this.localFlvRecordingMetaData=param;
                                    

                               }
                            

                        /**
                        * field for FlvWidth
                        */

                        
                                    protected int localFlvWidth ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFlvWidthTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getFlvWidth(){
                               return localFlvWidth;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FlvWidth
                               */
                               public void setFlvWidth(int param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localFlvWidthTracker = true;
                                              
                                       } else {
                                          localFlvWidthTracker = true;
                                       }
                                   
                                            this.localFlvWidth=param;
                                    

                               }
                            

                        /**
                        * field for Height
                        */

                        
                                    protected int localHeight ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localHeightTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getHeight(){
                               return localHeight;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Height
                               */
                               public void setHeight(int param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localHeightTracker = true;
                                              
                                       } else {
                                          localHeightTracker = true;
                                       }
                                   
                                            this.localHeight=param;
                                    

                               }
                            

                        /**
                        * field for Inserted
                        */

                        
                                    protected java.util.Calendar localInserted ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localInsertedTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getInserted(){
                               return localInserted;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Inserted
                               */
                               public void setInserted(java.util.Calendar param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localInsertedTracker = true;
                                       } else {
                                          localInsertedTracker = true;
                                              
                                       }
                                   
                                            this.localInserted=param;
                                    

                               }
                            

                        /**
                        * field for InsertedBy
                        */

                        
                                    protected long localInsertedBy ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localInsertedByTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getInsertedBy(){
                               return localInsertedBy;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param InsertedBy
                               */
                               public void setInsertedBy(long param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Long.MIN_VALUE) {
                                           localInsertedByTracker = true;
                                              
                                       } else {
                                          localInsertedByTracker = true;
                                       }
                                   
                                            this.localInsertedBy=param;
                                    

                               }
                            

                        /**
                        * field for IsFolder
                        */

                        
                                    protected boolean localIsFolder ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIsFolderTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getIsFolder(){
                               return localIsFolder;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsFolder
                               */
                               public void setIsFolder(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (false) {
                                           localIsFolderTracker = true;
                                              
                                       } else {
                                          localIsFolderTracker = true;
                                       }
                                   
                                            this.localIsFolder=param;
                                    

                               }
                            

                        /**
                        * field for IsImage
                        */

                        
                                    protected boolean localIsImage ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIsImageTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getIsImage(){
                               return localIsImage;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsImage
                               */
                               public void setIsImage(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (false) {
                                           localIsImageTracker = true;
                                              
                                       } else {
                                          localIsImageTracker = true;
                                       }
                                   
                                            this.localIsImage=param;
                                    

                               }
                            

                        /**
                        * field for IsInterview
                        */

                        
                                    protected boolean localIsInterview ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIsInterviewTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getIsInterview(){
                               return localIsInterview;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsInterview
                               */
                               public void setIsInterview(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (false) {
                                           localIsInterviewTracker = true;
                                              
                                       } else {
                                          localIsInterviewTracker = true;
                                       }
                                   
                                            this.localIsInterview=param;
                                    

                               }
                            

                        /**
                        * field for IsPresentation
                        */

                        
                                    protected boolean localIsPresentation ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIsPresentationTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getIsPresentation(){
                               return localIsPresentation;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsPresentation
                               */
                               public void setIsPresentation(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (false) {
                                           localIsPresentationTracker = true;
                                              
                                       } else {
                                          localIsPresentationTracker = true;
                                       }
                                   
                                            this.localIsPresentation=param;
                                    

                               }
                            

                        /**
                        * field for IsRecording
                        */

                        
                                    protected boolean localIsRecording ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIsRecordingTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getIsRecording(){
                               return localIsRecording;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsRecording
                               */
                               public void setIsRecording(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (false) {
                                           localIsRecordingTracker = true;
                                              
                                       } else {
                                          localIsRecordingTracker = true;
                                       }
                                   
                                            this.localIsRecording=param;
                                    

                               }
                            

                        /**
                        * field for Organization_id
                        */

                        
                                    protected long localOrganization_id ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOrganization_idTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getOrganization_id(){
                               return localOrganization_id;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Organization_id
                               */
                               public void setOrganization_id(long param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Long.MIN_VALUE) {
                                           localOrganization_idTracker = true;
                                              
                                       } else {
                                          localOrganization_idTracker = true;
                                       }
                                   
                                            this.localOrganization_id=param;
                                    

                               }
                            

                        /**
                        * field for OwnerId
                        */

                        
                                    protected long localOwnerId ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOwnerIdTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getOwnerId(){
                               return localOwnerId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OwnerId
                               */
                               public void setOwnerId(long param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Long.MIN_VALUE) {
                                           localOwnerIdTracker = true;
                                              
                                       } else {
                                          localOwnerIdTracker = true;
                                       }
                                   
                                            this.localOwnerId=param;
                                    

                               }
                            

                        /**
                        * field for ParentFileExplorerItemId
                        */

                        
                                    protected long localParentFileExplorerItemId ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localParentFileExplorerItemIdTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getParentFileExplorerItemId(){
                               return localParentFileExplorerItemId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ParentFileExplorerItemId
                               */
                               public void setParentFileExplorerItemId(long param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Long.MIN_VALUE) {
                                           localParentFileExplorerItemIdTracker = true;
                                              
                                       } else {
                                          localParentFileExplorerItemIdTracker = true;
                                       }
                                   
                                            this.localParentFileExplorerItemId=param;
                                    

                               }
                            

                        /**
                        * field for PreviewImage
                        */

                        
                                    protected java.lang.String localPreviewImage ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPreviewImageTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPreviewImage(){
                               return localPreviewImage;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PreviewImage
                               */
                               public void setPreviewImage(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localPreviewImageTracker = true;
                                       } else {
                                          localPreviewImageTracker = true;
                                              
                                       }
                                   
                                            this.localPreviewImage=param;
                                    

                               }
                            

                        /**
                        * field for ProgressPostProcessing
                        */

                        
                                    protected int localProgressPostProcessing ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localProgressPostProcessingTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getProgressPostProcessing(){
                               return localProgressPostProcessing;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ProgressPostProcessing
                               */
                               public void setProgressPostProcessing(int param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localProgressPostProcessingTracker = true;
                                              
                                       } else {
                                          localProgressPostProcessingTracker = true;
                                       }
                                   
                                            this.localProgressPostProcessing=param;
                                    

                               }
                            

                        /**
                        * field for RecordEnd
                        */

                        
                                    protected java.util.Calendar localRecordEnd ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRecordEndTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getRecordEnd(){
                               return localRecordEnd;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RecordEnd
                               */
                               public void setRecordEnd(java.util.Calendar param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localRecordEndTracker = true;
                                       } else {
                                          localRecordEndTracker = true;
                                              
                                       }
                                   
                                            this.localRecordEnd=param;
                                    

                               }
                            

                        /**
                        * field for RecordStart
                        */

                        
                                    protected java.util.Calendar localRecordStart ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRecordStartTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getRecordStart(){
                               return localRecordStart;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RecordStart
                               */
                               public void setRecordStart(java.util.Calendar param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localRecordStartTracker = true;
                                       } else {
                                          localRecordStartTracker = true;
                                              
                                       }
                                   
                                            this.localRecordStart=param;
                                    

                               }
                            

                        /**
                        * field for RecorderStreamId
                        */

                        
                                    protected java.lang.String localRecorderStreamId ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRecorderStreamIdTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getRecorderStreamId(){
                               return localRecorderStreamId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RecorderStreamId
                               */
                               public void setRecorderStreamId(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localRecorderStreamIdTracker = true;
                                       } else {
                                          localRecorderStreamIdTracker = true;
                                              
                                       }
                                   
                                            this.localRecorderStreamId=param;
                                    

                               }
                            

                        /**
                        * field for Room
                        */

                        
                                    protected org.sakaiproject.videoconference.openmeetings.service.app.hibernate.beans.rooms.xsd.Rooms localRoom ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRoomTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return org.sakaiproject.videoconference.openmeetings.service.app.hibernate.beans.rooms.xsd.Rooms
                           */
                           public  org.sakaiproject.videoconference.openmeetings.service.app.hibernate.beans.rooms.xsd.Rooms getRoom(){
                               return localRoom;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Room
                               */
                               public void setRoom(org.sakaiproject.videoconference.openmeetings.service.app.hibernate.beans.rooms.xsd.Rooms param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localRoomTracker = true;
                                       } else {
                                          localRoomTracker = true;
                                              
                                       }
                                   
                                            this.localRoom=param;
                                    

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
                                           localRoom_idTracker = true;
                                              
                                       } else {
                                          localRoom_idTracker = true;
                                       }
                                   
                                            this.localRoom_id=param;
                                    

                               }
                            

                        /**
                        * field for Updated
                        */

                        
                                    protected java.util.Calendar localUpdated ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localUpdatedTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getUpdated(){
                               return localUpdated;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Updated
                               */
                               public void setUpdated(java.util.Calendar param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localUpdatedTracker = true;
                                       } else {
                                          localUpdatedTracker = true;
                                              
                                       }
                                   
                                            this.localUpdated=param;
                                    

                               }
                            

                        /**
                        * field for Width
                        */

                        
                                    protected int localWidth ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localWidthTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getWidth(){
                               return localWidth;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Width
                               */
                               public void setWidth(int param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localWidthTracker = true;
                                              
                                       } else {
                                          localWidthTracker = true;
                                       }
                                   
                                            this.localWidth=param;
                                    

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
                       FlvRecording.this.serialize(parentQName,factory,xmlWriter);
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
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://flvrecord.beans.hibernate.app.openmeetings.org/xsd");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":FlvRecording",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "FlvRecording",
                           xmlWriter);
                   }

               
                   }
                if (localAlternateDownloadTracker){
                                    namespace = "http://flvrecord.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"alternateDownload", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"alternateDownload");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("alternateDownload");
                                    }
                                

                                          if (localAlternateDownload==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localAlternateDownload);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCommentTracker){
                                    namespace = "http://flvrecord.beans.hibernate.app.openmeetings.org/xsd";
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
                             } if (localCreatorTracker){
                                    if (localCreator==null){

                                            java.lang.String namespace2 = "http://flvrecord.beans.hibernate.app.openmeetings.org/xsd";

                                        if (! namespace2.equals("")) {
                                            java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                            if (prefix2 == null) {
                                                prefix2 = generatePrefix(namespace2);

                                                xmlWriter.writeStartElement(prefix2,"creator", namespace2);
                                                xmlWriter.writeNamespace(prefix2, namespace2);
                                                xmlWriter.setPrefix(prefix2, namespace2);

                                            } else {
                                                xmlWriter.writeStartElement(namespace2,"creator");
                                            }

                                        } else {
                                            xmlWriter.writeStartElement("creator");
                                        }


                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localCreator.serialize(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","creator"),
                                        factory,xmlWriter);
                                    }
                                } if (localDeletedTracker){
                                    namespace = "http://flvrecord.beans.hibernate.app.openmeetings.org/xsd";
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
                             } if (localFileHashTracker){
                                    namespace = "http://flvrecord.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"fileHash", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"fileHash");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("fileHash");
                                    }
                                

                                          if (localFileHash==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localFileHash);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localFileNameTracker){
                                    namespace = "http://flvrecord.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"fileName", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"fileName");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("fileName");
                                    }
                                

                                          if (localFileName==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localFileName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localFileSizeTracker){
                                    namespace = "http://flvrecord.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"fileSize", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"fileSize");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("fileSize");
                                    }
                                
                                               if (localFileSize==java.lang.Long.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFileSize));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localFlvHeightTracker){
                                    namespace = "http://flvrecord.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"flvHeight", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"flvHeight");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("flvHeight");
                                    }
                                
                                               if (localFlvHeight==java.lang.Integer.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFlvHeight));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localFlvRecordingIdTracker){
                                    namespace = "http://flvrecord.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"flvRecordingId", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"flvRecordingId");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("flvRecordingId");
                                    }
                                
                                               if (localFlvRecordingId==java.lang.Long.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("flvRecordingId cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFlvRecordingId));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localFlvRecordingLogTracker){
                                    namespace = "http://flvrecord.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"flvRecordingLog", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"flvRecordingLog");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("flvRecordingLog");
                                    }
                                

                                          if (localFlvRecordingLog==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        localFlvRecordingLog.serialize(xmlWriter);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localFlvRecordingMetaDataTracker){
                                    namespace = "http://flvrecord.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"flvRecordingMetaData", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"flvRecordingMetaData");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("flvRecordingMetaData");
                                    }
                                

                                          if (localFlvRecordingMetaData==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        localFlvRecordingMetaData.serialize(xmlWriter);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localFlvWidthTracker){
                                    namespace = "http://flvrecord.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"flvWidth", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"flvWidth");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("flvWidth");
                                    }
                                
                                               if (localFlvWidth==java.lang.Integer.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFlvWidth));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localHeightTracker){
                                    namespace = "http://flvrecord.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"height", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"height");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("height");
                                    }
                                
                                               if (localHeight==java.lang.Integer.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localHeight));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localInsertedTracker){
                                    namespace = "http://flvrecord.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"inserted", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"inserted");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("inserted");
                                    }
                                

                                          if (localInserted==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localInserted));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localInsertedByTracker){
                                    namespace = "http://flvrecord.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"insertedBy", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"insertedBy");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("insertedBy");
                                    }
                                
                                               if (localInsertedBy==java.lang.Long.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localInsertedBy));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIsFolderTracker){
                                    namespace = "http://flvrecord.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"isFolder", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"isFolder");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("isFolder");
                                    }
                                
                                               if (false) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsFolder));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIsImageTracker){
                                    namespace = "http://flvrecord.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"isImage", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"isImage");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("isImage");
                                    }
                                
                                               if (false) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsImage));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIsInterviewTracker){
                                    namespace = "http://flvrecord.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"isInterview", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"isInterview");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("isInterview");
                                    }
                                
                                               if (false) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsInterview));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIsPresentationTracker){
                                    namespace = "http://flvrecord.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"isPresentation", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"isPresentation");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("isPresentation");
                                    }
                                
                                               if (false) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsPresentation));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIsRecordingTracker){
                                    namespace = "http://flvrecord.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"isRecording", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"isRecording");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("isRecording");
                                    }
                                
                                               if (false) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsRecording));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localOrganization_idTracker){
                                    namespace = "http://flvrecord.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"organization_id", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"organization_id");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("organization_id");
                                    }
                                
                                               if (localOrganization_id==java.lang.Long.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOrganization_id));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localOwnerIdTracker){
                                    namespace = "http://flvrecord.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"ownerId", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"ownerId");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("ownerId");
                                    }
                                
                                               if (localOwnerId==java.lang.Long.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOwnerId));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localParentFileExplorerItemIdTracker){
                                    namespace = "http://flvrecord.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"parentFileExplorerItemId", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"parentFileExplorerItemId");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("parentFileExplorerItemId");
                                    }
                                
                                               if (localParentFileExplorerItemId==java.lang.Long.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localParentFileExplorerItemId));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPreviewImageTracker){
                                    namespace = "http://flvrecord.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"previewImage", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"previewImage");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("previewImage");
                                    }
                                

                                          if (localPreviewImage==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPreviewImage);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localProgressPostProcessingTracker){
                                    namespace = "http://flvrecord.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"progressPostProcessing", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"progressPostProcessing");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("progressPostProcessing");
                                    }
                                
                                               if (localProgressPostProcessing==java.lang.Integer.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localProgressPostProcessing));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRecordEndTracker){
                                    namespace = "http://flvrecord.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"recordEnd", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"recordEnd");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("recordEnd");
                                    }
                                

                                          if (localRecordEnd==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRecordEnd));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRecordStartTracker){
                                    namespace = "http://flvrecord.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"recordStart", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"recordStart");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("recordStart");
                                    }
                                

                                          if (localRecordStart==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRecordStart));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRecorderStreamIdTracker){
                                    namespace = "http://flvrecord.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"recorderStreamId", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"recorderStreamId");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("recorderStreamId");
                                    }
                                

                                          if (localRecorderStreamId==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localRecorderStreamId);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRoomTracker){
                                    if (localRoom==null){

                                            java.lang.String namespace2 = "http://flvrecord.beans.hibernate.app.openmeetings.org/xsd";

                                        if (! namespace2.equals("")) {
                                            java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                            if (prefix2 == null) {
                                                prefix2 = generatePrefix(namespace2);

                                                xmlWriter.writeStartElement(prefix2,"room", namespace2);
                                                xmlWriter.writeNamespace(prefix2, namespace2);
                                                xmlWriter.setPrefix(prefix2, namespace2);

                                            } else {
                                                xmlWriter.writeStartElement(namespace2,"room");
                                            }

                                        } else {
                                            xmlWriter.writeStartElement("room");
                                        }


                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localRoom.serialize(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","room"),
                                        factory,xmlWriter);
                                    }
                                } if (localRoom_idTracker){
                                    namespace = "http://flvrecord.beans.hibernate.app.openmeetings.org/xsd";
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
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRoom_id));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localUpdatedTracker){
                                    namespace = "http://flvrecord.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"updated", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"updated");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("updated");
                                    }
                                

                                          if (localUpdated==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localUpdated));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localWidthTracker){
                                    namespace = "http://flvrecord.beans.hibernate.app.openmeetings.org/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"width", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"width");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("width");
                                    }
                                
                                               if (localWidth==java.lang.Integer.MIN_VALUE) {
                                           
                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localWidth));
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

                 if (localAlternateDownloadTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "alternateDownload"));
                                 
                                         elementList.add(localAlternateDownload==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAlternateDownload));
                                    } if (localCommentTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "comment"));
                                 
                                         elementList.add(localComment==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localComment));
                                    } if (localCreatorTracker){
                            elementList.add(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "creator"));
                            
                            
                                    elementList.add(localCreator==null?null:
                                    localCreator);
                                } if (localDeletedTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "deleted"));
                                 
                                         elementList.add(localDeleted==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDeleted));
                                    } if (localFileHashTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "fileHash"));
                                 
                                         elementList.add(localFileHash==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFileHash));
                                    } if (localFileNameTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "fileName"));
                                 
                                         elementList.add(localFileName==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFileName));
                                    } if (localFileSizeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "fileSize"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFileSize));
                            } if (localFlvHeightTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "flvHeight"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFlvHeight));
                            } if (localFlvRecordingIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "flvRecordingId"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFlvRecordingId));
                            } if (localFlvRecordingLogTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "flvRecordingLog"));
                                 
                                         elementList.add(localFlvRecordingLog==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFlvRecordingLog));
                                    } if (localFlvRecordingMetaDataTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "flvRecordingMetaData"));
                                 
                                         elementList.add(localFlvRecordingMetaData==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFlvRecordingMetaData));
                                    } if (localFlvWidthTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "flvWidth"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFlvWidth));
                            } if (localHeightTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "height"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localHeight));
                            } if (localInsertedTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "inserted"));
                                 
                                         elementList.add(localInserted==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localInserted));
                                    } if (localInsertedByTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "insertedBy"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localInsertedBy));
                            } if (localIsFolderTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "isFolder"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsFolder));
                            } if (localIsImageTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "isImage"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsImage));
                            } if (localIsInterviewTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "isInterview"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsInterview));
                            } if (localIsPresentationTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "isPresentation"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsPresentation));
                            } if (localIsRecordingTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "isRecording"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsRecording));
                            } if (localOrganization_idTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "organization_id"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOrganization_id));
                            } if (localOwnerIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "ownerId"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOwnerId));
                            } if (localParentFileExplorerItemIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "parentFileExplorerItemId"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localParentFileExplorerItemId));
                            } if (localPreviewImageTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "previewImage"));
                                 
                                         elementList.add(localPreviewImage==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPreviewImage));
                                    } if (localProgressPostProcessingTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "progressPostProcessing"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localProgressPostProcessing));
                            } if (localRecordEndTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "recordEnd"));
                                 
                                         elementList.add(localRecordEnd==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRecordEnd));
                                    } if (localRecordStartTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "recordStart"));
                                 
                                         elementList.add(localRecordStart==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRecordStart));
                                    } if (localRecorderStreamIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "recorderStreamId"));
                                 
                                         elementList.add(localRecorderStreamId==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRecorderStreamId));
                                    } if (localRoomTracker){
                            elementList.add(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "room"));
                            
                            
                                    elementList.add(localRoom==null?null:
                                    localRoom);
                                } if (localRoom_idTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "room_id"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRoom_id));
                            } if (localUpdatedTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "updated"));
                                 
                                         elementList.add(localUpdated==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localUpdated));
                                    } if (localWidthTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd",
                                                                      "width"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localWidth));
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
        public static FlvRecording parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            FlvRecording object =
                new FlvRecording();

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
                    
                            if (!"FlvRecording".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (FlvRecording)org.sakaiproject.videoconference.openmeetings.service.app.data.beans.basic.xsd.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","alternateDownload").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setAlternateDownload(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","comment").equals(reader.getName())){
                                
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","creator").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setCreator(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setCreator(org.sakaiproject.videoconference.openmeetings.service.app.hibernate.beans.user.xsd.Users.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","deleted").equals(reader.getName())){
                                
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","fileHash").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFileHash(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","fileName").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFileName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","fileSize").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFileSize(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setFileSize(java.lang.Long.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setFileSize(java.lang.Long.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","flvHeight").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFlvHeight(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setFlvHeight(java.lang.Integer.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setFlvHeight(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","flvRecordingId").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFlvRecordingId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setFlvRecordingId(java.lang.Long.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","flvRecordingLog").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                                org.apache.axiom.om.OMFactory fac = org.apache.axiom.om.OMAbstractFactory.getOMFactory();
                                                org.apache.axiom.om.OMNamespace omNs = fac.createOMNamespace("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd", "");
                                                org.apache.axiom.om.OMElement _valueFlvRecordingLog = fac.createOMElement("flvRecordingLog", omNs);
                                                _valueFlvRecordingLog.addChild(fac.createOMText(_valueFlvRecordingLog, content));
                                                object.setFlvRecordingLog(_valueFlvRecordingLog);
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","flvRecordingMetaData").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                                org.apache.axiom.om.OMFactory fac = org.apache.axiom.om.OMAbstractFactory.getOMFactory();
                                                org.apache.axiom.om.OMNamespace omNs = fac.createOMNamespace("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd", "");
                                                org.apache.axiom.om.OMElement _valueFlvRecordingMetaData = fac.createOMElement("flvRecordingMetaData", omNs);
                                                _valueFlvRecordingMetaData.addChild(fac.createOMText(_valueFlvRecordingMetaData, content));
                                                object.setFlvRecordingMetaData(_valueFlvRecordingMetaData);
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","flvWidth").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFlvWidth(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setFlvWidth(java.lang.Integer.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setFlvWidth(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","height").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setHeight(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setHeight(java.lang.Integer.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setHeight(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","inserted").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setInserted(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","insertedBy").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setInsertedBy(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setInsertedBy(java.lang.Long.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setInsertedBy(java.lang.Long.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","isFolder").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsFolder(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","isImage").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsImage(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","isInterview").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsInterview(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","isPresentation").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsPresentation(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","isRecording").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsRecording(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","organization_id").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOrganization_id(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setOrganization_id(java.lang.Long.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setOrganization_id(java.lang.Long.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","ownerId").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOwnerId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setOwnerId(java.lang.Long.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setOwnerId(java.lang.Long.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","parentFileExplorerItemId").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setParentFileExplorerItemId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setParentFileExplorerItemId(java.lang.Long.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setParentFileExplorerItemId(java.lang.Long.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","previewImage").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPreviewImage(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","progressPostProcessing").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setProgressPostProcessing(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setProgressPostProcessing(java.lang.Integer.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setProgressPostProcessing(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","recordEnd").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRecordEnd(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","recordStart").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRecordStart(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","recorderStreamId").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRecorderStreamId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","room").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setRoom(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setRoom(org.sakaiproject.videoconference.openmeetings.service.app.hibernate.beans.rooms.xsd.Rooms.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","room_id").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRoom_id(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setRoom_id(java.lang.Long.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setRoom_id(java.lang.Long.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","updated").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setUpdated(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://flvrecord.beans.hibernate.app.openmeetings.org/xsd","width").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setWidth(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                            
                                       } else {
                                           
                                           
                                                   object.setWidth(java.lang.Integer.MIN_VALUE);
                                               
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setWidth(java.lang.Integer.MIN_VALUE);
                                           
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
           
          