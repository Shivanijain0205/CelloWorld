package listnerUtility;

import testBase.WebTestBase;

import java.io.IOException;

public class ListenerUtility extends WebTestBase implements IRetryAnalyzer {
    private int retryCount = 0;
    private int maxCount = 1;

    public ListenerUtility() throws IOException {
    }

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (retryCount < maxCount){
            retryCount++;
            return true;
        }
        return false;
}
}