/**
 * 
 */
package org.mobile;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * 
 */
public class ReporterNG {
	
	public static ExtentReports getReport()
	{
		String path = System.getProperty("user.dir")+"//report/index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("LongPressTest");
		reporter.config().setDocumentTitle("MobileAppAutomation");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("TesterName", "Ashok Akurathi");
		return extent;
	}

}
