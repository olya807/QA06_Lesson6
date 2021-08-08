package baseEntities;

import core.BrowserService;

public class BaseStep {

    protected BrowserService browserService;

    public BaseStep(BrowserService browserService){

        this.browserService = browserService;
    }
}
