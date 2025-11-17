package com.shashankkumar.utils;

public class ScenarioContext {

    private static ThreadLocal<RestHelper> restHelper = ThreadLocal.withInitial(RestHelper::new);

    public static RestHelper getRestHelper() {
        return restHelper.get();
    }

    public static void setRestHelper(RestHelper helper) {
        restHelper.set(helper);
    }

    public static void clear() {
        restHelper.remove();
    }
}
