# Code Reflection :notebook:
Final assignment to end my CS-320 Journey
---

### 1. Ensuring functionality and security :anchor:
   
Functionality can be demonstrated through systematic testing by:
   * Validating end-to-end functionality through systematic test cases
   * Ensuring security compliance through specialized testing procedures
   * Maintaining user experience consistency across different platforms
   * Confirming business requirements fulfillment.

Using requirements to clearly define feature completeness leads to proper  `` unit tests `` (for individual classes and methods),  `` integration tests `` (to verify component interactions), and  `` user acceptance testing `` (to validate End-user scenarios). 

Using Secure coding practices can further ensure functionality and security. Some of these practices I would use include:
  * Input/Output:  `` Validators `` and  `` Sanitizers ``
  * Check third-pary  `` code integration `` (Pin dependencies to  `` versions `` or  `` hashes ``)
  * Enforce access control (Utilize  `` Principle of least privilege ``)
  * Implement  `` error handling `` and  `` logging ``
  * Utilize  `` Code Reviews `` (Connect to CI/CD pipeline)
  * Cryptographic Practices (Protect Data Confidentiality)
---

### 2. Interpret user needs and Incorporate them :incoming_envelope:

First start with discovery. User needs are requirements and expectations that developers, user, and product owner have when interacting with the software. These needs can be broken down into `` Functionality ``, `` Usability ``, `` Aesthetics ``, `` Accessibility ``, `` User Satisfaction ``. I would conduct user research to gain insights into needs goals and preferences to clearly define the `` Prioritization of requirements ``:
  * Must-have
  * Should-have
  * Could-have
  * Won't have

Engaging with stakeholders and user to ensure a comprehensive understanding of `` Functional  ``, `` Non-Functional `` and `` Domain `` requirements. 

Key Activities:
  * User research: interviews, surveys, usability testing/observation (current system)
  * Create User Story personas ( As a [user], I want [action] so that [benefit] )
  * Map current and desired flows
  * Convert findings into clear user stories, acceptance criteria
  * Map to unit/integration/E2E/ UAT tests
  * Traceablity (link stories to requirements to prove coverage)
---

## 3. How do I approach designing software?

#### Design Appraoch
A high functioning design mindset requires focusing on highly maintainable, extensible and scalable solutions by utilizing fundamental practices and patterns to develop adapltable software at low risk. Functional encapsulation protects modular systems so that module changes can be developed, deployed, upgraded independantly. Fundamentaly the design principle `` Separation of Concerns (SoC) `` corrolates to maintainability of a system. Understand fundamental:

``` Behavioral, Structural, and Creational design patterns; and utilize them when needed ``` 

#### Mindset Approach
Adopt a design `` Mindset ``. I know answering what is your aproach to designing software and replying "use a design mindset" seems like a cheat answer but let me explaing. A design mindset means you approach the root problem not with only a "Fix-it felix" approach but rather as a researcher would. Fully understand the problem and generate multiple ideas/solutions, test and compare those solutions, make those solutions real and then evaluate them. Verification isn't just for code, it's dicipline. When I started out what were the objectives, does this solution align with those objectives? 

``` Define what you need to learn/do/test, Create something tangible, Evaluate results and decide "what's next" ```
    

