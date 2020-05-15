package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject
{
    static
    {
        TITLE = "css:#content h1";
        FOOTER_ELEMENT = "css:footer";
        OPTiONS_ADD_TO_MY_LIST_BUTTON = "css:li#page-actions-watch>a[title='Watch']";
        CLOSE_ARTICLE_BUTTON = "css:div.branding-box";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "css:lli#page-actions-watch>a[title='Remove this page from your watchlist']";
        ARTICLE_PAGE_ACTION_MENU = "css:nav.page-actions-menu";
    }

    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
