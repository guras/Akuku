package pl.guras.i1.report.generator;

import java.io.File;
import java.net.URL;
import org.docx4j.convert.in.xhtml.XHTMLImporter;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

public class ReportGenerator {
	
	public static void main(String[] args) throws Exception {
		WordprocessingMLPackage wmlPackage = WordprocessingMLPackage.createPackage();
		wmlPackage.getMainDocumentPart().getContent().addAll(XHTMLImporter.convert(new URL("http://localhost:8080/I1-1.0-SNAPSHOT/report"), wmlPackage));
		wmlPackage.save(new File("C:/szkolenie/test.docx"));
	}
}