package utils;

import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.StepResult;
import io.qameta.allure.model.TestResult;
import tests.BaseTest;

public class TestListener implements StepLifecycleListener, TestLifecycleListener {
    public static final ThreadLocal<String> THREAD_LOCAL_TC_NAME = new ThreadLocal<>();

    @Override
    public void beforeTestStart(TestResult result) {
        THREAD_LOCAL_TC_NAME.set(result.getName());
    }

    @Override
    public void beforeStepStop(StepResult step) {
        BaseTest.getBasePage().takeScreenShot();
    }

    public static synchronized String getTestCastName() {
        return THREAD_LOCAL_TC_NAME.get();
    }
}
