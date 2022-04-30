package cz.cvut.fel.ts1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArticlePage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='main-content']/main/article/div[1]/header/h1")
    WebElement articleTitle;

    @FindBy(css = "#article-info-content > div > div:nth-child(2) > ul.c-bibliographic-information__list > li.c-bibliographic-information__list-item.c-bibliographic-information__list-item--doi > p > span.c-bibliographic-information__value")
    WebElement doiUrl;

    @FindBy(xpath = "//*[@id='main-content']/main/article/div[1]/header/ul[1]/li[2]/a/time")
    WebElement publishDate;


    public ArticlePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
