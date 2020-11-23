JUnit in Action
===============

[Notes](notes.md)

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
