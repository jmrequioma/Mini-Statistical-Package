package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import main.Data;

public class Systematic extends SamplingTechniques {
	Random rand = new Random();
	public Systematic(List<Data> samplingFrame, int population, 
			  int sampleSize) 
	{
		super(samplingFrame, population, sampleSize);
	}
	
	public List<Data> getRandom() {
		List<Data> randomData = new ArrayList<Data>();
		List<Integer> indexArray = new ArrayList<Integer>();
		
		int k = population / sampleSize;   // floor
		int randNum = rand.nextInt(k);
		
		for (int i = 0; i < sampleSize; i++) {
			indexArray.add(randNum);
			randNum += k;
		}
		
		for (int i = 0; i < indexArray.size(); i++) {
			randomData.add(samplingFrame.get(indexArray.get(i)));
		}
		
		return randomData; 
	}
}
