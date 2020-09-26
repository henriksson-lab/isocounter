/**
 * A range object, representing an exon or similar
 * 
 * @author Johan Henriksson
 *
 */
public class Range {
	String source;
	int from, to; //inclusive
	
	public Range(String source, int from, int to) {
		this.source = source;
		this.from = from;
		this.to = to;
	}
	
	
}
