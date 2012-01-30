package br.com.kunami;

public class PodcastSplitTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PodcastSplit podcastSplit = new PodcastSplit();
		podcastSplit.listPodcasts("/Users/geraldo.junior/Music/iTunes/iTunes Media/Podcasts");
		System.out.println("\nEnd of program.");
	}
}
