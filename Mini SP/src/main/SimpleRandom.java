package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import main.Data;

public class SimpleRandom extends SamplingTechniques {
	Random rand = new Random();
	public SimpleRandom(List<Data> samplingFrame, int population, 
			  int sampleSize) 
	{
		super(samplingFrame, population, sampleSize);
	}
	
	public List<Data> getRandom() {
		List<Data> randomData = new ArrayList<Data>();   // the list that holds the answer
		List<Integer> indexArray = new ArrayList<Integer>();   // holds the selected random indices
		
		for (int i = 0; i < sampleSize; i++) {
			int randNum = rand.nextInt(population);
			if (!indexArray.contains(randNum)) {
				indexArray.add(randNum);
			} else {
				i--;
			}
		}
		
		for (int i = 0; i < indexArray.size(); i++) {
			randomData.add(samplingFrame.get(indexArray.get(i)));
		}
		
		return randomData;
	}
}
