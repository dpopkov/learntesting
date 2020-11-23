Notes
=====

__Framework__ - A semicomplete application that provides a reusable common structure to share among applications. 2 Developers incorporate the framework into their own applications and extend it to meet their specific needs. Frameworks differ from toolkits by providing a coherent structure rather than a simple set of utility classes. A framework defines a skeleton, and the application defines its own features to fill out the skeleton. The developer code is called appropriately by the framework. Developers can worry less
about whether a design is good and focus more on implementing domain-specific functions.


__Unit test__ - A test that examines the behavior of a distinct unit of work. A unit of work is a task that is not directly dependent on the completion of any other task. Within a Java application, the distinct unit of work is often, but not always, a single method. In contrast, integration tests and acceptance tests
examine how various components interact.

__API contract__ - A view of an application programming interface (API) as a formal agreement between the caller and the callee. Often, unit tests help define the API contract by demonstrating the expected behavior.
The notion of an API contract arises from the practice of Design by Contract, popularized by the Eiffel programming language (http://archive.eiffel.com/doc/manuals/technology/contract).

__Core principle of unit testing__ - "Any program feature without an automated test simply doesn't exist." (Kent Beck, Extreme Programming Explained)
