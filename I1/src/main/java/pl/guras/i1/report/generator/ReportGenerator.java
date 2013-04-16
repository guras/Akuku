package pl.guras.i1.report.generator;

import static pl.guras.i1.report.generator.ReportGenerator.StyleId.*;
import java.io.File;
import java.math.BigInteger;
import java.net.URL;
import java.util.List;
import org.docx4j.convert.in.xhtml.XHTMLImporter;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.*;

public class ReportGenerator {
	
	private static final BooleanDefaultTrue BOOLEAN_DEFAULT_TRUE = new BooleanDefaultTrue();
	
	public static class StyleId {
		
		public static final String DEFAULT = "default";
		
		public static final String TITLE = "title";
		
		public static final String HIGHLIGHTS = "highlights";
		
		public static final String LOWLIGHTS = "lowlights";
		
		public static final String TEAM = "team";
		
		public static final String PROJECTS = "projects";
		
		public static final String PROJECT_NAME = "projectName";
	}
	
	public static void main(String[] args) throws Exception {
		WordprocessingMLPackage wmlPackage = WordprocessingMLPackage.createPackage();
		wmlPackage.getMainDocumentPart().getContent().addAll(XHTMLImporter.convert(new URL("http://localhost:8080/I1-1.0-SNAPSHOT/report"), wmlPackage));
		wmlPackage.save(new File("C:/szkolenie/test.docx"));
	}
	
	private void addColor(String value, RPr rpr) {
		Color color = new Color();
		color.setVal(value);
		rpr.setColor(color);
	}
	
	private void addFont(String value, RPr rpr) {
		RFonts rFonts = new RFonts();
        rFonts.setAscii(value);
        rFonts.setHAnsi(value);
        rpr.setRFonts(rFonts);
	}
	
	private void addSize(int value, RPr rpr) {
		HpsMeasure size = new HpsMeasure();
        size.setVal(BigInteger.valueOf(value * 2));
        rpr.setSz(size);
	}
	
	private void addTextAlignment(JcEnumeration jcEnumeration, PPr ppr) {
		Jc jc = new Jc();
		jc.setVal(jcEnumeration);
		ppr.setJc(jc);
	}
	
	private void addBold(RPr rpr) {
		rpr.setB(BOOLEAN_DEFAULT_TRUE);
	}
	
	private void addUnderline(RPr rpr) {
		U u = new U();
		u.setVal(UnderlineEnumeration.SINGLE);
		rpr.setU(u);
	}
	
	private void addTextHighlight(String color, RPr rpr) {
		Highlight highlight = new Highlight();
		highlight.setVal(color);
		
		rpr.setHighlight(highlight);
	}
	
	private Style createStyle(String id, RPr rpr, PPr ppr) {
		Style style = new Style();
		style.setStyleId(id);
		style.setRPr(rpr);
		style.setPPr(ppr);
		
		return style;
	}
	
	private void addDefaultStyle(List<Style> styles) {
		RPr rpr = new RPr();
		
		addFont("Calibri", rpr);
		addSize(11, rpr);
		
		styles.add(createStyle(DEFAULT, rpr, null));
	}
	
	private void addTitleStyle(List<Style> styles) {
		RPr rpr = new RPr();
		PPr ppr = new PPr();
		
		addFont("Tahoma", rpr);
		addSize(14, rpr);
		addColor("#993366", rpr);
		addBold(rpr);
		addTextAlignment(JcEnumeration.CENTER, ppr);
		
		styles.add(createStyle(TITLE, rpr, ppr));
	}
	
	private void addColoredTextStyle(String fontColor, String styleId, List<Style> styles) {
		RPr rpr = new RPr();
		
		addFont("Calibri", rpr);
		addSize(14, rpr);
		addColor(fontColor, rpr);
		addBold(rpr);
		
		styles.add(createStyle(styleId, rpr, null));
	}
	
	private void addLowlightsStyle(List<Style> styles) {
		addColoredTextStyle("#FF0000", LOWLIGHTS, styles);
	}
	
	private void addHighlightsStyle(List<Style> styles) {
		addColoredTextStyle("#32CD32", HIGHLIGHTS, styles);
	}
	
	private void addTeamStyle(List<Style> styles) {
		addColoredTextStyle("#48D1CC", TEAM, styles);
	}
	
	private void addProjectsStyle(List<Style> styles) {
		addColoredTextStyle("#000000", PROJECTS, styles);
	}
	
	private void addProjectNameStyle(String highlightColor, List<Style> styles) {
		RPr rpr = new RPr();
		
		addFont("Calibri", rpr);
		addSize(11, rpr);
		addBold(rpr);
		addUnderline(rpr);
		addTextHighlight(highlightColor, rpr);
		
		styles.add(createStyle(PROJECT_NAME, rpr, null));
	}
}