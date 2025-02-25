package customReport;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CustomHTMLReporter implements IReporter {

	int passedNumber,failedNumber,skippedNumber= 0;

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		StringBuilder report = new StringBuilder();

		// Add HTML and CSS Styling
		  report.append("<html><head><title>Custom TestNG Report</title>")
				.append("<style>")
				.append(" * {margin: 0; border: 0; box-sizing: border-box;font-family: Candara;word-wrap: break-word}")
				.append("body { font-family: Arial, sans-serif; background-color: #FAF9F6; }")
				.append("h1,h2 { margin-top: 5px;text-align: center; padding-bottom: 10px; }")
				.append("#ma{color: #303AB2}")
				.append("#x{color: #e4002b}")
				.append("h2{padding: 5px}")
				.append(".passed{color: #2ecc71}")
				.append(".failed{color: #e86354}")
				.append(".skipped{color: #f8be60}")
				.append("table{ width: 100%;border-collapse: collapse;border: 1px solid #ddd;margin: 2px;}")
				.append("tr{border: 1px solid #ddd;}")
				.append(".passed_table{background-color: #2ecc71;}")
				.append(".failed_table{background-color: #e86354;}")
				.append(".skipped_table{background-color: #f8be60;}")
				.append("th,td,tr{padding: 5px;color: black;font-size: 18px;}")
				.append("tr th{width:15px;}")
				.append("td{font-size:12px}")
				.append("td{text-align:center;font-size: 18px;}")
				.append(".total{color: #303AB2;font-size:35px;font-weight:bold}")
				.append(".pass{color: #2ecc71;font-size:35px;font-weight:bold}")
				.append(".fail{color: #e86354;;font-size:35px;font-weight:bold}")
				.append(".skip{color: #f8be60;;font-size:35px;font-weight:bold}")
				.append("#table-data:nth-child(even){ background-color: #f2f2f2;}")
				.append(".logs{text-align: left;padding-left:35px}")
				.append("</style>")
				.append("</head><body>");

		report.append("<h1><span id='ma'>Ma<span id='x'>x</span></span> - TestNG Report</h1>");

		// Test Suite Summary Table
		report.append("<h2>Test Summary</h2>")
		      .append("<table><tr><th>Group Name</th><th>Total Tests Count</th><th>Passed Count</th><th>Failed Count</th><th>Skipped Count</th><th>Start Time</th><th>End Time</th><th>Total Time (s)</th></tr>");

		for (ISuite suite : suites) {
			for (ISuiteResult result : suite.getResults().values()) {
				ITestContext context = result.getTestContext();
				double totalTimeInSeconds = (context.getEndDate().getTime() - context.getStartDate().getTime())/1000.0;
				passedNumber = context.getPassedTests().size();
				failedNumber = context.getFailedTests().size();
				skippedNumber = context.getSkippedTests().size();

				// Get group names
				String[] groups = context.getAllTestMethods()[0].getGroups();
				String groupNames = String.join(", ", groups);

				  report.append("<tr><td>").append(groupNames).append("</td>").append("<td class='total'>")
						.append(context.getAllTestMethods().length).append("</td>").append("<td class='pass'>").append(passedNumber)
						.append("</td>").append("<td class='fail'>").append(failedNumber).append("</td>").append("<td class='skip'>")
						.append(skippedNumber).append("</td>").append("<td>").append(formatDate(context.getStartDate()))
						.append("</td>").append("<td>").append(formatDate(context.getEndDate())).append("</td>")
						.append("<td>").append(totalTimeInSeconds).append(" s</td></tr>");
			}
		}
		report.append("</table>");

		// Passed Test Cases Table
		if (passedNumber >= 1) {
			report.append("<h2 class='passed'>Passed Test Methods</h2>")
			      .append("<table><tr class='passed_table'><th id='test'>Test Case</th><th>Start Time</th><th>End Time</th><th>Duration (s)</th><th>Logs and Screenshots</th></tr>");
		}
			for (ISuite suite : suites) {
				for (ISuiteResult result : suite.getResults().values()) {
					ITestContext context = result.getTestContext();
					for (ITestResult test : context.getPassedTests().getAllResults()) {
						report.append(createTestRow(test, "Passed"));
					}
				}
			}
			report.append("</table>");

		// Failed Test Cases Table
		if (failedNumber >= 1) {
			report.append("<h2 class='failed'>Failed Test Methods</h2>")
			      .append("<table><tr class='failed_table'><th  id='test'>Test Case</th><th>Start Time</th><th>End Time</th><th id='error'>Error Message</th><th>Logs and Screenshots</th></tr>");
		}
		for (ISuite suite : suites) {
			for (ISuiteResult result : suite.getResults().values()) {
				ITestContext context = result.getTestContext();
				for (ITestResult test : context.getFailedTests().getAllResults()) {
					report.append(createTestRow(test, "Failed"));
				}
			}
		}
		report.append("</table>");

		// Skipped Test Cases Table
		if (skippedNumber >= 1) {
			report.append("<h2 class='skipped'>Skipped Test Methods</h2>")
			.append("<table><tr  class='skipped_table'><th>Test Case</th></tr>");
		}
		for (ISuite suite : suites) {
			for (ISuiteResult result : suite.getResults().values()) {
				ITestContext context = result.getTestContext();
				for (ITestResult test : context.getSkippedTests().getAllResults()) {
					report.append(createTestRowSkipped(test, "Skipped"));
				}
			}
		}
		report.append("</table>");

		report.append("</body></html>");

		// Save Report to File
		try {
			File reportFile = new File(outputDirectory + "/CustomTestReport.html");
			FileWriter writer = new FileWriter(reportFile);
			writer.write(report.toString());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Formats Date to Readable String
	private String formatDate(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}

	// Fetches logs for a test case
	private String getLogs(ITestResult result) {
        StringBuilder logs = new StringBuilder();
        List<String> logEntries = Reporter.getOutput(result);
 
       
        if (logEntries != null && !logEntries.isEmpty()) {
            logs.append("<ol>");  
            for (String log : logEntries) {
                logs.append("<li>").append(log.replaceAll("\n", "<br>")).append("</li>");  // Wrap each log in <li> and replace new lines with <br>
            }
            logs.append("</ol>");  
        } else {
            logs.append("No Logs");
        }
        return logs.toString();
    }
	
	// Creates Row for Test Case with Execution Time in Seconds
	private String createTestRow(ITestResult result, String status) {
		double durationInSeconds = ((result.getEndMillis() - result.getStartMillis())) / 1000.0;
		String errorMsg = status.equals("Failed") ? result.getThrowable().getMessage() : "";

		// CSS class based on status
		String rowClass = status.equals("Passed") ? "passed" : status.equals("Failed") ? "failed" : "skipped";

		// Fetch logs and screenshot path
		String logs = getLogs(result);

		return "<tr class='" + rowClass + "'><td>" + result.getName() + "</td>" + "<td>"
				+ formatDate(new Date(result.getStartMillis())) + "</td>" + "<td>"
				+ formatDate(new Date(result.getEndMillis())) + "</td>" + "<td>"
				+ (status.equals("Failed") ? errorMsg :  durationInSeconds + " s") + "</td>" + "<td class='logs'>" + logs + "</td>";
	}
	
	
	private String createTestRowSkipped(ITestResult result, String status) {

		// CSS class based on status
		String rowClass = status.equals("Skipped") ? "skipped" : "";

		return "<tr class='" + rowClass + "' id='table-data'><td>" + result.getName() + "</td>";
	}
}