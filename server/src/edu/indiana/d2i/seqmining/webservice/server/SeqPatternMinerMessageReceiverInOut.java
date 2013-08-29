/**
 * SeqPatternMinerMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
package edu.indiana.d2i.seqmining.webservice.server;

/**
 * SeqPatternMinerMessageReceiverInOut message receiver
 */

public class SeqPatternMinerMessageReceiverInOut extends
		org.apache.axis2.receivers.AbstractInOutAsyncMessageReceiver {

	public void invokeBusinessLogic(
			org.apache.axis2.context.MessageContext msgContext,
			org.apache.axis2.context.MessageContext newMsgContext)
			throws org.apache.axis2.AxisFault {

		try {

			// get the implementation class for the Web Service
			Object obj = getTheImplementationObject(msgContext);

			SeqPatternMinerSkeletonInterface skel = (SeqPatternMinerSkeletonInterface) obj;
			// Out Envelop
			org.apache.axiom.soap.SOAPEnvelope envelope = null;
			// Find the axisOperation that has been set by the Dispatch phase.
			org.apache.axis2.description.AxisOperation op = msgContext
					.getOperationContext().getAxisOperation();
			if (op == null) {
				throw new org.apache.axis2.AxisFault(
						"Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
			}

			java.lang.String methodName;
			if ((op.getName() != null)
					&& ((methodName = org.apache.axis2.util.JavaUtils
							.xmlNameToJavaIdentifier(op.getName()
									.getLocalPart())) != null)) {

				if ("seqPatternMiningParaView".equals(methodName)) {

					edu.indiana.d2i.seqmining.webservice.SeqPatternMiningParaViewResponse seqPatternMiningParaViewResponse12 = null;
					edu.indiana.d2i.seqmining.webservice.SeqPatternMiningParaView wrappedParam = (edu.indiana.d2i.seqmining.webservice.SeqPatternMiningParaView) fromOM(
							msgContext.getEnvelope().getBody()
									.getFirstElement(),
							edu.indiana.d2i.seqmining.webservice.SeqPatternMiningParaView.class,
							getEnvelopeNamespaces(msgContext.getEnvelope()));

					seqPatternMiningParaViewResponse12 =

					wrapSeqPatternMiningParaViewResponse_return(

					skel.seqPatternMiningParaView(

					getParas(wrappedParam))

					);

					envelope = toEnvelope(
							getSOAPFactory(msgContext),
							seqPatternMiningParaViewResponse12,
							false,
							new javax.xml.namespace.QName(
									"http://webservice.seqmining.d2i.indiana.edu",
									"seqPatternMiningParaView"));
				} else

				if ("seqPatternMining".equals(methodName)) {

					edu.indiana.d2i.seqmining.webservice.SeqPatternMiningResponse seqPatternMiningResponse16 = null;
					edu.indiana.d2i.seqmining.webservice.SeqPatternMining wrappedParam = (edu.indiana.d2i.seqmining.webservice.SeqPatternMining) fromOM(
							msgContext.getEnvelope().getBody()
									.getFirstElement(),
							edu.indiana.d2i.seqmining.webservice.SeqPatternMining.class,
							getEnvelopeNamespaces(msgContext.getEnvelope()));

					seqPatternMiningResponse16 =

					wrapSeqPatternMiningResponse_return(

					skel.seqPatternMining(

					getParas(wrappedParam))

					);

					envelope = toEnvelope(
							getSOAPFactory(msgContext),
							seqPatternMiningResponse16,
							false,
							new javax.xml.namespace.QName(
									"http://webservice.seqmining.d2i.indiana.edu",
									"seqPatternMining"));

				} else {
					throw new java.lang.RuntimeException("method not found");
				}

				newMsgContext.setEnvelope(envelope);
			}
		} catch (java.lang.Exception e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
	}

	//
	private org.apache.axiom.om.OMElement toOM(
			edu.indiana.d2i.seqmining.webservice.SeqPatternMiningParaView param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param
					.getOMElement(
							edu.indiana.d2i.seqmining.webservice.SeqPatternMiningParaView.MY_QNAME,
							org.apache.axiom.om.OMAbstractFactory
									.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(
			edu.indiana.d2i.seqmining.webservice.SeqPatternMiningParaViewResponse param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param
					.getOMElement(
							edu.indiana.d2i.seqmining.webservice.SeqPatternMiningParaViewResponse.MY_QNAME,
							org.apache.axiom.om.OMAbstractFactory
									.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(
			edu.indiana.d2i.seqmining.webservice.SeqPatternMining param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param
					.getOMElement(
							edu.indiana.d2i.seqmining.webservice.SeqPatternMining.MY_QNAME,
							org.apache.axiom.om.OMAbstractFactory
									.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(
			edu.indiana.d2i.seqmining.webservice.SeqPatternMiningResponse param,
			boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param
					.getOMElement(
							edu.indiana.d2i.seqmining.webservice.SeqPatternMiningResponse.MY_QNAME,
							org.apache.axiom.om.OMAbstractFactory
									.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
			org.apache.axiom.soap.SOAPFactory factory,
			edu.indiana.d2i.seqmining.webservice.SeqPatternMiningParaViewResponse param,
			boolean optimizeContent, javax.xml.namespace.QName methodQName)
			throws org.apache.axis2.AxisFault {
		try {
			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory
					.getDefaultEnvelope();

			emptyEnvelope
					.getBody()
					.addChild(
							param.getOMElement(
									edu.indiana.d2i.seqmining.webservice.SeqPatternMiningParaViewResponse.MY_QNAME,
									factory));

			return emptyEnvelope;
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
	}

	private edu.indiana.d2i.seqmining.webservice.xsd.Parameter[] getParas(
			edu.indiana.d2i.seqmining.webservice.SeqPatternMiningParaView wrappedType) {

		return wrappedType.getParas();

	}

	private edu.indiana.d2i.seqmining.webservice.SeqPatternMiningParaViewResponse wrapSeqPatternMiningParaViewResponse_return(
			boolean param) {
		edu.indiana.d2i.seqmining.webservice.SeqPatternMiningParaViewResponse wrappedElement = new edu.indiana.d2i.seqmining.webservice.SeqPatternMiningParaViewResponse();

		wrappedElement.set_return(param);

		return wrappedElement;
	}

	private edu.indiana.d2i.seqmining.webservice.SeqPatternMiningParaViewResponse wrapseqPatternMiningParaView() {
		edu.indiana.d2i.seqmining.webservice.SeqPatternMiningParaViewResponse wrappedElement = new edu.indiana.d2i.seqmining.webservice.SeqPatternMiningParaViewResponse();
		return wrappedElement;
	}

	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
			org.apache.axiom.soap.SOAPFactory factory,
			edu.indiana.d2i.seqmining.webservice.SeqPatternMiningResponse param,
			boolean optimizeContent, javax.xml.namespace.QName methodQName)
			throws org.apache.axis2.AxisFault {
		try {
			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory
					.getDefaultEnvelope();

			emptyEnvelope
					.getBody()
					.addChild(
							param.getOMElement(
									edu.indiana.d2i.seqmining.webservice.SeqPatternMiningResponse.MY_QNAME,
									factory));

			return emptyEnvelope;
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
	}

	private edu.indiana.d2i.seqmining.webservice.xsd.Parameter[] getParas(
			edu.indiana.d2i.seqmining.webservice.SeqPatternMining wrappedType) {

		return wrappedType.getParas();

	}

	private edu.indiana.d2i.seqmining.webservice.SeqPatternMiningResponse wrapSeqPatternMiningResponse_return(
			edu.indiana.d2i.seqmining.webservice.xsd.Figure[] param) {
		edu.indiana.d2i.seqmining.webservice.SeqPatternMiningResponse wrappedElement = new edu.indiana.d2i.seqmining.webservice.SeqPatternMiningResponse();

		wrappedElement.set_return(param);

		return wrappedElement;
	}

	private edu.indiana.d2i.seqmining.webservice.SeqPatternMiningResponse wrapseqPatternMining() {
		edu.indiana.d2i.seqmining.webservice.SeqPatternMiningResponse wrappedElement = new edu.indiana.d2i.seqmining.webservice.SeqPatternMiningResponse();
		return wrappedElement;
	}

	/**
	 * get the default envelope
	 */
	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(
			org.apache.axiom.soap.SOAPFactory factory) {
		return factory.getDefaultEnvelope();
	}

	private java.lang.Object fromOM(org.apache.axiom.om.OMElement param,
			java.lang.Class type, java.util.Map extraNamespaces)
			throws org.apache.axis2.AxisFault {

		try {

			if (edu.indiana.d2i.seqmining.webservice.SeqPatternMiningParaView.class
					.equals(type)) {

				return edu.indiana.d2i.seqmining.webservice.SeqPatternMiningParaView.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (edu.indiana.d2i.seqmining.webservice.SeqPatternMiningParaViewResponse.class
					.equals(type)) {

				return edu.indiana.d2i.seqmining.webservice.SeqPatternMiningParaViewResponse.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (edu.indiana.d2i.seqmining.webservice.SeqPatternMining.class
					.equals(type)) {

				return edu.indiana.d2i.seqmining.webservice.SeqPatternMining.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (edu.indiana.d2i.seqmining.webservice.SeqPatternMiningResponse.class
					.equals(type)) {

				return edu.indiana.d2i.seqmining.webservice.SeqPatternMiningResponse.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());

			}

		} catch (java.lang.Exception e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
		return null;
	}

	/**
	 * A utility method that copies the namepaces from the SOAPEnvelope
	 */
	private java.util.Map getEnvelopeNamespaces(
			org.apache.axiom.soap.SOAPEnvelope env) {
		java.util.Map returnMap = new java.util.HashMap();
		java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
		while (namespaceIterator.hasNext()) {
			org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator
					.next();
			returnMap.put(ns.getPrefix(), ns.getNamespaceURI());
		}
		return returnMap;
	}

	private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
		org.apache.axis2.AxisFault f;
		Throwable cause = e.getCause();
		if (cause != null) {
			f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
		} else {
			f = new org.apache.axis2.AxisFault(e.getMessage());
		}

		return f;
	}

}// end of class
