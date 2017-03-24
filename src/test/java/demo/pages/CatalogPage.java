package demo.pages;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;

/**
 * Created by user on 18.03.2017.
 */
public class CatalogPage extends BaseForm {
    private Button btnGoToListTVPage;

    public CatalogPage(String path){
        super(By.className(path), "Catalog Page");
    }

    public void chooseTV(String path){
        btnGoToListTVPage = new Button(By.xpath(path), "Go to List TV");
        btnGoToListTVPage.waitForIsElementPresent();
        btnGoToListTVPage.click();
    }
}
