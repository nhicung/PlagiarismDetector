package plagiarismdetector.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;

import plagiarismdetector.IPlagiarismDetector;

public class PlagiarismDetector implements IPlagiarismDetector
{
    public PlagiarismDetector(int n) {
    	
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see plagiarismdetector.IPlagiarismDetector#getN()
     */
    @Override
    public int getN() {
    	
        // TODO Auto-generated method stub
        return 0;
    }
    
    /* (non-Javadoc)
     * @see plagiarismdetector.IPlagiarismDetector#processDirectory(java.io.File)
     */
    @Override
    public void readFilesInDirectory(File dir) throws IOException {
    	
        for (File f : dir.listFiles()) {
            String fileName = f.getName();
            Scanner scan = new Scanner(new FileInputStream(f));
            // TODO process the file using the scanner and the fileName
        }
        
    }

    /* (non-Javadoc)
     * @see plagiarismdetector.IPlagiarismDetector#getFilenames()
     */
    @Override
    public Collection<String> getFilenames() {
    	
        // TODO Auto-generated method stub
        return null;
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
