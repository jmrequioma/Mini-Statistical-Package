package main;

import java.util.List;

import main.Data;

public class SamplingTechniques {
	
	protected List<Data> samplingFrame;
	protected int population;
	protected int sampleSizePercent;
	protected int sampleSize;
	
	
	public SamplingTechniques(List<Data> samplingFrame, int population, int sampleSize) {
		this.samplingFrame = samplingFrame;
		this.population = population;
		this.sampleSize = sampleSize;
	}
	
	public SamplingTechniques(int sampleSizePercent, List<Data> samplingFrame, int population) {
		
		this.sampleSizePercent = sampleSizePercent;
		this.samplingFrame = samplingFrame;
		this.population = population;	
	}
}
