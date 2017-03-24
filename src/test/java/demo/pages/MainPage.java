package demo.pages;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;

public class MainPage extends BaseForm {

    private Button btnCatalog;

    public MainPage(String path) {
        super(By.className(path),"Main Page");
    }

    public void chooseCatalog(String path) {
        btnCatalog = new Button(By.xpath(path), "Button Catalog");
        btnCatalog.click();
    }
}
