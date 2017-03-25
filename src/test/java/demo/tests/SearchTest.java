package demo.tests;

import demo.pages.CatalogPage;
import demo.pages.MainPage;
import demo.pages.ResultsPage;
import demo.pages.TVPage;
import org.openqa.selenium.WebElement;
import webdriver.BaseTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchTest extends BaseTest {

      @Override
    public void runTest(){
          logStep();
          MainPage mainPage = new MainPage(getClassNameOfMainPage());
          mainPage.assertIsOpen();
          mainPage.chooseCatalog(getXpathbtnGoToCatalog());

          logStep();
          CatalogPage catalogPage = new CatalogPage(getClassNameOfCataogPage());
          catalogPage.chooseTV(getXpathOfbtnGoToListTVPageOnCatalogPage());

          logStep();
          ResultsPage resultsPage = new ResultsPage(getClassNameOfResultPage());
          resultsPage.chooseFirm(getXpathOfckbFirmOnResultsPage());
          resultsPage.choosePrise(getValueOfPrice(), getXpathOftxbPriceOnResultPage());
          resultsPage.chooseYear(getValueOfYear(), getXpathOftxbYearOnResultPage());
          resultsPage.chooseDiagonalFrom(getValueOfDiagonalFrom(), getXpathOfcmbDiagonalFromOnResultPage());
          resultsPage.chooseDiagonalTo(getValueOfDiagonalTo(), getXpathOfcmbDiagonalToOnResultPage());
          getBrowser().waitForPageToLoad();
          List<WebElement> list = resultsPage.getListOfTV("//div[@class = 'schema-product__title']/a");
          int size = list.size();
          size++;
          logStep();
          for(int i =1; i<size;i++){
              if(i == 3)
                  i++;
              getBrowser().getDriver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
              resultsPage.openTV("//div[@class = 'schema-product__group' and position()=" + i + "]//a");
              getBrowser().waitForPageToLoad();
              TVPage tvPage = new TVPage(getClassNameOfTVPage());
              tvPage.searchFirm(getValueOfFirm(), getClassNameOftxbFirmOnTVPage());
              tvPage.searchPrice(getValueOfPrice(), getClassNameOftxbPriceOnTVPage());
              tvPage.searchYear(getValueOfYear(), getClassNameOftxbYearOnTVPage());
              tvPage.searchDiagonal(getValueOfDiagonalFrom(), getValueOfDiagonalTo(), getXpathOfDiagonalOnTVPage());
              getBrowser().getDriver().navigate().back();
          }
    }
}
