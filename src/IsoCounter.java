import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class IsoCounter {

	/**
	 * Main function
	 */
	public static void main(String[] args) throws IOException {
		
		//File fFeatures=new File("/beagle/big/debojyoti/HUMAN_SARS_229E_OC43/lib1/outs/filtered_feature_bc_matrix/features.tsv.gz");
		//ArrayList<String> listFeatures=readZipList(fFeatures);
		
		File fGTF=new File("/home/mahogny/umeå/project/isoform/refgenome/Homo_sapiens.GRCh38.101.chr.gff3");
		File f10x=new File("/beagle/big/henriksson/tonsil");
	//		File f10x=new File("/beagle/big/debojyoti/HUMAN_SARS_229E_OC43/lib1/outs");
		if(args.length>0) {
			fGTF=new File(args[0]);
			f10x=new File(args[1]);
		}
	
	
		//scp rackham.uppmax.uu.se:/home/mahogny/mystore/dataset/tonsil_sc/aligned/SRR11816791/outs/possorted_genome_bam.bam
		File fBarcodes=new File(f10x, "filtered_feature_bc_matrix/barcodes.tsv.gz");
		File fBAM=new File(f10x, "possorted_genome_bam.bam");
		
		ArrayList<String> listBarcodes=SplitGtf.readZipList(fBarcodes);
	
		
		//File outdir=new File("./out");
		//outdir.mkdirs();
		//ystem.out.println("To: "+outdir);
		
		ArrayList<CountRange> features=new SplitGtf().splitGTF(fGTF);
		
		System.out.println("Performing the counting: "+fBAM);
		CountBAM cb=new CountBAM(features, listBarcodes);
		cb.countReads(fBAM);
		
		System.out.println("Storing the counts");
		File fCountDir=new File("/home/mahogny/umeå/project/isoform/newcount");
		cb.writeMatrix(fCountDir);
	
	}
	
}
