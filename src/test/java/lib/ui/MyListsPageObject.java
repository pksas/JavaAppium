package lib.ui;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class MyListsPageObject extends MainPageObject{

    public MyListsPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    protected static String
            FOLDER_BY_NAME_TPL,
            ARTICLE_BY_TITLE_TPL,
            REMOVE_FROM_SAVED_BUTTON,
            SYNC_YOUR_SAVED_ARTICLES_QUESTION_WINDOW_CLOSE_BUTTON,
            SWIPE_ACTION_DELETE_BUTTON;

    /* TEMPLATES METHODS */
    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getSaveArticleXpathByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }

    private static String getRemoveButtonByTitle(String article_title)
    {
        return REMOVE_FROM_SAVED_BUTTON.replace("{TITLE}", article_title);
    }
    /* TEMPLATES METHODS */

    public void openFolderByName(String name_of_folder)
    {
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
                folder_name_xpath,
                "Cannot find folder by name " + name_of_folder,
                5
        );
    }

    public void waitForArticleToDisappearByTitle(String article_title)
    {
        String article_xpath = getSaveArticleXpathByTitle(article_title);
        this.waitForElementNotPresent(
                article_xpath,
                "Saved article still present with title " + article_title,
                15
        );
    }

    public void waitForArticleToAppearByTitle(String article_title)
    {
        String article_xpath = getSaveArticleXpathByTitle(article_title);
        this.waitForElementPresent(
                article_xpath,
                "Cannot find saved article with title " + article_title,
                15
        );
    }

    public void swipeByArticleToDelete(String article_title)
    {
        this.waitForArticleToAppearByTitle(article_title);
        String article_xpath = getSaveArticleXpathByTitle(article_title);

        if (Platform.getInstance().isAndroid() || Platform.getInstance().isIOS()) {
            this.swipeElementToLeft(
                    article_xpath,
                    "Cannot find saved article with title " + article_title
            );
        } else {
            String remove_locator = getRemoveButtonByTitle(article_title);
            this.waitForElementAndClick(
                    remove_locator,
                    "Cannot click button to remove article from saved.",
                    10);
        }
        if (Platform.getInstance().isIOS()) {
            this.waitForElementAndClick(
                    SWIPE_ACTION_DELETE_BUTTON,
                    "Cannot find confirm delete action button",
                    5);
        }
        if (Platform.getInstance().isMW()) {
            driver.navigate().refresh();
        }
        this.waitForArticleToDisappearByTitle(article_title);
    }

    public void assertThereIsNotArticleWithThisTitle(String article_title)
    {
        String article_xpath = getSaveArticleXpathByTitle(article_title);
        this.assertElementNoPresent(article_xpath, "We've found deleted article title in the My List");
    }

    public void waitForArticleByTitleAndOpenIt(String article_title)
    {
        String article_xpath = getSaveArticleXpathByTitle(article_title);
        this.waitForElementAndClick(
                article_xpath,
                "Cannot open article with title " + article_title,
                5
        );
    }

    public void closeSyncYourSavedArticlesQuestionWindow()
    {
        this.waitForElementAndClick(
                SYNC_YOUR_SAVED_ARTICLES_QUESTION_WINDOW_CLOSE_BUTTON,
                "Cannot find 'x' button to close 'sync your saved articles' window",
                5);
    }
}
