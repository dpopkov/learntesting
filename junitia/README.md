JUnit in Action
===============

[Defenitions and Notes](notes.md)

Lifecycle
---------

Test method annotations: @Test, @RepeatedTest, @ParameterizedTest, @TestFactory, @TestTemplate.

Life cycle method annotations: @BeforeAll, @AfterAll, @BeforeEach, @AfterEach 
([example](src/test/java/learn/junitia/ch02core/lifecycle/SystemUnderTestTest.java)).

To run a test class, you can execute the following from the command line:
`mvn -Dtest=AnyClassNameTest.java clean install.`

Tagging
-------

### How to filter tests by tags
1 - Example of pom.xml config:
```XML
<configuration>
    <groups>individual</groups>
    <excludedGroups>repository</excludedGroups>
</configuration>
```
2 - Use Intellij configuration: Run -> Run -> Edit Configurations -> Test kind: Tags

Asserts
-------
* assertAll
* assertTimeout, assertTimeoutPreemptively
* assertThrows

Assumptions
-----------
* assumeTrue
* assumingThat

Dependency Injection for parameters of constructors and methods
---------------------------------------------------------------
* org.junit.jupiter.api.TestInfo
* org.junit.jupiter.api.TestReporter
* org.junit.jupiter.api.RepetitionInfo

Repeated tests
--------------
* @RepeatedTest
* org.junit.jupiter.api.RepetitionInfo

Parameterized tests
-------------------
* @ParameterizedTest
* @ValueSource, @EnumSource, @CsvSource, @CsvFileSource

Dynamic tests
-------------
* @TestFactory
* org.junit.jupiter.api.DynamicNode
* org.junit.jupiter.api.DynamicTest
* org.junit.jupiter.api.DynamicContainer

Using Hamcrest Matchers
-----------------------

Factory method  | Logical
----------------|--------
anything        | Matches absolutely anything; useful when we want to make the assert statement more readable
is              | Used only to improve the readability of statements
allOf           | Checks whether all contained matchers match (like the && operator)
anyOf           | Checks whether any of the contained matchers match (like the OR operator)
not             | Inverts the meaning of the contained matchers
instanceOf      | Check whether objects are instances of one another
sameInstance    | Tests object identity
nullValue, notNullValue | Tests for null or non-null values
hasProperty     | Tests whether a Java Bean has a certain property
hasEntry, hasKey, hasValue  | Tests whether a given Map has a given entry, key, or value
hasItem, hasItems           | Tests a given collection for the presence of an item or items
closeTo, greaterThan, greaterThanOrEqualTo, | Tests the given numbers
lessThan, lessThanOrEqualTo | Tests the given numbers
equalToIgnoringCase         | Tests whether a given string equals another one, ignoring the case
equalToIgnoringWhiteSpace   | Tests whether a given string equals another one, ignoring white space
containsString, endsWith, startsWith    | Tests whether a given string contains, starts with, or ends with a certain string

Testing with stubs
------------------

### Stubbing the web server resources

Complicated approach to stub web resources (Integration Test actually):
[How to stub a web server](src/test/java/learn/junitia/ch07stubs/StubbingHttpServerWebClientTest.java)

### Stubbing the connection

The easier approach to stub the connection instead of a whole server:
[How to stub a connection](src/test/java/learn/junitia/ch07stubs/StubbingConnectionWebClientTest.java)


Testing with mocks
------------------

### Mocking without mock frameworks

#### 1 - Refactoring plus Extending
[WebClientRefactored](src/main/java/learn/junitia/ch08mocks/web/WebClientRefactored.java) is extended to
[TestableWebClient](src/test/java/learn/junitia/ch08mocks/web/TestableWebClient.java) (with Factory Method pattern)
and is tested in [WebClientRefactoredTest](src/test/java/learn/junitia/ch08mocks/web/WebClientRefactoredTest.java)
using mocked connection [MockHttpURLConnection](src/test/java/learn/junitia/ch08mocks/web/MockHttpURLConnection.java).

#### 2 - Refactoring by using a class factory
[WebClientRefactored2](src/main/java/learn/junitia/ch08mocks/web/WebClientRefactored2.java) 
uses [ConnectionFactory](src/main/java/learn/junitia/ch08mocks/web/ConnectionFactory.java) interface
which is easily mocked by [MockConnectionFactory](src/test/java/learn/junitia/ch08mocks/web/MockConnectionFactory.java)
so that WebClientRefactored2 can easily be tested in 
[WebClientRefactored2Test](src/test/java/learn/junitia/ch08mocks/web/WebClientRefactored2Test.java). 
