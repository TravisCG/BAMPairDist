package com.cybernetic.genetics.bioinfo.BAMPairDist;

/**
 * Read pair distance distribution 
 * @author Travis
 *
 */
public class Main {

	public static void main(String[] args) {
		if(args.length == 0 || args[0].startsWith("-h")){
			printHelp();
			return;
		}
		if(args[0].equals("global")){
			GlobalDist global = new GlobalDist(args[1], args[2]);
			global.run();
		}

	}

	private static void printHelp() {
		System.out.println("Bam Pair distribution");
		System.out.println("Align the read pairs individually to the reference");
		System.out.println("without sorting and indexing.");
		System.out.println("This guaranties the read order will be the same between alignments");
		System.out.println("After that you can use this program\n");
		System.out.println("BAMPairDist global first.bam second.bam : Global distribution across the whole reference");
		
	}

}
