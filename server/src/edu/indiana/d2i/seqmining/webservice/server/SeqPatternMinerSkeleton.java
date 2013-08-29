/**
 * SeqPatternMinerSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
package edu.indiana.d2i.seqmining.webservice.server;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.activation.DataHandler;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.soap.util.mime.ByteArrayDataSource;

import edu.indiana.d2i.seqmining.webservice.xsd.Figure;
import edu.indiana.d2i.seqmining.webservice.xsd.Parameter;

/**
 * SeqPatternMinerSkeleton java skeleton for the axisService
 */
public class SeqPatternMinerSkeleton implements
		SeqPatternMinerSkeletonInterface {

	private static Logger logger = Logger
			.getLogger(SeqPatternMinerSkeleton.class);

	private Properties serverProp;

	public SeqPatternMinerSkeleton() throws IOException {
		InputStream is = SeqPatternMinerSkeleton.class.getClassLoader()
				.getResourceAsStream(ServerConstants.SERVER_PROPERTY_FNAME);

		serverProp = new Properties();
		serverProp.load(is);
	}

	public boolean seqPatternMiningParaView(Parameter[] paras) {
		boolean success = false;

		logger.info("Serving  \"seqPatternMiningParaView\" request ...");

		try {

			runSeqPatternMiner(paras);
			success = true;
			logger.info("run algorithm successfully");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}

		logger.info("Done \"seqPatternMiningParaView\"");
		return success;
	}

	public Figure[] seqPatternMining(Parameter[] paras) {

		boolean success = false;

		logger.info("Serving  \"seqPatternMining\" request ...");

		try {

			runSeqPatternMiner(paras);
			success = true;
			logger.info("run algorithm successfully");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}

		Figure[] figures = new Figure[0];

		if (success) {
			try {
				figures = loadPatternFigures();

				logger.info("run load figures successfully");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
			}
		}

		logger.info("Done \"seqPatternMining\"");
		return figures;

	}

	private void runSeqPatternMiner(Parameter[] paras)
			throws FileNotFoundException, IOException, InterruptedException {

		// set client specified configurations
		if (paras.length > 0) {

			// load sequential pattern miner configuration file
			String propFilename = serverProp
					.getProperty(ServerConstants.SEQ_PATTERN_MINING_CONFIG_FILE_PATH);
			Properties minerProp = new Properties();
			minerProp.load(new FileInputStream(propFilename));

			// loop over each client specified parameter
			for (int i = 0; i < paras.length; i++) {

				minerProp.setProperty(paras[i].getName(), paras[i].getValue());

				logger.info(String.format("Set %s=%s", paras[i].getName(),
						paras[i].getValue()));

			}

			// write updated property file back
			minerProp.store(new FileOutputStream(propFilename), "");
		}

		// run sequential pattern mining
		String scriptsHome = serverProp
				.getProperty(ServerConstants.SEQ_PATTERN_MINING_SCRIPTS_HOME);
		String[] scripts = serverProp.getProperty(
				ServerConstants.SEQ_PATTERN_MINING_SCRIPTS_NAME).split(";");

		File scriptHome = new File(scriptsHome);

		for (int i = 0; i < scripts.length; i++) {
			String shellScript = scriptsHome + File.separator + scripts[i];
			logger.info("Going to execute shell script :" + shellScript);

			String cmd = "./" + scripts[i];

			Process p = Runtime.getRuntime().exec(cmd, null, scriptHome);

			p.waitFor();
			int exitCode = p.exitValue();

			if (exitCode != 0) {
				logger.error("Error occurs when invoking command:" + shellScript);
				logger.error("Error code: " + exitCode);
			} else {
				logger.info("Command executed successfully");
			}

		}
	}

	private Figure[] loadPatternFigures() throws IOException {
		File figureDir = new File(
				serverProp.getProperty(ServerConstants.SEQ_PATTERN_FIGURES_DIR));

		File[] figures = figureDir.listFiles(new FileFilter() {
			private String figureSuffix = serverProp
					.getProperty(ServerConstants.SEQ_PATTERN_FIGURE_SUFFIX);

			@Override
			public boolean accept(File pathname) {
				// TODO Auto-generated method stub
				return pathname.isFile()
						&& pathname.getName().endsWith(figureSuffix);
			}

		});

		Figure[] patternFigures = new Figure[figures.length];

		for (int i = 0; i < figures.length; i++) {
			byte[] figureContent = FileUtils.readFileToByteArray(figures[i]);
			String figureName = figures[i].getName();

			Figure fig = new Figure();
			fig.setName(figureName);
			fig.setContent(new DataHandler(new ByteArrayDataSource(
					figureContent, "application/octet-stream")));

			patternFigures[i] = fig;

			logger.info(String.format("Read figure %s", figureName));
		}

		return patternFigures;
	}
}
