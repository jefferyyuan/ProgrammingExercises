package com.cllin.cci.chap19;

import java.util.HashMap;

import com.cllin.main.Exercise;

/*
 * Design a method to find the frequency of occurrences of any given word in a book.
 */

public class Exercise19_08 extends Exercise {
    private final String text = "Android 4.4 is designed to run fast, smooth, and responsively on a much broader range of devices than ever before �X including on millions of entry-level devices around the world that have as little as 512MB RAM. KitKat streamlines every major component to reduce memory use and introduces new APIs and tools to help you create innovative, responsive, memory-efficient applications. OEMs building the next generation of Android devices can take advantage of targeted recommendations and options to run Android 4.4 efficiently, even on low-memory devices. Dalvik JIT code cache tuning, kernel samepage merging (KSM), swap to zRAM, and other optimizations help manage memory. New configuration options let OEMs tune out-of-memory levels for processes, set graphics cache sizes, control memory reclaim, and more. In Android itself, changes across the system improve memory management and reduce memory footprint. Core system processes are trimmed to use less heap, and they now more aggressively protect system memory from apps consuming large amounts of RAM. When multiple services start at once �X such as when network connectivity changes �X Android now launches the services serially, in small groups, to avoid peak memory demands. For developers, Android 4.4 helps you deliver apps that are efficient and responsive on all devices. A new API, ActivityManager.isLowRamDevice(), lets you tune your app's behavior to match the device's memory configuration. You can modify or disable large-memory features as needed, depending on the use-cases you want to support on entry-level devices. Learn more about optimizing your apps for low-memory devices here. New tools give also give you powerful insight into your app's memory use. The procstats tool details memory use over time, with run times and memory footprint for foreground apps and background services. An on-device view is also available as a new developer option. The meminfo tool is enhanced to make it easier to spot memory trends and issues, and it reveals additional memory overhead that hasn't previously been visible.";
    private final String[] words = new String[]{"android", "devices", "iphone", "is", "and"};
    
    private static HashMap<String, Integer> readText(String text) {
        HashMap<String, Integer> frequencyTable = new HashMap<String, Integer>();
        
        text.replace(",", "");
        text = text.toLowerCase();
        
        String[] words = text.split(" ");
        
        for (String word : words) {
            int count = (frequencyTable.containsKey(word))? frequencyTable.get(word) : 0;
            frequencyTable.put(word, count + 1);
        }
        
        return frequencyTable;
    }

    @Override
    protected void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        HashMap<String, Integer> frequencyTable = readText(text);

        for (String word : words) {
            System.out.printf(
                    "W = %s, Count(%s) = %d%n",
                    word,
                    word,
                    (frequencyTable.containsKey(word)) ? frequencyTable
                            .get(word) : 0);
        }
    }

    @Override
    protected boolean test() {
        return true;
    }
}
