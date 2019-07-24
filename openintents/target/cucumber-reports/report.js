$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/AddingList.feature");
formatter.feature({
  "name": "Verifying Shopping List",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Adding and removing List items",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User Navigates to Home page",
  "keyword": "Given "
});
formatter.match({
  "location": "ShoppingStepDef.java:14"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Add List 1",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "User Add List New",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "Add some Items to List",
  "keyword": "And "
});
formatter.match({
  "location": "ShoppingStepDef.java:23"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Delete An Items in List",
  "keyword": "Then "
});
formatter.match({
  "location": "ShoppingStepDef.java:30"
});
formatter.result({
  "status": "skipped"
});
});