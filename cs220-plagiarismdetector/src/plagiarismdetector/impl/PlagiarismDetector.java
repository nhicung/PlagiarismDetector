package plagiarismdetector.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import plagiarismdetector.IPlagiarismDetector;

public class PlagiarismDetector implements IPlagiarismDetector {
	// private Set<String> filenames;
	private int n;
	private Map<String, HashSet<String>> files;
	Map<String, HashMap<String, Integer>> grid;

	public PlagiarismDetector(int n) {

		// filenames = new HashSet<>();
		this.n = n;
		files = new HashMap<String, HashSet<String>>();
		grid = new HashMap<String, HashMap<String, Integer>>();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see plagiarismdetector.IPlagiarismDetector#getN()
	 */
	@Override
	public int getN() {

		return n;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see plagiarismdetector.IPlagiarismDetector#processDirectory(java.io.File)
	 */
	@Override
	public void readFilesInDirectory(File dir) throws IOException {

		for (File f : dir.listFiles()) {
			String fileName = f.getName();
			files.put(fileName, new HashSet<String>());
			Scanner scan = new Scanner(new FileInputStream(f));

			String gram = "";
			for (int i = 0; i < n - 1; i++) {
				gram += scan.next() + " ";
			}

			gram = gram.trim();

			while (scan.hasNext()) {
				gram += " " + scan.next();
				files.get(fileName).add(gram);
				gram = gram.substring(gram.indexOf(' ') + 1);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see plagiarismdetector.IPlagiarismDetector#getFilenames()
	 */
	@Override
	public Collection<String> getFilenames() {

		return files.keySet();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * plagiarismdetector.IPlagiarismDetector#getNumNGramsInCommon(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public int getNumNGramsInCommon(String file1, String file2) {
		// create two sets of string to store in the n-grams from each file
		Set<String> set1 = files.get(file1);
		Set<String> set2 = files.get(file2);

		int count = 0;
		// scan each set to see if there is any common n-grams (string) and count them
		for (String s1 : set1) {
			for (String s2 : set2) {
				if (s1.equals(s2)) {
					count++;
				}
			}
		}
		// Check if grid already has file1 and file2. If not, add them in.

		if (!grid.containsKey(file1)) {
			grid.put(file1, new HashMap<String, Integer>());

		}
		if (!grid.containsKey(file2)) {
			grid.put(file2, new HashMap<String, Integer>());
		}

		// set up the information and put into grid (for next method)
		grid.get(file1).put(file2, count);
		grid.get(file2).put(file1, count);
		return count;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see plagiarismdetector.IPlagiarismDetector#getNgramsInFile(java.lang.String)
	 */
	@Override
	public Collection<String> getNgramsInFile(String filename) {

		return files.get(filename);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * plagiarismdetector.IPlagiarismDetector#getNumNgramsInFile(java.lang.String)
	 */
	@Override
	public int getNumNgramsInFile(String filename) {

		return files.get(filename).size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see plagiarismdetector.IPlagiarismDetector#getSuspiciousPairs(int)
	 */
	@Override
	public Collection<String> getSuspiciousPairs(int minNgrams) {

		Set<String> pair = new HashSet<String>();
		// this set is to add all of the f1 after it is compared to f2
		Set<String> checkContain = new HashSet<String>();

		for (String f1 : files.keySet()) {
			for (String f2 : files.keySet()) {

				// check if this file has already in the check checkContain set
				// if it is, continue and don't need to scan again
				if (checkContain.contains(f2)) {
					continue;
				}
				// check if the two files are the same
				// if they are, continue and don't need to compare them
				if (f1.equals(f2)) {
					continue;
				}

				// if not duplicated and not the same files, call function getNumNGramsInCommon
				// to set them up into grid
				this.getNumNGramsInCommon(f1, f2);

				// compare the common number of n-grams to minNGrams
				// if equals or more than that, add to set pair

				if (grid.get(f1).get(f2) >= minNgrams) {
					String s;
					int order = f1.compareTo(f2);
					if (order < 0) {
						s = f1 + " " + f2 + " " + grid.get(f1).get(f2);
					}

					else {
						s = f2 + " " + f1 + " " + grid.get(f1).get(f2);
					}
					pair.add(s);

				}
			}
			checkContain.add(f1);
		}
		return pair;
	}
	
	public Collection<String> getNGramsInCommon(String file1, String file2) {
		// create two sets of string to store in the n-grams from each file
		Set<String> set1 = files.get(file1);
		Set<String> set2 = files.get(file2);
		Set<String> commonNGram = new HashSet<String>();

		// scan each set to see if there is any common n-grams (string) and print them
		for (String s1 : set1) {
			for (String s2 : set2) {
				if (s1.equals(s2)) {
					commonNGram.add(s1);
				}
			}
		}
		return commonNGram;
	}

}
