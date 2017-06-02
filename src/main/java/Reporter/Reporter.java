package Reporter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Reporter {

    private final static Logger logger = LoggerFactory.getLogger(Reporter.class);

    public void result(Object expectedResult, Object actualResult) {
        boolean assertReviews = expectedResult.equals(actualResult);
        String msg = "\n[%s]: \n" +
                "\tExpected  - " + expectedResult + "\n" +
                "\tActual    - " + actualResult + "\n";
        if (assertReviews){
            logger.info(String.format(msg, "PASSED"));
        }else{
            logger.info(String.format(msg, "FAILED"));
        }
    }
}
