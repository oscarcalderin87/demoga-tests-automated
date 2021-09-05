# demoga-tests-automated

# Prerequisites
Java (version 1.8 or higher)

Maven (version 4 or higher)

# Running test cases

## Execution without report
`mvn clean test`

## Execution with report
`mvn clean test verify`

An HTML file named overview-features.html is generated into the report folder

Additionally, you can run both commands adding the parameters `-Dheadless=[true or false]` and `-Dbrowser=[CHROME or FIREFOX]`.

The values false and CHROME are used by default.

Ex: `mvn -Dheadless=true -Dbrowser=FIREFOX clean test`
