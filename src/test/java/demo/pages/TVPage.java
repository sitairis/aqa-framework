package demo.pages;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.TextBox;

public class TVPage extends BaseForm {

    public TVPage(String path){
        super(By.className(path), "TV");
    }

    public boolean searchFirm(String firm, String path){
        TextBox txbFirm = new TextBox(By.className(path),"Firm");
        String nameFirmTV = txbFirm.getText();
        info(getLoc("Firm coincides"));
        return (nameFirmTV.toLowerCase()).contains(firm.toLowerCase());
    }

    public boolean searchPrice(String price, String path){
        TextBox txtPrice = new TextBox(By.xpath(path), "Price");
        String [] prTv = txtPrice.getElement().getText().split("\\d");
        info(getLoc("Price coincides"));
        return prTv[0].equals(price);
    }

    public boolean searchYear(String year, String path){
        TextBox txbYear = new TextBox(By.xpath(path), "Year");
        String[] yearOfTV = txbYear.getText().split("\\d");
        info(getLoc("Year coincides"));
        return year.equals(yearOfTV[0]);
    }

    public boolean searchDiagonal(String diagonalFrom, String diagonalTo, String path){
        TextBox txbDiagonal = new TextBox(By.xpath(path), "Diagonal");
        String[] diagonalOfTV = txbDiagonal.getText().split("\\d");
        info(getLoc("Diagonal coincides"));
        return diagonalFrom.equals(diagonalOfTV[0]+"0") && diagonalTo.equals(diagonalOfTV[0]);
    }
}
