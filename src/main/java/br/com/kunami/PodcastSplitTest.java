package br.com.kunami;

public class PodcastSplitTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PodcastSplit podcastSplit = new PodcastSplit();
		podcastSplit.listPodcasts("/Users/guiesi/Music/iTunes/iTunes Media/Podcasts");
		System.out.println("\nEnd of program.");
	}
}
