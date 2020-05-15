package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject
{
    static
    {
        TITLE = "css:#content h1";
        FOOTER_ELEMENT = "css:footer";
        OPTiONS_ADD_TO_MY_LIST_BUTTON_WHEN_USER_NO_LOGIN = "css:li#page-actions-watch>a[title='Watch']";
        OPTiONS_ADD_TO_MY_LIST_BUTTON = "css:li#page-actions-watch>a[title='Watch']";
        OPTiONS_ADD_TO_MY_LIST_BUTTON_AFTER_REMOVING = "css:li#page-actions-watch>a[title='Add this page to your watchlist']";
        CLOSE_ARTICLE_BUTTON = "css:div.branding-box";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "css:li#page-actions-watch>a[title='Unwatch']";
        ARTICLE_PAGE_ACTION_MENU = "css:nav.page-actions-menu";
        SEARCH_BUTTON = "css:button#searchIcon";
        TITLE_BY_NAME_TMP = "xpath://body/div/div/main/div/div/h1[text()='{TITLE_NAME}']";
    }

    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
