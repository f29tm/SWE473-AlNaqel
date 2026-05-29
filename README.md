# Al-Naqel Fare Card System
### SWE 473 - Software Maintenance and Evolution | Spring 2025-26

This is the base project for the SWE 473 course project. It simulates a transit fare card system for UAE Smart Travel Limited.

---

## System Overview

When a user passes through the inward barrier, their card is charged the **maximum fare**. When they exit, the actual fare is calculated and the difference refunded. If they do not swipe out, they are charged the maximum fare.

All bus journeys are charged at a flat rate.

---

## Stations and Zones

| Station    | Zone(s)  |
|------------|----------|
| Algubaiba  | 1        |
| Jumeirah   | 1, 2     |
| Bur Dubai  | 3        |
| Deira      | 2        |
| Al Fahidi  | 3        |

---

## Fare Table

| Journey                          | Fare (AED) |
|----------------------------------|------------|
| Anywhere in Zone 1               | 2.50       |
| Any one zone outside Zone 1      | 2.00       |
| Any two zones including Zone 1   | 3.00       |
| Any two zones excluding Zone 1   | 2.25       |
| Any three zones                  | 3.20       |
| Any bus journey                  | 1.80       |

Maximum possible fare: **AED 3.20**

---

## Tech Stack

- Java 11
- Spring Boot 2.6.2
- Maven
- JUnit 5

---

## Getting Started

```bash
git clone https://github.com/drramzana/SWE473.git
cd SWE473
./mvnw spring-boot:run
```

API will be available at `http://localhost:8080`

---

## Project Instructions

Each team must:
1. Clone this repo and create a `sprint-1` branch
2. Work in individual local branches and merge after peer review
3. Follow the full project specification provided on Blackboard

---

*Course project - Dr. Alramzana Navaz, CSIT Department.ADU*


## Project Team

| Name | Branch |
|------|--------|
| Fatimetou Agha | fatima-dev |
| Aysha Alshooli | aysha-dev |
| Bushra Salam Seram Baluch | bushra-dev |
| Latifa Alsulaim | latifa-dev |

Course: SWE 473 — Software Maintenance and Evolution
Instructor: Dr. Alramzana Navaz
Semester: Spring 2025–26
