# HocamSU App

## Project Overview

HocamSU is a mobile application tailored for Sabancı University students, providing a platform for rating and reviewing course instructors. It aims to facilitate informed decisions regarding course selection while offering a feedback loop for instructors' teaching methods improvement.

### Importance of HocamSU:

- **For Students:** Aids in course selection during registration and add-drop periods through peer insights.
- **For Instructors:** Offers actionable feedback to refine teaching approaches.
- **For Administration:** Enables monitoring and accountability of instructor performance.

## Objective and Scope

### Objectives:

- Develop a mobile application for instructor ratings and reviews.
- Implement a backend system to manage instructor data and student reviews.
- Design an intuitive UI for seamless navigation.

### Scope:

- **Backend Endpoints:** Endpoints for retrieving instructor information and posting reviews.
- **Mobile App Screens:**
  1. Home Screen
  2. Course Instructor Search/Listing
  3. Instructor Details
  4. Submit Comment
  5. Starred Instructors
  6. Settings
  7. Intro Screens

## Background and Current Practice

The absence of a centralized platform for instructor ratings at Sabancı University leads to reliance on informal channels. HocamSU addresses this gap, creating a structured and accessible feedback system.

## Potential Customer/User Description

- **Students:** Main users, providing and utilizing reviews for course planning.
- **Instructors:** Secondary users, receiving student feedback for course adjustment.
- **Administration:** Uses the system for quality control and strategic decisions.

## Technical Stack

- **Language:** Kotlin (v1.9.20)
- **Framework:** Spring Boot
- **JDK:** Version 21
- **Build Tool:** Maven

## Setup and Installation

Ensure you have the following installed:

- JDK 21
- Maven

To set up the project locally, follow these steps:

1. Clone the repository:

   ```bash
   git clone https://github.com/ilhaniskurt/hocamsu.git
   ```

2. Navigate to the project directory:

   ```bash
   cd hocamsu
   ```

3. Build the project with Maven:

   ```bash
   mvn clean install
   ```

4. Run the application:

   ```bash
   mvn spring-boot:run
   ```
