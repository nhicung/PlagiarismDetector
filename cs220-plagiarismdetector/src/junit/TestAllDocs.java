package junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Collection;

import org.junit.Test;

import plagiarismdetector.IPlagiarismDetector;
import plagiarismdetector.impl.PlagiarismDetector;
//import plagiarismdetector.sol.PlagiarismDetector;

public class TestAllDocs
{
    private static final String ALLDOCS = "docs/alldocs";
    
    IPlagiarismDetector detector;
    
    private void makeDetector(int n) throws Exception {
        detector = new PlagiarismDetector(n);
        detector.readFilesInDirectory(new File(ALLDOCS));
    }
    
    @Test
    public void testNumfiles() throws Exception {
        makeDetector(4);
        assertEquals(929, detector.getFilenames().size());
    }
    
    @Test
    public void testPairs() throws Exception {
        makeDetector(4);
        Collection<String> pairs = detector.getSuspiciousPairs(1000);
        System.out.println(pairs.size()); 
        
    }
    
}