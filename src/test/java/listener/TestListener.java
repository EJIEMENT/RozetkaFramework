package listener;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListener extends TestListenerAdapter {
    private final static Logger LOG = Logger.getLogger(TestListener.class);

    @Override
    public void onStart(ITestContext iTestContext) {
        LOG.info("\tTest Started...\n");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        LOG.info("\tTest has END");
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        LOG.info(new StringBuffer().append("Test method ").append(iTestResult.getName()).append(" started "));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LOG.info(setTestInfo(" PASSED", iTestResult));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        LOG.error(setTestInfo(" FAILED", iTestResult));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        LOG.error(setTestInfo(" SKIPPED", iTestResult));
    }

    private StringBuffer setTestInfo(String testInfo, ITestResult iTestResult) {
        return new StringBuffer().append("Test name: ")
                .append(iTestResult.getName())
                .append(testInfo);
    }
}