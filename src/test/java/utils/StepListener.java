package utils;

import io.qameta.allure.Allure;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.StepResult;
import io.qameta.allure.model.TestResult;
import tests.BaseTest;

import static pages.BasePage.takeScreenshotByPage;

public class StepListener implements StepLifecycleListener, TestLifecycleListener {
    public static String testcaseName;

    @Override
    public void beforeTestStart(TestResult result) {
       testcaseName = result.getName();
    }

    @Override
    public void beforeStepStop(StepResult step) {
        takeScreenshotByPage(BaseTest.BASE_PAGE, testcaseName);
        StepLifecycleListener.super.beforeStepStop(step);
    }
}
