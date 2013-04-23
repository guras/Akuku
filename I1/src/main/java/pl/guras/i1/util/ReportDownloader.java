package pl.guras.i1.util;

import java.io.*;
import java.net.URL;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.*;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import pl.guras.i1.controllers.ReportController;

public class ReportDownloader {
	
	private static final Logger LOGGER = Logger.getLogger(ReportDownloader.class);
	
	private static final int END_OF_STREAM = -1;
	
	public static void downloadReport(HttpServletRequest request, HttpServletResponse response) {
		try {
			InputStream inputStream = openStreamToReportURL(request);
			setResponseParameters(response, inputStream);
			sendReportDataForDownload(response, inputStream);
		} catch (Exception exception) {
			LOGGER.error("An unexpected error has occured", exception);
		}
	}
	
	private static String getPathFromReportRequest(HttpServletRequest request) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(request.getScheme());
		buffer.append("://");
		buffer.append(request.getServerName());
		buffer.append(":");
		buffer.append(request.getServerPort());
		buffer.append(request.getContextPath());
		buffer.append("/");
		buffer.append(ReportController.WEEKLY_REPORT);
		buffer.append(";jsessionid=");
		buffer.append(request.getSession().getId());
		return buffer.toString();
	}
	
	private static InputStream openStreamToReportURL(HttpServletRequest request) throws Exception {
		URL url = new URL(getPathFromReportRequest(request));
		return url.openStream();
	}
	
	private static void setResponseParameters(HttpServletResponse response, InputStream inputStream) throws IOException {
		response.setHeader("Content-Disposition", "attachment; filename='GSE SDG Gdansk Team weekly report W" + new DateTime().weekOfWeekyear().get() + ".doc'");
		response.setContentType("application/msword");
		response.setContentLength(inputStream.available());
	}
	
	private static void sendReportDataForDownload(HttpServletResponse response, InputStream inputStream) throws IOException {
		ServletOutputStream outputStream = response.getOutputStream();
		int byteOfData;
		
		while ((byteOfData = inputStream.read()) != END_OF_STREAM) {
			outputStream.write(byteOfData);
		}
		
		outputStream.flush();
		outputStream.close();
		inputStream.close();
	}
}