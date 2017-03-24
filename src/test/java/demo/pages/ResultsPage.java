package demo.pages;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.CheckBox;
import webdriver.elements.ComboBox;
import webdriver.elements.TextBox;

public class ResultsPage extends BaseForm {
    private CheckBox ckbFirm;
    private TextBox txbPrice;
    private TextBox txbYear;
    private ComboBox cmbDiagonalFrom;
    private ComboBox cmbDiagonalTo;

    public ResultsPage(String path){
        super(By.className(path), "Results Page");
    }

    public void chooseFirm(String path){
        ckbFirm = new CheckBox(By.xpath(path), "Firm");
        ckbFirm.waitForIsElementPresent();
        ckbFirm.check();
    }

    public void choosePrise(String price, String path){
        txbPrice = new TextBox(By.xpath(path), "Price");
        txbPrice.waitForIsElementPresent();
        txbPrice.setText(price);
    }

    public void chooseYear(String year, String path){
        txbYear = new TextBox(By.xpath(path), "Year");
        txbYear.waitForIsElementPresent();
        txbYear.setText(year);
    }

    public void chooseDiagonalFrom(String value, String path){
        cmbDiagonalFrom = new ComboBox(By.xpath(path), "Diagonal from");
        cmbDiagonalFrom.waitForIsElementPresent();
        cmbDiagonalFrom.selectItem(value);
    }

    public void chooseDiagonalTo(String value, String path){
        cmbDiagonalTo = new ComboBox(By.xpath(path), "Diagonal to");
        cmbDiagonalTo.waitForIsElementPresent();
        cmbDiagonalTo.selectItem(value);
    }
    public void openTV(String path){
        Button btnGoToTV = new Button(By.xpath(path), "itemTV");
        btnGoToTV.waitForIsElementPresent();
        btnGoToTV.click();
    }

}
