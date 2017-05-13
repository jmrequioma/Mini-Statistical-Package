package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import main.Data;

public class Stratified extends SamplingTechniques {
	String dataType;
	Random rand = new Random();
	public Stratified(List<Data> samplingFrame, int population, 
			  int sampleSizePercent, String dataType) 
	{
		super(sampleSizePercent, samplingFrame, population);
		this.dataType = dataType;
	}
	
	public Stratified(List<Data> samplingFrame, int population, String dataType) 
	{
		super(samplingFrame, population, 0);
		this.dataType = dataType;
	}
	
	public List<List<Data>> getRandom() {
		List<Data> copyOfSamplingFrame = copySamplingFrame();
		sort(copyOfSamplingFrame);
		List<List<Data>> randomData = getRandomData(copyOfSamplingFrame);

		return randomData;
	}
	
	public List<List<Data>> getStrata() {
		List<Data> copyOfSamplingFrame = copySamplingFrame();
		sort(copyOfSamplingFrame);
		List<List<Data>> groupedData = groupToStrata(copyOfSamplingFrame);
		
		return groupedData;
	}
	
	private List<Data> copySamplingFrame() {
		List<Data> copyOfSamplingFrame = new ArrayList<Data>();
		
		for (int i = 0; i < samplingFrame.size(); i++) {
			copyOfSamplingFrame.add(samplingFrame.get(i));
		}
		
		return copyOfSamplingFrame;
	}
	
	private void sort(List<Data> copyOfSamplingFrame) {
		if(dataType.equals("Integer")) {
			sortInteger(copyOfSamplingFrame);
		} else {
			sortCharacter(copyOfSamplingFrame);
		}
	}
	
	private void sortInteger(List<Data> copyOfSamplingFrame) {
		Data temp;
		for(int i = 0; i < copyOfSamplingFrame.size() - 1; i++) {
			for(int j = 1; j < copyOfSamplingFrame.size() - i; j++) {
				if(copyOfSamplingFrame.get(j - 1).getDataInteger() > copyOfSamplingFrame.get(j).getDataInteger()) {
					temp = copyOfSamplingFrame.get(j - 1);
					copyOfSamplingFrame.set(j - 1, copyOfSamplingFrame.get(j));
					copyOfSamplingFrame.set(j, temp);
				}
			}
		}
	}
	
	private void sortCharacter(List<Data> copyOfSamplingFrame) {
		Data temp;
		for(int i = 0; i < copyOfSamplingFrame.size() - 1; i++) {
			for(int j = 1; j < copyOfSamplingFrame.size() - i; j++) {
				final char prevData = copyOfSamplingFrame.get(j - 1).getDataCharacter();
				final char currData = copyOfSamplingFrame.get(j).getDataCharacter();
				final char prevDataRep = representativeOf(prevData);
				final char currDataRep = representativeOf(currData);
				if(prevData > currData) {
					temp = copyOfSamplingFrame.get(j - 1);
					copyOfSamplingFrame.set(j - 1, copyOfSamplingFrame.get(j));
					copyOfSamplingFrame.set(j, temp);
				}
			}
		}
		
	}
	
	private char representativeOf(char data) {
		if(data >= 97) {
			data = (char) (data - 32);
		}
		return data;
	}
	
	private List<List<Data>> getRandomData(List<Data> copyOfSamplingFrame) {
		List<List<Data>> randomData = groupToStrata(copyOfSamplingFrame);
		randomize(randomData);
		
		return randomData;
	}
	
	private List<List<Data>> groupToStrata(List<Data> sortedSamplingFrameCopy) {
		ArrayList<Integer> index = lastOccurencesIndex(sortedSamplingFrameCopy);
		List<List<Data>> groupedData = groupData(index, sortedSamplingFrameCopy);
		
		return groupedData;
	}
	
	private ArrayList<Integer> lastOccurencesIndex(List<Data> sortedSamplingFrameCopy) {
		ArrayList<Integer> index = new ArrayList<Integer>();
		
		for (int i = 1; i < sortedSamplingFrameCopy.size(); i++) {
			if(dataType.equals("Integer")) {
				final int dataPointed = sortedSamplingFrameCopy.get(i).getDataInteger();
				final int prevData = sortedSamplingFrameCopy.get(i - 1).getDataInteger();
				if (dataPointed != prevData) {
					index.add(i - 1);
				}
			} else {
				final char dataPointed = sortedSamplingFrameCopy.get(i).getDataCharacter();
				final char prevData = sortedSamplingFrameCopy.get(i - 1).getDataCharacter();
				if (dataPointed != prevData && Math.abs(dataPointed - prevData) != 32) {
					index.add(i - 1);
				}
			}
		}
		index.add(sortedSamplingFrameCopy.size() - 1); 
		
		return index;
	}
	
	private List<List<Data>> groupData(ArrayList<Integer> index, 
									   List<Data> sortedSamplingFrameCopy ) 
	{
		List<List<Data>> groupedData = new ArrayList<List<Data>>();
		for (int i = 0; i < index.size(); i++) {
			ArrayList<Data> bucket = new ArrayList<Data>();
			int start;
			if (i == 0) {
				start = 0;
			} else {
				start = index.get(i - 1) + 1;
			}
			for (int j = start; j <= index.get(i); j++) {
				bucket.add(sortedSamplingFrameCopy.get(j));
			}
			groupedData.add(bucket);
		}
		
		return groupedData;
	}
	
	private void randomize(List<List<Data>> groupedData) {
		for (int i = 0; i < groupedData.size(); i++) {
			Collections.shuffle(groupedData.get(i));
			
			List<Data> strata = groupedData.get(i);
			int sampleSize = (int) Math.ceil(strata.size() * (sampleSizePercent / (float)100));
			
			if (strata.size() <= sampleSize) {
				// do nothing
			} else {
				final int removeNum = (groupedData.get(i).size() - sampleSize);
				for (int j = 0; j < removeNum; j++) {
					groupedData.get(i).remove(0);
				}
			}
		}
	}
}
