package com.cllin.cci.chap19;

import java.util.HashMap;

import com.cllin.main.Exercise;

public class Exercise19_08 implements Exercise {
	private String text = "Android 4.4 is designed to run fast, smooth, and responsively on a much broader range of devices than ever before ¡X including on millions of entry-level devices around the world that have as little as 512MB RAM. KitKat streamlines every major component to reduce memory use and introduces new APIs and tools to help you create innovative, responsive, memory-efficient applications. OEMs building the next generation of Android devices can take advantage of targeted recommendations and options to run Android 4.4 efficiently, even on low-memory devices. Dalvik JIT code cache tuning, kernel samepage merging (KSM), swap to zRAM, and other optimizations help manage memory. New configuration options let OEMs tune out-of-memory levels for processes, set graphics cache sizes, control memory reclaim, and more. In Android itself, changes across the system improve memory management and reduce memory footprint. Core system processes are trimmed to use less heap, and they now more aggressively protect system memory from apps consuming large amounts of RAM. When multiple services start at once ¡X such as when network connectivity changes ¡X Android now launches the services serially, in small groups, to avoid peak memory demands. For developers, Android 4.4 helps you deliver apps that are efficient and responsive on all devices. A new API, ActivityManager.isLowRamDevice(), lets you tune your app's behavior to match the device's memory configuration. You can modify or disable large-memory features as needed, depending on the use-cases you want to support on entry-level devices. Learn more about optimizing your apps for low-memory devices here. New tools give also give you powerful insight into your app's memory use. The procstats tool details memory use over time, with run times and memory footprint for foreground apps and background services. An on-device view is also available as a new developer option. The meminfo tool is enhanced to make it easier to spot memory trends and issues, and it reveals additional memory overhead that hasn't previously been visible.";
	private HashMap<String, Integer> frequencyTable;
	
	
	@Override
	public void runExercise() {
		frequencyTable = new HashMap<String, Integer>();
		
		readText();
		
		String android = "android";
		String devices = "devices";
		String iphone = "iphone";
		
		System.out.println("The word '" + android + "' occurs " + findFrequency(android) + " times in this text");
		System.out.println("The word '" + devices + "' occurs " + findFrequency(devices) + " times in this text");
		System.out.println("The word '" + iphone + "' occurs " + findFrequency(iphone) + " times in this text");
	}
	
	private int findFrequency(String word){
		if(frequencyTable.containsKey(word)){
			return frequencyTable.get(word);
		}else{
			return 0;
		}
	}
	
	private void readText(){
		String separator = " ";
		text.replace(",", "");
		text = text.toLowerCase();
		
		int length = text.length();
		int iter = 0;
		
		
		while(iter < length && text.indexOf(separator, iter + 1) > 0 ){
			String word = text.substring(iter, text.indexOf(separator, iter + 1));
			if(frequencyTable.containsKey(word)){
				frequencyTable.put(word, frequencyTable.get(word) + 1);
			}else{
				frequencyTable.put(word, 1);
			}
			iter = text.indexOf(separator, iter + 1) + 1;
		}
	}

}
