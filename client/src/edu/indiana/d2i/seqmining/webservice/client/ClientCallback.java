package edu.indiana.d2i.seqmining.webservice.client;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.commons.io.IOUtils;

public class ClientCallback extends SeqPatternMinerCallbackHandler {

	private AtomicBoolean complete = new AtomicBoolean(false);

	private Properties clientProp;

	public ClientCallback(Properties clientProp) {

		this.clientProp = clientProp;
	}

	@Override
	public void receiveResultseqPatternMiningParaView(
			edu.indiana.d2i.seqmining.webservice.client.SeqPatternMinerStub.SeqPatternMiningParaViewResponse result) {
		boolean success = result.get_return();

		if (success) {
			System.out.println("paraview web service ran successfully");
		} else {
			System.out.println("paraview web service failed");
		}

		// set completion to be true
		complete.set(true);
	}

	@Override
	public void receiveResultseqPatternMining(
			edu.indiana.d2i.seqmining.webservice.client.SeqPatternMinerStub.SeqPatternMiningResponse result) {

		SeqPatternMinerStub.Figure[] figures = result.get_return();

		String folderName = clientProp
				.getProperty(ClientConstants.CLIENT_FIGURE_OUTPUT_DIR);
		if (File.separator.equals("/")) {
			folderName += "/";
		} else {
			folderName += "\\";
		}

		for (SeqPatternMinerStub.Figure patternFigure : figures) {

			String figureName = patternFigure.getName();
			InputStream is;
			try {
				is = patternFigure.getContent().getInputStream();

				byte[] byteArray = IOUtils.toByteArray(is);

				IOUtils.write(byteArray, new FileOutputStream(folderName
						+ figureName));

				System.out.println("Write figure " + figureName);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		// set completion to be true
		complete.set(true);
	}

	public AtomicBoolean getComplete() {
		return complete;
	}

}
