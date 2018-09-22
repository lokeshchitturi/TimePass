$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("wishkarma.feature");
formatter.feature({
  "line": 1,
  "name": "Validating wishkarma functioalities",
  "description": "",
  "id": "validating-wishkarma-functioalities",
  "keyword": "Feature"
});
formatter.before({
  "duration": 4969765400,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Login test case",
  "description": "",
  "id": "validating-wishkarma-functioalities;login-test-case",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@login"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "user navigates to URL...Login:navigateToURL",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "user login into application...Login:loginIntoApplication",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "L",
      "offset": 20
    },
    {
      "val": "Login:navigateToURL",
      "offset": 24
    }
  ],
  "location": "stepDefinitions.executeMethod1(String,String)"
});
formatter.result({
  "duration": 2541125909,
  "error_message": "java.lang.reflect.InvocationTargetException\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat utils.WebDriverUtils.executeMethod(WebDriverUtils.java:340)\r\n\tat stepdefinition.stepDefinitions.executeMethod1(stepDefinitions.java:18)\r\n\tat ✽.Given user navigates to URL...Login:navigateToURL(wishkarma.feature:6)\r\nCaused by: org.openqa.selenium.NoSuchWindowException: no such window: target window already closed\nfrom unknown error: web view not found\n  (Session info: chrome\u003d68.0.3440.106)\n  (Driver info: chromedriver\u003d2.39.562718 (9a2698cba08cf5a471a29d30c8b3e12becabb0e9),platform\u003dWindows NT 10.0.17134 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 0 milliseconds\nBuild info: version: \u00273.5.1\u0027, revision: \u00279c21bb67ef\u0027, time: \u00272017-08-17T15:26:08.955Z\u0027\nSystem info: host: \u0027DESKTOP-U77UHNF\u0027, ip: \u0027192.168.0.13\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_151\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{mobileEmulationEnabled\u003dfalse, hasTouchScreen\u003dfalse, platform\u003dXP, acceptSslCerts\u003dfalse, acceptInsecureCerts\u003dfalse, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, setWindowRect\u003dtrue, unexpectedAlertBehaviour\u003d, applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.39.562718 (9a2698cba08cf5a471a29d30c8b3e12becabb0e9), userDataDir\u003dC:\\Users\\HOME\\AppData\\Local\\Temp\\scoped_dir16472_16180}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, unhandledPromptBehavior\u003d, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, version\u003d68.0.3440.106, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, locationContextEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 1de16fe8d49a14dfae8d60105c38fc1b\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:215)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:167)\r\n\tat org.openqa.selenium.remote.http.JsonHttpResponseCodec.reconstructValue(JsonHttpResponseCodec.java:40)\r\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:82)\r\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:45)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:164)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:82)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:641)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:698)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.getScreenshotAs(RemoteWebDriver.java:386)\r\n\tat utils.WebDriverUtils.captureScreenshotAndGetpath(WebDriverUtils.java:190)\r\n\tat pageClasses.Login.navigateToURL(Login.java:77)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat utils.WebDriverUtils.executeMethod(WebDriverUtils.java:340)\r\n\tat stepdefinition.stepDefinitions.executeMethod1(stepDefinitions.java:18)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\r\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:38)\r\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\r\n\tat cucumber.runtime.ExtendedRuntime.runStep(ExtendedRuntime.java:319)\r\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\r\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:44)\r\n\tat com.github.mkolisnyk.cucumber.runner.ExtendedExecutionUnitRunner.run(ExtendedExecutionUnitRunner.java:32)\r\n\tat com.github.mkolisnyk.cucumber.runner.ExtendedFeatureRunner.runChild(ExtendedFeatureRunner.java:81)\r\n\tat com.github.mkolisnyk.cucumber.runner.ExtendedFeatureRunner.runChild(ExtendedFeatureRunner.java:23)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\r\n\tat com.github.mkolisnyk.cucumber.runner.ExtendedCucumber.runChild(ExtendedCucumber.java:108)\r\n\tat com.github.mkolisnyk.cucumber.runner.ExtendedCucumber.runChild(ExtendedCucumber.java:32)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\r\n\tat com.github.mkolisnyk.cucumber.runner.ExtendedCucumber.run(ExtendedCucumber.java:148)\r\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\r\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:459)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:678)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:382)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:192)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "n",
      "offset": 26
    },
    {
      "val": "Login:loginIntoApplication",
      "offset": 30
    }
  ],
  "location": "stepDefinitions.executeMethod1(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 432977704,
  "status": "passed"
});
formatter.before({
  "duration": 3723287726,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Login test case",
  "description": "",
  "id": "validating-wishkarma-functioalities;login-test-case",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@login"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "user navigates to URL...Login:navigateToURL",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "user login into application...Login:loginIntoApplication",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "L",
      "offset": 20
    },
    {
      "val": "Login:navigateToURL",
      "offset": 24
    }
  ],
  "location": "stepDefinitions.executeMethod1(String,String)"
});
formatter.result({
  "duration": 3627051495,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "n",
      "offset": 26
    },
    {
      "val": "Login:loginIntoApplication",
      "offset": 30
    }
  ],
  "location": "stepDefinitions.executeMethod1(String,String)"
});
formatter.result({
  "duration": 31297510005,
  "error_message": "java.lang.reflect.InvocationTargetException\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat utils.WebDriverUtils.executeMethod(WebDriverUtils.java:340)\r\n\tat stepdefinition.stepDefinitions.executeMethod1(stepDefinitions.java:18)\r\n\tat ✽.And user login into application...Login:loginIntoApplication(wishkarma.feature:7)\r\nCaused by: org.openqa.selenium.TimeoutException: Expected condition failed: waiting for utils.WebDriverUtils$$Lambda$121/1815025408@2b50150 (tried for 30 second(s) with 500 MILLISECONDS interval)\r\n\tat org.openqa.selenium.support.ui.WebDriverWait.timeoutException(WebDriverWait.java:80)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:232)\r\n\tat utils.WebDriverUtils.waitUntilPageLoads(WebDriverUtils.java:110)\r\n\tat pageClasses.Login.clickSignIn(Login.java:104)\r\n\tat pageClasses.Login.loginIntoApplication(Login.java:47)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat utils.WebDriverUtils.executeMethod(WebDriverUtils.java:340)\r\n\tat stepdefinition.stepDefinitions.executeMethod1(stepDefinitions.java:18)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\r\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:38)\r\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\r\n\tat cucumber.runtime.ExtendedRuntime.runStep(ExtendedRuntime.java:319)\r\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\r\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:44)\r\n\tat com.github.mkolisnyk.cucumber.runner.ExtendedExecutionUnitRunner.run(ExtendedExecutionUnitRunner.java:32)\r\n\tat com.github.mkolisnyk.cucumber.runner.ExtendedFeatureRunner.retry(ExtendedFeatureRunner.java:126)\r\n\tat com.github.mkolisnyk.cucumber.runner.ExtendedFeatureRunner.runChild(ExtendedFeatureRunner.java:90)\r\n\tat com.github.mkolisnyk.cucumber.runner.ExtendedFeatureRunner.runChild(ExtendedFeatureRunner.java:23)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\r\n\tat com.github.mkolisnyk.cucumber.runner.ExtendedCucumber.runChild(ExtendedCucumber.java:108)\r\n\tat com.github.mkolisnyk.cucumber.runner.ExtendedCucumber.runChild(ExtendedCucumber.java:32)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\r\n\tat com.github.mkolisnyk.cucumber.runner.ExtendedCucumber.run(ExtendedCucumber.java:148)\r\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\r\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:459)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:678)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:382)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:192)\r\nCaused by: org.openqa.selenium.NoSuchWindowException: no such window: target window already closed\nfrom unknown error: web view not found\n  (Session info: chrome\u003d68.0.3440.106)\n  (Driver info: chromedriver\u003d2.39.562718 (9a2698cba08cf5a471a29d30c8b3e12becabb0e9),platform\u003dWindows NT 10.0.17134 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 0 milliseconds\nBuild info: version: \u00273.5.1\u0027, revision: \u00279c21bb67ef\u0027, time: \u00272017-08-17T15:26:08.955Z\u0027\nSystem info: host: \u0027DESKTOP-U77UHNF\u0027, ip: \u0027192.168.0.13\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_151\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{mobileEmulationEnabled\u003dfalse, hasTouchScreen\u003dfalse, platform\u003dXP, acceptSslCerts\u003dfalse, acceptInsecureCerts\u003dfalse, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, setWindowRect\u003dtrue, unexpectedAlertBehaviour\u003d, applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.39.562718 (9a2698cba08cf5a471a29d30c8b3e12becabb0e9), userDataDir\u003dC:\\Users\\HOME\\AppData\\Local\\Temp\\scoped_dir21864_6340}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, unhandledPromptBehavior\u003d, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, version\u003d68.0.3440.106, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, locationContextEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 5feaf4034ea4d305514973758594b1c8\r\n\tat sun.reflect.GeneratedConstructorAccessor10.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:215)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:167)\r\n\tat org.openqa.selenium.remote.http.JsonHttpResponseCodec.reconstructValue(JsonHttpResponseCodec.java:40)\r\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:82)\r\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:45)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:164)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:82)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:641)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.executeScript(RemoteWebDriver.java:577)\r\n\tat utils.WebDriverUtils.lambda$1(WebDriverUtils.java:111)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:209)\r\n\t... 48 more\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 113209082,
  "status": "passed"
});
formatter.before({
  "duration": 3588872469,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Login test case",
  "description": "",
  "id": "validating-wishkarma-functioalities;login-test-case",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@login"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "user navigates to URL...Login:navigateToURL",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "user login into application...Login:loginIntoApplication",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "L",
      "offset": 20
    },
    {
      "val": "Login:navigateToURL",
      "offset": 24
    }
  ],
  "location": "stepDefinitions.executeMethod1(String,String)"
});
formatter.result({
  "duration": 3743746347,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "n",
      "offset": 26
    },
    {
      "val": "Login:loginIntoApplication",
      "offset": 30
    }
  ],
  "location": "stepDefinitions.executeMethod1(String,String)"
});
formatter.result({
  "duration": 9864986078,
  "status": "passed"
});
formatter.after({
  "duration": 65863409,
  "status": "passed"
});
});