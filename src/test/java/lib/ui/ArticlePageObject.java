package lib.ui;

import lib.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject
{
    protected static String
        TITLE,
        TITLE_BY_NAME_TMP,
        FOOTER_ELEMENT,
        OPTIONS_BUTTON,
        OPTiONS_ADD_TO_MY_LIST_BUTTON,
        OPTiONS_ADD_TO_MY_LIST_BUTTON_WHEN_USER_NO_LOGIN,
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
        ADD_TO_MY_LIST_OVERLAY,
        MY_LIST_NAME_INPUT,
        MY_LIST_OK_BUTTON,
        CLOSE_ARTICLE_BUTTON,
        SEARCH_BUTTON,
        FOLDER_BY_NAME_TPL,
        GO_TO_MAIN_PAGE_BUTTON,
        OPTiONS_ADD_TO_MY_LIST_BUTTON_AFTER_REMOVING,
        ARTICLE_PAGE_ACTION_MENU,
        NAVIGATION_BAR;

    public ArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getFolderNameToSavingElement(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getTitleLocatorByTitleName(String title_name)
    {
        return TITLE_BY_NAME_TMP.replace("{TITLE_NAME}", title_name);
    }
    /* TEMPLATES METHODS */

    public WebElement waitForTitleElement()
    {
        if (Platform.getInstance().isMW()) {
            waitForElementPresent(ARTICLE_PAGE_ACTION_MENU, "Cannot find add to my list button");
        }
        return this.waitForElementPresent(TITLE, "Cannot find article title on the page", 15);
    }

    public String getArticleTitle()
    {
        waitForCloseArticleButton();
        WebElement title_element = waitForTitleElement();
        if (Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("text");
        } else if (Platform.getInstance().isIOS()) {
            return title_element.getAttribute("name");
        } else {
            return title_element.getText();
        }
    }

    public WebElement waitForCloseArticleButton()
    {
        return this.waitForElementPresent(CLOSE_ARTICLE_BUTTON, "Cannot find close article button on the page", 15);
    }

    public void swipeToFooter()
    {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Cannot find the end of the article",
                    80
            );
        } else if (Platform.getInstance().isIOS()){
            this.swipeUpTillElementAppear(
                    FOOTER_ELEMENT,
                    "Cannot find the end of the article",
                    40);
        } else {
            this.scrollWebPageTillElementNotVisible(
                    FOOTER_ELEMENT,
                    "Cannot find the end of the article",
                    40
            );
        }

    }

    public void addArticleToMyFirstList(String name_of_folder)
    {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );

        this.waitForElementAndClick(
                OPTiONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option to add article to reading list",
                5
        );

        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Cannot find 'Got it' tip overlay",
                5
        );

        this.waitForElementAndClear(
                MY_LIST_NAME_INPUT,
                "Cannot find input to set name of articles folder",
                5
        );

        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot put text into articles folder input",
                5
        );

        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot press 'ok' button",
                5
        );
    }

    public void closeArticle()
    {

        this.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON,
                "Cannot close article, cannot find 'x' link",
                5
        );
    }

    public void initSearchInput()
    {
        this.waitForElementAndClick(
                SEARCH_BUTTON,
                "Cannot find search button in article",
                5
        );
    }

    public void addArticleToMyExistigList(String name_of_folder)
    {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );

        this.waitForElementAndClick(
                OPTiONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option to add article to reading list",
                5
        );

        this.waitForElementAndClick(
                getFolderNameToSavingElement(name_of_folder),
                "Cannot find '" + name_of_folder + "' folder for adding article to it",
                5
        );
    }

    public void addArticlesToMySaved()
    {
        if (Platform.getInstance().isMW()) {
            this.removeArticleFromSavedIfItAdded();
        } else {
            this.waitForElementAndClick(OPTiONS_ADD_TO_MY_LIST_BUTTON,
                    "Cannot find option to add article to reading list", 15);
        }
    }

    public void clickToAddToMyListArticleButton()
    {
        this.waitForElementAndClick(
                OPTiONS_ADD_TO_MY_LIST_BUTTON_WHEN_USER_NO_LOGIN,
                "Cannot click on add to my article list button to open login form",
                5);
    }

    public void removeArticleFromSavedIfItAdded()
    {
        if (this.isElementPresent(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON)) {
            this.waitForElementAndClick(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
                    "Cannot click button to remove an article from saved",
                    1);
            this.waitForElementAndClick(OPTiONS_ADD_TO_MY_LIST_BUTTON_AFTER_REMOVING,
                    "Cannot click button to add an article to saved list after removing it from this list before",
                    1);
        } else {
            this.waitForElementAndClick(OPTiONS_ADD_TO_MY_LIST_BUTTON,
                    "Cannot find option to add article to reading list", 15);
        }
    }

    public void goToMainWikiPage()
    {
        this.waitForElementAndClick(GO_TO_MAIN_PAGE_BUTTON, "Cannot find 'W' button to go to the main page", 5);
    }

    public String getArticleNavigationBar()
    {
        WebElement element = this.waitForElementPresent(NAVIGATION_BAR, "Cannot find navigation bar on the page");
        return element.getAttribute("name");
    }

    public void waitForOpeningArticleByTitle(String title)
    {
        String title_locator_by_article_name = getTitleLocatorByTitleName(title);
        waitForElementPresent(title_locator_by_article_name, "Cannot find article title with name " + title, 5);
    }
}
