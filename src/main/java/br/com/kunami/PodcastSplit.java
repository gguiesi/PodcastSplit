package br.com.kunami;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PodcastSplit {
	private static final int TEN_MEGABYTES = 10 * 1024 * 1024;

	public void split(String path) {
		File podcast = new File(path);
		int numberParts = (int) (podcast.length() / TEN_MEGABYTES) + 1;
		int size = (int) (podcast.length() / numberParts);
		try {
			FileInputStream input = openFile(podcast);
			for (int i = 0; i < numberParts; i++) {
				byte[] part = new byte[size];
				input.read(part, 0, part.length);
				new File("split").mkdir();
				FileOutputStream output = new FileOutputStream("split/"
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

	private FileInputStream openFile(File podcast) throws FileNotFoundException {
		FileInputStream input = new FileInputStream(podcast);
		return input;
	}

	public void listPodcasts(String path) {
		File[] files = new File(path).listFiles();
		for (File file : files) {
			split(file.getAbsolutePath());
		}
	}
}
