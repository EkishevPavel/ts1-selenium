package cz.cvut.fel.ts1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class SearchResultPage {
    private WebDriver driver;

    @FindBy(xpath = "//span[.='Article']")
    WebElement selectContentTypeArticle;

    @FindBy(xpath = "//*[@id='results-list']/li[1]/h2/a")
    WebElement linkToFirstArticle;

    @FindBy(xpath = "//*[@id='results-list']/li[2]/h2/a")
    WebElement linkToSecondArticle;

    @FindBy(xpath = "//*[@id='results-list']/li[3]/h2/a")
    WebElement linkToThirdArticle;

    @FindBy(xpath = "//*[@id='results-list']/li[4]/h2/a")
    WebElement linkToFourthArticle;

    ArrayList<WebElement> linksToArticles;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        linksToArticles = new ArrayList<>();
        linksToArticles.add(linkToFirstArticle);
        linksToArticles.add(linkToSecondArticle);
        linksToArticles.add(linkToThirdArticle);
        linksToArticles.add(linkToFourthArticle);
    }
}
