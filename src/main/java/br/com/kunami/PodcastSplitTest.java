package br.com.kunami;

public class PodcastSplitTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PodcastSplit podcastSplit = new PodcastSplit();
		podcastSplit.listPodcasts("../Multiverso DC » ComicPod");
		podcastSplit.listPodcasts("../dccast");
	}
}
