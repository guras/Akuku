package pl.guras.i1.util;

import java.util.*;
import pl.guras.i1.entity.*;
import pl.guras.i1.model.ProjectReportByEmployee;
import com.google.common.base.Function;
import com.google.common.collect.*;

public class ProjectColorGenerator {
	
	private static final ColorFunction COLOR_FUNCTION = new ColorFunction();
	
	public static String generateProjectColor(List<ProjectReportByEmployee> projectReports) {
		Multiset<Color> colors = EnumMultiset.create(Collections2.transform(projectReports, COLOR_FUNCTION));
		Color color = Collections.max(colors, new ColorComparator(colors));
		
		return color.getValue();
	}
	
	private static class ColorFunction implements Function<ProjectReportByEmployee, Color> {
		
		public Color apply(ProjectReportByEmployee projectReportByEmployee) {
			return projectReportByEmployee.getColor();
		}
	}
	
	private static class ColorComparator implements Comparator<Color> {
		
		private Multiset<Color> colors;
		
		public ColorComparator(Multiset<Color> colors) {
			this.colors = colors;
		}
		
		public int compare(Color color1, Color color2) {
			int count1 = colors.count(color1);
			int count2 = colors.count(color2);
			
			if (count1 == count2) {
				return color1.getPriority() - color2.getPriority();
			}
			
			return count1 - count2;
		}
	}
}