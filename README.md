# CS320 — Software Testing, Automation & QA — Final Project ✅

Course: CS 320 — Software Testing, Automation and Quality AssuranceAuthor 

Author: Dylan P. Harmon

Repo: https://github.com/DPHarmon/CS320-Software-Test-QA

---
📚 Course Summary
Students apply software engineering testing strategies and practices through the SDLC, including requirements analysis, verification & validation, and quality management. 

Topics covered include:

  * Functional & non-functional testing
  * Unit, integration, system, and acceptance testing
  * Test automation and test planning
  * Creation and analysis of unit tests and test strategies

---
🧩 Project Summary
This repository contains a Java project implementing three small domain areas (Appointment, Task, Contact) and in-memory service managers plus comprehensive JUnit tests that validate object construction, mutability rules, defensive behavior, and service-level operations.

Key code areas:

  * Domain model classes: `Appointment`, `Task`, `Contact` (constraints and validation in constructors and setters)
    
  * Service classes: `AppointmentService`, `TaskService`, `ContactService` (<mark>in-memory management</mark> of add/get/update/delete with uniqueness/existence checks)
    
  * JUnit test suites: unit tests for constructors, setters, defensive copy behavior, equality/hash, and service behaviors (add/get/update/delete), covering happy paths, unhappy paths, and boundary cases

Testing approach:

  * Use of JUnit assert patterns: assertThrows, assertDoesNotThrow, assertAll, equality/hash assertions
  
  * Tests cover null/blank checks, length limits, pattern matching (phone digits), date-in-past checks, and ID uniqueness
    
  *  Test coverage reported ≈ 98% (near-complete branch and path testing)

---
✨ Features of the CS320 Project

* Domain validation rules:
  * Appointment: required fields, description length limits, date validation (no past dates), defensive copy for date accessors
    
  * Task: id ≤ 10 chars, name ≤ 20 chars, description ≤ 50 chars
  * Contact: id rules plus phone exactly 10 digits, address ≤ 30 chars

* Mutability & defensive coding:
  * Immutable IDs, controlled setters, defensive copies for mutable fields (e.g., dates)

* Service-layer invariants:
  * In-memory maps/lists that enforce ID uniqueness, existence checks for update/delete

* Test quality:
  * Well-structured JUnit tests exercising positive/negative flows, boundary cases, and service invariants
  * Deterministic, fast, CI-friendly tests (no external dependencies)

* Project structure (Eclipse/Java style, example):
  * `src/main/java/...` — domain & service classes
  * `src/test/java/...` — JUnit test classes (AppointmentTest, TaskTest, ContactTest, AppointmentServiceTest, TaskServiceTest, ContactServiceTest)
  * `docs/` — design notes, test plan
  * `fixtures/` — sample inputs (if present)

---
🛠 Skills Demonstrated & Real-World Applicability

1. Defensive Programming & Validation
    * Validating inputs (null, empty, lengths, patterns) prevents invalid state and downstream bugs.
    * Real world: input validation is critical for APIs, forms, and backend services.

2. Unit Testing (JUnit)
    * Use of assertThrows, assertAll, positive/negative tests, boundary tests.
    * Real world: Unit tests protect invariants, enable safe refactoring, and are required for CI pipelines in production teams.

3. Service-layer Design & State Management
    * In-memory CRUD operations, uniqueness enforcement, and expected exception behaviors.
    * Real world: core patterns used for repositories, microservice in-memory caches, or early-stage implementations before persistence.

4. Test Strategy & Test Plan Thinking
    * Happy-path, unhappy-path, boundary cases, state-based testing, and test grouping for maintainability.
    * Real world: Designing test suites for feature completeness and regression prevention.

5. Test Efficiency & CI-readiness
    * Fast, deterministic tests using in-memory stores—suitable for CI and frequent execution.
    * Real world: Essential for developer productivity and deployment pipelines.

6. Documentation & Test Coverage Awareness
    * Test plans, design notes, and measured coverage (~98%) indicate discipline and focus on quality.
    * Real world: Traceability and high coverage are often required for regulated domains and enterprise practices.

---
✅ Notable Test Patterns & Examples

* Constructor invalidation with `assertThrows(IllegalArgumentException.class, () -> new Task(...))`
* Grouped assertions with `assertAll(...)` to keep related assertions concise
* Defensive copy verification (e.g., `getAppointmentDate()` returns copy, not internal reference)
* Service tests for:
  * add: success, duplicate-id throws
  * get: success, missing-id throws or returns expected result
  * update: valid updates succeed; invalid updates throw
  * delete: successful deletion and expected behavior for non-existent IDs

---
📈 Project Quality & Reflection

* High test coverage with extensive positive/negative and boundary tests.
* Emphasis on maintainability: clear single-responsibility tests, helper methods, and readable assertions.
* Reflection notes emphasize mindset of defensive testing (assume user error), test-driven quality, and reduction of technical debt.

---
🙏 Acknowledgments

* :school: SNHU
* Instructor: Rob Tuft
* Course materials and references (Atlassian on technical debt, UX/happy-path references)
* Inspiration & citation: Grigoryan & Grigoryan (2024), Atlassian documentation

---
