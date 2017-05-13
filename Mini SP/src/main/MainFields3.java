package main;

import java.util.ArrayList;
import java.util.List;

public class MainFields3 {
	private static String samplingTechnique;
	private static int populationSize;
	private static List<Data> samplingFrame = new ArrayList<Data>();
	private static String dataType;
	
	
	public static String getSamplingTechnique() {
		return samplingTechnique;
	}

	public static void setSamplingTechnique(String samplingTechnique) {
		MainFields3.samplingTechnique = samplingTechnique;
	}

	public static int getPopulationSize() {
		return populationSize;
	}

	public static void setPopulationSize(int populationSize) {
		MainFields3.populationSize = populationSize;
	}

	public static List<Data> getSamplingFrame() {
		return samplingFrame;
	}

	public static void setSamplingFrame(List<Data> samplingFrame) {
		MainFields3.samplingFrame = samplingFrame;
	}

	public static String getDataType() {
		return dataType;
	}

	public static void setDataType(String dataType) {
		MainFields3.dataType = dataType;
	}
	
	public static void clearSamplingFrame() {
		MainFields3.samplingFrame.clear();
	}
}
