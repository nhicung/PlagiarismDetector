package plagiarismdetector.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import plagiarismdetector.IPlagiarismDetector;

public class PlagiarismDetector implements IPlagiarismDetector
{
	private Set<String> filenames;
	private int n;
	Map<String, HashMap<String, Integer>> grid;
	
    public PlagiarismDetector(int n) {
    	
    	filenames = new HashSet<>();
    	this.n = n;
    	grid = new HashMap<String, HashMap<String, Integer>>();
    	
    }

    /* (non-Javadoc)
     * @see plagiarismdetector.IPlagiarismDetector#getN()
     */
    @Override
    public int getN() {
    	
        return n;
        
    }
    
    /* (non-Javadoc)
     * @see plagiarismdetector.IPlagiarismDetector#processDirectory(java.io.File)
     */
    @Override
    public void readFilesInDirectory(File dir) throws IOException {
    	
        for (File f : dir.listFiles()) {
            String fileName = f.getName();
            filenames.add(fileName);
            Scanner scan = new Scanner(new FileInputStream(f));
            
        }      
    }

    /* (non-Javadoc)
     * @see plagiarismdetector.IPlagiarismDetector#getFilenames()
     */
    @Override
    public Collection<String> getFilenames() {
    	
    	return filenames;
   
    }

    /* (non-Javadoc)
     * @see plagiarismdetector.IPlagiarismDetector#getNumNGramsInCommon(java.lang.String, java.lang.String)
     */
    @Override
    public int getNumNGramsInCommon(String file1, String file2) {
    	
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see plagiarismdetector.IPlagiarismDetector#getNgramsInFile(java.lang.String)
     */
    @Override
    public Collection<String> getNgramsInFile(String filename) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see plagiarismdetector.IPlagiarismDetector#getNumNgramsInFile(java.lang.String)
     */
    @Override
    public int getNumNgramsInFile(String filename) {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see plagiarismdetector.IPlagiarismDetector#getSuspiciousPairs(int)
     */
    @Override
    public Collection<String> getSuspiciousPairs(int minNgrams) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
