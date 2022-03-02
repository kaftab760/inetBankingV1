package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	public ExtentReports extent;
	public ExtentSparkReporter spark;
	public ExtentTest test;

	public void onStart(ITestContext testContext) {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time Stamp
		String repName = "Test-Report-" + timeStamp + ".html";

		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "\\test-output//" + repName);// specify
																										// location
		extent = new ExtentReports();
		extent.attachReporter(spark);

		try {
			spark.loadXMLConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
		} catch (IOException e) {
			e.printStackTrace();

		}
		
		extent.setSystemInfo("Host name", "local");
		extent.setSystemInfo("Envirement", "QA");
		extent.setSystemInfo("Tester Name", "Kaleem");

		spark.config().setDocumentTitle("InetBanking Test Project");// Title of report
		spark.config().setReportName("Functional Report Test Report");// name of report
		// spark.config().setTestViewChartLocation(ChartLocation.TOP); //location
		spark.config().setTheme(Theme.DARK);

	}

	public void onTestSuccess(ITestResult tr) {

		test = extent.createTest(tr.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));

	}

	public void onTestFailure(ITestResult tr) {
		test = extent.createTest(tr.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));

		String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + tr.getName() + ".png";

		File f = new File(screenshotPath);

		if (f.exists()) {
			test.fail("Screenshot is below:" + test.addScreenCaptureFromPath(screenshotPath));

		}
	}

	public void onTestSkipped(ITestResult tr) {
		test = extent.createTest(tr.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}

	public void onFinish(ITestContext testContext) {
		System.out.println("Finished");
		extent.flush();
	}
}
