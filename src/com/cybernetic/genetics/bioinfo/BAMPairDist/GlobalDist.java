package com.cybernetic.genetics.bioinfo.BAMPairDist;

import java.io.File;

import net.sf.samtools.*;
import net.sf.samtools.SAMFileReader.ValidationStringency;

/**
 * Just count all the distances and print out to standard output
 * Good for visualize the results in R
 * 
 * @author Travis
 *
 */
public class GlobalDist {

	private SAMFileReader first;
	private SAMFileReader second;
	
	public GlobalDist(String string, String string2) {
		SAMFileReader.setDefaultValidationStringency(ValidationStringency.SILENT);
		first = new SAMFileReader(new File(string));
		second = new SAMFileReader(new File(string2));
	}

	public void run() {
		// TODO Auto-generated method stub
		SAMRecordIterator fiter = first.iterator();
		SAMRecordIterator siter = second.iterator();
		
		while(fiter.hasNext() && siter.hasNext()){
			SAMRecord firstrecord  = fiter.next();
			SAMRecord secondrecord = siter.next();
			
			if(firstrecord.getReadUnmappedFlag() || secondrecord.getReadUnmappedFlag()){
				continue;
			}
			
			if(firstrecord.getReferenceName() == secondrecord.getReferenceName()){
				int dist = secondrecord.getAlignmentStart() - firstrecord.getAlignmentStart();
				System.out.println(dist);
			}
		}
		
		first.close();
		second.close();
	}

}
