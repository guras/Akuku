package pl.guras.i1.model;

public class HighlightsLowlights {
	
	private String highlights, lowlights;

	public HighlightsLowlights(String highlights, String lowlights) {
		this.highlights = highlights;
		this.lowlights = lowlights;
	}

	public String getHighlights() {
		return highlights;
	}

	public String getLowlights() {
		return lowlights;
	}

	public void setHighlights(String highlights) {
		this.highlights = highlights;
	}

	public void setLowlights(String lowlights) {
		this.lowlights = lowlights;
	}
}