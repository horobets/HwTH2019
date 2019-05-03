package task8.kismia.pages;

public enum ProfileSettingsTab {
    SEARCH("Search parameters", "profileSearch", KsProfileSettingsSearchPage.class),
    PERSONAL("Search parameters", "profile", KsProfileSettingsPersonalPage.class),
    ACCOUNT("Account", "security", null),
    COINS("Coins", "coins", null),
    SUBSCRIPTION("Subscription", "premium", null),
    NOTIFICATIONS("Notifications", "notifications", null);

    private String name;
    private String tabId;
    private Object page;

    ProfileSettingsTab(String name, String tabId, Object page) {
        this.name = name;
        this.tabId = tabId;
        this.page = page;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getTabId() {
        return tabId;
    }

    public <T extends Object> T getPage() {
        if (page == null) {
            throw new NullPointerException();
        }
        return (T) page;
    }
}
