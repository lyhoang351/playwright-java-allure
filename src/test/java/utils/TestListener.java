package utils;

import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.TestResult;

public class TestListener implements StepLifecycleListener, TestLifecycleListener {
    public static final ThreadLocal<String> THREAD_LOCAL_TC_NAME = new ThreadLocal<>();

    @Override
    public void beforeTestStart(TestResult result) {
        THREAD_LOCAL_TC_NAME.set(result.getName());
    }

    public static synchronized String getTestCastName() {
        return THREAD_LOCAL_TC_NAME.get();
    }

}


