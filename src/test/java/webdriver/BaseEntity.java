package webdriver;


import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static org.testng.AssertJUnit.assertTrue;


/**
 * BaseEntity
 */
public abstract class BaseEntity {

    protected static int stepNumber = 1;
    protected static Logger logger = Logger.getInstance();
    protected static Browser browser = Browser.getInstance();
    protected ITestContext context;

    private String xpathOfckbFirmOnResultsPage;
    private String xpathOftxbPriceOnResultPage;
    private String xpathOftxbYearOnResultPage;
    private String xpathOfcmbDiagonalFromOnResultPage;
    private String xpathOfcmbDiagonalToOnResultPage;
    private String xpathOfbtnGoToListTVPageOnCatalogPage;
    private String classNameOfCataogPage;
    private String valueOfPrice;
    private String valueOfYear;
    private String valueOfDiagonalFrom;
    private String valueOfDiagonalTo;
    private String valueOfFirm;
    private String classNameOfTVPage;
    private String classNameOftxbFirmOnTVPage;
    private String ClassNameOftxbPriceOnTVPage;
    private String ClassNameOftxbYearOnTVPage;
    private String xpathOfDiagonalOnTVPage;
    private String xpathbtnGoToCatalog;
    private String classNameOfMainPage;
    private String classNameOfResultPage;
    private String openTV;

    /**
     * Get locale
     *
     * @param key key
     * @return value
     */
    protected static String getLoc(final String key) {
        return Logger.getLoc(key);
    }

    // ==============================================================================================
    // Methods for logging

    /**
     * Logging a step number.
     *
     * @param step - step number
     */
    public static void logStep(final int step) {
        logger.step(step);
    }

    /**
     * Format message.
     *
     * @param message message
     * @return null
     */
    protected abstract String formatLogMsg(String message);

    /**
     * Informative message.
     *
     * @param message Message
     */
    protected void info(final String message) {
        logger.info(formatLogMsg(message));
    }

    /**
     * Warning.
     *
     * @param message Message
     */
    protected void warn(final String message) {
        logger.warn(formatLogMsg(message));
    }

    /**
     * Error message without stopping the test.
     *
     * @param message Message
     */
    protected void error(final String message) {
        logger.error(formatLogMsg(message));
    }

    /**
     * Fatal error message.
     *
     * @param message Message
     */
    protected void fatal(final String message) {
        logger.fatal(formatLogMsg(message));
        assertTrue(formatLogMsg(message), false);
    }

    /**
     * Logging a several steps in a one action
     *
     * @param fromStep - the first step number to be logged
     * @param toStep   - the last step number to be logged
     */
    public void logStep(final int fromStep, final int toStep) {
        logger.step(fromStep, toStep);
    }

    // ==============================================================================================
    // Asserts

    /**
     * Universal method
     *
     * @param isTrue  Condition
     * @param passMsg Positive message
     * @param failMsg Negative message
     */
    public void doAssert(final Boolean isTrue, final String passMsg,
                         final String failMsg) {
        if (isTrue) {
            info(passMsg);
        } else {
            fatal(failMsg);
        }
    }

    /**
     * Assert Objects are Equal
     *
     * @param expected Expected Value
     * @param actual   Actual Value
     */
    public void assertEquals(final Object expected, final Object actual) {
        if (!expected.equals(actual)) {
            fatal("Expected value: '" + expected + "', but was: '" + actual
                    + "'");
        }
    }


    /**
     * Assert Objects are Equal
     *
     * @param message  Fail Message
     * @param expected Expected Value
     * @param actual   Actual Value
     */
    public void assertEquals(final String message, final Object expected,
                             final Object actual) {
        if (!expected.equals(actual)) {
            fatal(message);
        }
    }

    /**
     * Before Class method
     */

    @Parameters({"xpathOfckbFirmOnResultsPage", "xpathOftxbPriceOnResultPage", "xpathOftxbYearOnResultPage",
    "xpathOfcmbDiagonalFromOnResultPage", "xpathOfcmbDiagonalToOnResultPage", "xpathOfbtnGoToListTVPageOnCatalogPage",
    "classNameOfCataogPage", "valueOfPrice", "valueOfDiagonalFrom", "valueOfDiagonalTo", "valueOfYear",
    "valueOfFirm", "classNameOfTVPage", "classNameOftxbFirmOnTVPage", "ClassNameOftxbPriceOnTVPage",
            "ClassNameOftxbYearOnTVPage", "xpathOfDiagonalOnTVPage", "xpathbtnGoToCatalog",
            "classNameOfMainPage", "classNameOfResultPage", "openTV"})
    @BeforeClass
    public void before(ITestContext context, String xpathOfckbFirmOnResultsPage, String xpathOftxbPriceOnResultPage,
                       String xpathOftxbYearOnResultPage, String xpathOfcmbDiagonalFromOnResultPage,
                       String xpathOfcmbDiagonalToOnResultPage, String xpathofbtnGoToListTVPageOnCatalogPage, String classNameOfCataogPage, String valueOfPrice,
                       String valueOfDiagonalFrom,String valueOfDiagonalTo, String valueOfYear, String valueOfFirm,
                       String classNameOfTVPage, String classNameOftxbFirmOnTVPage, String ClassNameOftxbPriceOnTVPage,
                       String ClassNameOftxbYearOnTVPage, String xpathOfDiagonalOnTVPage, String xpathbtnGoToCatalog,
                       String classNameOfMainPage, String classNameOfResultPage, String openTV) {
        this.context = context;
        browser = Browser.getInstance();
        browser.windowMaximise();
        stepNumber = 1;
        this.xpathOfckbFirmOnResultsPage = xpathOfckbFirmOnResultsPage;
        this.xpathOftxbPriceOnResultPage = xpathOftxbPriceOnResultPage;
        this.xpathOftxbYearOnResultPage = xpathOftxbYearOnResultPage;
        this.xpathOfcmbDiagonalFromOnResultPage = xpathOfcmbDiagonalFromOnResultPage;
        this.xpathOfcmbDiagonalToOnResultPage = xpathOfcmbDiagonalToOnResultPage;
        this.xpathOfbtnGoToListTVPageOnCatalogPage = xpathofbtnGoToListTVPageOnCatalogPage;
        this.classNameOfCataogPage = classNameOfCataogPage;
        this.valueOfPrice = valueOfPrice;
        this.valueOfDiagonalFrom = valueOfDiagonalFrom;
        this.valueOfDiagonalTo = valueOfDiagonalTo;
        this.valueOfYear = valueOfYear;
        this.valueOfFirm = valueOfFirm;
        this.classNameOfTVPage = classNameOfTVPage;
        this.classNameOftxbFirmOnTVPage = classNameOftxbFirmOnTVPage;
        this.ClassNameOftxbPriceOnTVPage = ClassNameOftxbPriceOnTVPage;
        this.ClassNameOftxbYearOnTVPage = ClassNameOftxbYearOnTVPage;
        this.xpathOfDiagonalOnTVPage = xpathOfDiagonalOnTVPage;
        this.xpathbtnGoToCatalog = xpathbtnGoToCatalog;
        this.classNameOfMainPage = classNameOfMainPage;
        this.classNameOfResultPage = classNameOfResultPage;
        this.openTV = openTV;
    }

    public String getOpenTV() {
        return openTV;
    }

    public String getClassNameOfResultPage() {
        return classNameOfResultPage;
    }

    public String getClassNameOfMainPage() {
        return classNameOfMainPage;
    }

    public String getXpathbtnGoToCatalog() {
        return xpathbtnGoToCatalog;
    }

    public String getXpathOfDiagonalOnTVPage() {
        return xpathOfDiagonalOnTVPage;
    }

    public String getClassNameOftxbYearOnTVPage() {
        return ClassNameOftxbYearOnTVPage;
    }

    public String getClassNameOftxbPriceOnTVPage() {
        return ClassNameOftxbPriceOnTVPage;
    }

    public String getClassNameOftxbFirmOnTVPage() {
        return classNameOftxbFirmOnTVPage;
    }

    public String getClassNameOfTVPage() {
        return classNameOfTVPage;
    }

    public String getValueOfFirm() {
        return valueOfFirm;
    }

    public String getXpathOftxbPriceOnResultPage() {
        return xpathOftxbPriceOnResultPage;
    }

    public String getXpathOftxbYearOnResultPage() {
        return xpathOftxbYearOnResultPage;
    }

    public String getXpathOfcmbDiagonalFromOnResultPage() {
        return xpathOfcmbDiagonalFromOnResultPage;
    }

    public String getXpathOfcmbDiagonalToOnResultPage() {
        return xpathOfcmbDiagonalToOnResultPage;
    }

    public String getXpathOfbtnGoToListTVPageOnCatalogPage() {
        return xpathOfbtnGoToListTVPageOnCatalogPage;
    }

    public String getClassNameOfCataogPage() {
        return classNameOfCataogPage;
    }

    public String getValueOfPrice() {
        return valueOfPrice;
    }

    public String getValueOfYear() {
        return valueOfYear;
    }

    public String getValueOfDiagonalFrom() {
        return valueOfDiagonalFrom;
    }

    public String getValueOfDiagonalTo() {
        return valueOfDiagonalTo;
    }

    public static Browser getBrowser() {
        return browser;
    }

    public String getXpathOfckbFirmOnResultsPage(){
        return xpathOfckbFirmOnResultsPage;
    }
    /**
     * Close browser after each test Class
     */
    @AfterClass
    public void after() {

        if (browser.isBrowserAlive()) {
            browser.exit();
        }
    }

    /**
     * Logging steps
     */
    protected void logStep() {
        logStep(stepNumber++);
    }

    /**
     * Logging steps with info
     */
    protected void logStep(final String info) {
        logStep(stepNumber++);
        logger.info(String.format("----==[ %1$s ]==----", info));
    }


}
