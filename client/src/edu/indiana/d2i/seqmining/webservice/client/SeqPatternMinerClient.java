package edu.indiana.d2i.seqmining.webservice.client;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.ConfigurationContextFactory;
import org.apache.axis2.description.Parameter;

public class SeqPatternMinerClient {

	enum SERVICE_TYPE {
		SEQ_PATTERN_MINING, SEQ_PATTERN_MINING_PARAVIEW
	}

	private SeqPatternMinerStub stub;
	private Properties clientProp;
	private Properties algoProp;

	public SeqPatternMinerClient() throws IOException {
		init();
	}

	private void init() throws IOException {
		InputStream is = SeqPatternMinerClient.class.getClassLoader()
				.getResourceAsStream(ClientConstants.CLIENT_PROPERTY_FNAME);

		clientProp = new Properties();
		clientProp.load(is);

		is = SeqPatternMinerClient.class.getClassLoader().getResourceAsStream(
				ClientConstants.SEQ_PATTERN_MINER_PROPERTY_FNAME);

		algoProp = new Properties();
		algoProp.load(is);

		stubSetup();
	}

	private void stubSetup() throws AxisFault {
		String path;

		if (File.separator.equals("/")) {
			path = System.getenv("AXIS2_HOME") + "/repository";
		} else {
			path = System.getenv("AXIS2_HOME") + "\\repository";
		}

		stub = new SeqPatternMinerStub(
				ConfigurationContextFactory
						.createConfigurationContextFromFileSystem(path));

		System.out.println("Web service EPR="
				+ clientProp
						.getProperty(ClientConstants.SEQ_PATTERN_MINER_WS_EPR));

		stub._getServiceClient()
				.getOptions()
				.setTo(new EndpointReference(clientProp
						.getProperty(ClientConstants.SEQ_PATTERN_MINER_WS_EPR)));

		ServiceClient svc = stub._getServiceClient();

		svc.getAxisConfiguration()
				.getTransportIn("http")
				.addParameter(
						new Parameter(
								"port",
								clientProp
										.getProperty(ClientConstants.CLIENT_CALLBACK_PORT)));

		stub._getServiceClient().engageModule("addressing");

		stub._getServiceClient().getOptions().setUseSeparateListener(true);
	}

	public SERVICE_TYPE getServiceType() {
		return SERVICE_TYPE.valueOf(clientProp
				.getProperty(ClientConstants.SEQ_PATTERN_MINER_WS_TYPE));
	}

	public void runSeqPatternMining() throws Exception {

		SeqPatternMinerStub.SeqPatternMining request = new SeqPatternMinerStub.SeqPatternMining();

		SeqPatternMinerStub.Parameter[] paras = new SeqPatternMinerStub.Parameter[algoProp
				.size()];
		int idx = 0;

		for (Object key : algoProp.keySet()) {

			String propName = (String) key;
			String value = algoProp.getProperty(propName);

			System.out.println(String.format("Read %s=%s", propName, value));

			SeqPatternMinerStub.Parameter parameter = new SeqPatternMinerStub.Parameter();
			parameter.setName(propName);
			parameter.setValue(value);

			paras[idx++] = parameter;
		}

		request.setParas(paras);

		ClientCallback callback = new ClientCallback(clientProp);

		stub.startseqPatternMining(request, callback);

		while (!callback.getComplete().get()) {
			Thread.sleep(500);
		}

		System.exit(0);

	}

	public void runSeqPatternMiningParaView() throws Exception {

		SeqPatternMinerStub.SeqPatternMiningParaView request = new SeqPatternMinerStub.SeqPatternMiningParaView();

		SeqPatternMinerStub.Parameter[] paras = new SeqPatternMinerStub.Parameter[algoProp
				.size()];
		int idx = 0;

		for (Object key : algoProp.keySet()) {

			String propName = (String) key;
			String value = algoProp.getProperty(propName);

			System.out.println(String.format("Read %s=%s", propName, value));

			SeqPatternMinerStub.Parameter parameter = new SeqPatternMinerStub.Parameter();
			parameter.setName(propName);
			parameter.setValue(value);

			paras[idx++] = parameter;
		}

		request.setParas(paras);

		ClientCallback callback = new ClientCallback(clientProp);

		stub.startseqPatternMiningParaView(request, callback);

		while (!callback.getComplete().get()) {
			Thread.sleep(500);
		}

		System.exit(0);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SeqPatternMinerClient client = null;

		try {
			client = new SeqPatternMinerClient();

			SERVICE_TYPE serviceType = client.getServiceType();
			System.out.println("Going to run service type " + serviceType);

			switch (serviceType) {
			case SEQ_PATTERN_MINING:
				client.runSeqPatternMining();
				break;
			case SEQ_PATTERN_MINING_PARAVIEW:
				client.runSeqPatternMiningParaView();
				break;
			default:
				System.err.println("Unrecognized service type " + serviceType);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Main function ended");

	}

}
