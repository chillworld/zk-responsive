package be.chillworld.vm;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.MatchMedia;
import org.zkoss.bind.annotation.QueryParam;
import org.zkoss.zk.ui.Executions;

/**
 *
 * @author chillworld
 */
public class IndexVM implements TemplateConstants {

    private String url;
    private static final String URL_PREFIX = "~./zul/webpages/templates/";
    private String template = null;

    @Init
    public void init(@QueryParam("page") String queryParam) {
        url = (String) Executions.getCurrent().getAttribute("page") + ".zul";
    }

    @MatchMedia("all and (max-width: 500px)")
    public void handleMax500() {
        switchTemplate(MOBILE);
    }

    @MatchMedia("all and (min-width: 501px)")
    public void handleMin500() {
        switchTemplate(DESKTOP);
    }

    public void switchTemplate(String newTemplate) {
        if (template == null || !newTemplate.equals(template)) {
            this.template = newTemplate;
            BindUtils.postNotifyChange(null, null, this, "template");
            BindUtils.postNotifyChange(null, null, this, "mobile");
        }
    }

    public String getTemplate() {
        return template;
    }

    public boolean isMobile() {
        return MOBILE.equals(template);
    }

    public String getUrl() {
        if (url == null) {
            return null;
        }
        return URL_PREFIX + url;

    }

}
