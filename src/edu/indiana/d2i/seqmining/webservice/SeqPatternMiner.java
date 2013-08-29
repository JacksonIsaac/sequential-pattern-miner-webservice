package edu.indiana.d2i.seqmining.webservice;

import java.util.ArrayList;
import java.util.List;

/**
 * This class defines web services exposed by the server and is used to generate
 * WSDL via Axis2 tool "Java2WSDL"
 * 
 * @author Guangchen
 * 
 */
public class SeqPatternMiner {

	public List<Figure> seqPatternMining(List<Parameter> paras) {
		List<Figure> figures = new ArrayList<Figure>();

		return figures;
	}

	public boolean seqPatternMiningParaView(List<Parameter> paras) {
		boolean success = true;

		return success;
	}
}
