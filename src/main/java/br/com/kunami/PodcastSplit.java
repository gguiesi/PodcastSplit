package br.com.kunami;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.StringTokenizer;

public class PodcastSplit {
	private static final int TEN_MEGABYTES = 10 * 1024 * 1024;

	public void split(String path) {
		File podcast = new File(path);
		String dir = getDirectoryName(podcast.getName());
		new File("result").mkdir();
		new File("result/"+dir).mkdir();
		int numberParts = (int) (podcast.length() / TEN_MEGABYTES) + 1;
		int size = (int) (podcast.length() / numberParts);
		System.out.printf("\tThe file will split in %d parts of %d MB\n", numberParts, size / 1024 / 1024);
		try {
			FileInputStream input = openFile(podcast);
			for (int i = 0; i < numberParts; i++) {
				byte[] part = new byte[size];
				input.read(part, 0, part.length);
				FileOutputStream output = new FileOutputStream("result/"+dir + "/"
						+ (i + 1) + "-" + podcast.getName());
				output.write(part);
				output.flush();
				output.close();
			}
		} catch (FileNotFoundException e) {
			System.err.print(e.getMessage());
		}
		// save in new hierarchy of directories
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String getDirectoryName(String path) {
		StringTokenizer dir = new StringTokenizer(path, ".");
		return dir.nextToken();
	}

	private FileInputStream openFile(File podcast) throws FileNotFoundException {
		FileInputStream input = new FileInputStream(podcast);
		return input;
	}

	public void listPodcasts(String path) {
		File[] files = new File(path).listFiles();
		System.out.printf("%d files to split\n", files.length);
		for (File file : files) {
			System.out.printf("split file: %s\n", file.getName());
			split(file.getAbsolutePath());
		}
		System.out.println("End of program.");
	}
}
