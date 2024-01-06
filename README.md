Car Renting Comparator is an application created completely from scratch using tools and practices just as in commercial work. It means that the project has its own board in jira, where tasks are created, which have their statuses, and a backlog, into which ideas
for the development of the application are dropped. On an ongoing basis, documentation is created for each task in confluence. <br /> <br />
I develop this application after working hours during my free time for satisfaction and to fulfill my idea for an application into a real project and to practice my developing skills. <br /> <br />
The ultimate goal is to create an application that facilitates the comparison of offerings from various car rental companies. Unlike many existing sites that focus solely on price, this application aims to allow users to compare specific car details such as brand,
model, horsepower, and more. <br /> <br />
The initial focus is on configuring the application properly, integrating necessary dependencies, setting up an external database, and implementing log4j2 for efficient log collection in a dedicated file. The plan is to utilize the Elastic Stack, including Kibana,
for log visualization. <br /> <br />
The development process involves managing separate branches for distinct tasks, which are then merged into the develop branch, where are tested and deployed into main production branch after successful testing. Each functionality has its own junit
tests and detailed documentation is maintained on Confluence.

Changelog v0.0.1:
* Main Spring Boot project has been created
* Added relevant dependencies
* Git has been configured
* Added and configured log4j2 disabling Spring's default logs:

  - Log4j2 currently captures logs from the INFO level and above in the console
  - Log4j2 currently captures logs to a separate application-logs file in the project with WARN level and above