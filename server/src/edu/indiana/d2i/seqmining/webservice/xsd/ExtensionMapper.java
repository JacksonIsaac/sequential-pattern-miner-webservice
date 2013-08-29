
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:23:23 CEST)
 */

        
            package edu.indiana.d2i.seqmining.webservice.xsd;
        
            /**
            *  ExtensionMapper class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://webservice.seqmining.d2i.indiana.edu/xsd".equals(namespaceURI) &&
                  "Figure".equals(typeName)){
                   
                            return  edu.indiana.d2i.seqmining.webservice.xsd.Figure.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://webservice.seqmining.d2i.indiana.edu/xsd".equals(namespaceURI) &&
                  "Parameter".equals(typeName)){
                   
                            return  edu.indiana.d2i.seqmining.webservice.xsd.Parameter.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    