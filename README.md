# 📊 Selenium Test Automation – St. Thomas College (Research Section)

This project automates the **Research section** of the [St. Thomas College (Autonomous), Thrissur](https://stthomas.ac.in/) website using **Java**, **Selenium WebDriver**, and **TestNG**.

It verifies page navigation, titles, URLs, and key page content across **18 different sections** of the site. The test framework includes soft assertions, waits, screenshot capture, and a clean modular structure.

---

## 🚀 Tech Stack

| Tool / Library       | Purpose                             |
|----------------------|-------------------------------------|
| Java                 | Programming Language                |
| Selenium WebDriver   | Browser Automation                  |
| TestNG               | Testing Framework                   |
| Maven                | Dependency & Build Management       |
| Git & GitHub         | Version Control & Hosting           |

---

## 🧠 Project Highlights

- ✅ Fully automated testing of all 18 Research sub-sections.
- ✅ One test class per section – clean and modular.
- ✅ Soft assertions for validating page titles and URLs.
- ✅ `ScreenshotUtils`: captures screenshots on test failure.
- ✅ `WaitHelper`: uses WebDriverWait with ExpectedConditions.
- ✅ `SleepUtils`: provides thread sleep for static waits.
- ✅ Dual suite setup: **Smoke** and **Regression**.
- ✅ Built using Java, Maven, and TestNG – no external reports used.

---

## 🧪 Test Suites

### 🔹 `testng-smoke.xml`
- Executes **only the first test** in each of the 18 test classes.
- Purpose: ✅ Validates navigation, URL, and page title.
- Quick sanity check across all Research sections.

### 🔹 `testng-regression.xml`
- Executes **all tests** from every class.
- Includes all smoke tests + detailed validations for content.
- Purpose: ✅ Full regression coverage.

---

## 📁 Project Structure
```
stc_research_automation/
│
├── src/
│ ├── main/java/
│ │ └── stthomas.stc_research_automation/
│ │ ├── base/
│ │ │ └── BaseClass.java
│ │ └── utils/
│ │ ├── ScreenshotUtils.java # Screenshot capture on failure
│ │ ├── SleepUtils.java # Static waits using Thread.sleep
│ │ └── WaitHelper.java # Explicit waits with WebDriverWait
│ │
│ └── test/java/
│ └── stthomas.stc_research_automation.tests/
│ ├── AboutRAC.java
│ ├── AnnualResearchReports.java
│ ├── AwardsAndFellowships.java
│ ├── CollaborativeResearch.java
│ ├── Consultancy.java
│ ├── Journals.java
│ ├── PhdRegulationsAndUo.java
│ ├── RacMembers.java
│ ├── RandPEthics2020.java
│ ├── RandPEthics2021.java
│ ├── ResearchAdvisoryCommittee.java
│ ├── ResearchCentres.java
│ ├── ResearchEthics.java
│ ├── ResearchHighlight.java
│ ├── ResearchPolicies.java
│ ├── ResearchProgrammes.java
│ ├── ResearchProjects.java
│ └── ResearchRegulations.java
│
├── pom.xml # Maven dependencies
├── testng-smoke.xml # Smoke test suite
├── testng-regression.xml # Regression test suite
├── test-output/ # TestNG default reports 
└── target/
```

---

## ▶ How to Run the Tests


```bash
# Clone the project
git clone https://github.com/Afsalnoushad/stc-research-automation.git
cd stc-research-automation

# Run Smoke Suite
mvn clean test -DsuiteXmlFile=testng-smoke.xml

# Run Regression Suite
mvn clean test -DsuiteXmlFile=testng-regression.xml
```

---

## 📸 Reporting

- TestNG generates default HTML reports under `test-output/`.
- On failure, screenshots are auto-captured using `ScreenshotUtils`.

---


## 🐞 Bug Report – Pre-Automation Phase

Before starting automation, a **manual testing phase** was performed to analyze the Research section and uncover bugs. These findings helped structure and prioritize the automation tasks more effectively.

📁 Bug report available at: `manual-docs/STC_Research_BugReport.xlsx`

It includes the following details:

| Column Name           | Description                                        |
|-----------------------|----------------------------------------------------|
| Bug ID                | Unique identifier for each issue                  |
| Bug Title             | A short summary of the bug                        |
| Type of Issue         | UI / Functional / Content / Navigation            |
| Module / Page         | Page or section where the bug was found           |
| Description of Issue  | Clear explanation of what went wrong              |
| Steps to Reproduce    | Steps to help replicate the issue                 |
| Expected Result       | What should ideally happen                        |
| Actual Result         | What actually happened                            |
| Severity              | High / Medium / Low                               |
| Screenshot/Recording  | Attached for better understanding (if available)  |

This document serves as part of the pre-automation groundwork and reflects a hands-on manual QA approach.

---


## 🙌 Author

**Afsal Noushad**  
[GitHub Profile](https://github.com/Afsalnoushad)

---




