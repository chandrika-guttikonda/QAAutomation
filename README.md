# 🔍 WebDriver Automation Practice – Day 1 to Day 4

This repository contains structured daily assignments for mastering Selenium WebDriver with Java, TestNG, and real-time scenarios.

---

## 📅 Day 1 – Basic Browser Launch and Element Locators

### ✅ Topics Covered
- Launching browser using Selenium WebDriver
- Navigating to a URL
- Locating elements using:
  - ID
  - Name
  - ClassName
  - XPath
  - CSS Selector

### 🧪 Test File
- `Day1Practice.java`

### 🔗 Practice Site
- https://rahulshettyacademy.com/AutomationPractice/

---

## 📅 Day 2 – Browser Navigation and Interaction

### ✅ Topics Covered
- Using browser navigation commands:
  - `navigate().to()`
  - `navigate().back()`
  - `navigate().forward()`
  - `navigate().refresh()`
- Clicking buttons and verifying titles

### 🧪 Test File
- `Day2BrowserNavigation.java`

### 🔗 Practice Site
- https://rahulshettyacademy.com/AutomationPractice/

---

## 📅 Day 3 – Form Handling, Scroll, Radio & Checkbox

### ✅ Topics Covered
- Filling forms
- Selecting radio buttons and checkboxes
- Using dropdowns
- Scrolling using JavaScriptExecutor
- Validating modal dialogs

### 🧪 Test File
- `Day3FormAutomationTest.java`

### 🔗 Practice Site
- https://demoqa.com/automation-practice-form

---

## 📅 Day 4 – Advanced UI Interactions (Alerts, Frames, Windows)

### ✅ Topics Covered
- Handling JavaScript Alerts (Simple, Confirm, Prompt)
- Switching to iFrames and Nested Frames
- Handling multiple browser windows and tabs
- Working with Modal Dialogs

### 🧪 Test File
- `Day4AdvancedUIInteractions.java`

---

✅ Day 5 – Java OOP Concepts with Selenium
Topics Covered Practiced:
Class and Object
-Constructor and Constructor Overloading
-Inheritance (LoginTest extends BaseTest)
-Encapsulation (private WebElements in LoginPage)
-Method Overloading (login() variations in LoginPage)
-Method Overriding (login() in InvalidLoginPage)

### 🧪 Test File
- Day5_Java_OOP Folder

---

### Day 6 - Java String,Arrays, Loops,Conditional Logic
- String validation (trimming input, checking messages)
- Array-based logic for gender and hobby options
- Loops for verifying all options are present and interactable
- Conditional logic to control whether the form submits or blocks

---

### Day 7 - Java Collections

- List
- Set
- Map
- Iterator

---

### ✅ Day 8: Wait Strategies + Flaky Element Handling
**Concepts Used:**  
- Implicit Wait  
- Explicit Wait  
- Fluent Wait  
- Retry + Exception Handling for flaky elements

---

# Day 9 – Locator Strategy, Dynamic Elements, Stale Element Handling
- 📌 **Locator Strategy**
  - ID, Name, ClassName, TagName
  - LinkText, PartialLinkText
  - CSS Selectors: `[attr='value']`, `.class`, `#id`, pseudo-classes
  - XPath types:
    - Absolute vs Relative
    - `contains()`, `text()`, `starts-with()`
    - XPath axes: `parent`, `child`, `following-sibling`, `ancestor`, `descendant`

---


### Day 10 – WebTables, Dynamic Row Extraction, Pagination
- Static & dynamic WebTables in Selenium
- Extracting rows & columns using XPath/CSS
- Skipping "Loading..." or empty cells in AJAX tables
- Pagination handling with Next button
- Ensuring data loads before accessing (AJAX wait handling)
- Scrolling not required for visible table
- `stalenessOf()` strategy for page sync

--

### Day 11 – Mouse/Keyboard Actions, File Upload/Download, Robot Class**
- Selenium `Actions` class:
  - Hover (`moveToElement`)
  - Right-click (`contextClick`)
  - Double-click (`doubleClick`)
  - Keyboard simulation via `sendKeys`
- File Upload:
  - Using `sendKeys()` for `<input type="file">`
  - Using `Robot` class for native dialog handling
- File Download:
  - Using `ChromeOptions` to set custom download directory
  - Java File I/O to verify downloaded file exists
- Java Clipboard handling (`StringSelection`, `Toolkit`)
- Difference between DOM-based and OS-level interactions

### 🔗 Practice Sites
- Alerts: https://demoqa.com/alerts
- Frames: https://demoqa.com/frames
- Nested Frames: https://demoqa.com/nestedframes
- Browser Windows: https://demoqa.com/browser-windows
- Modal Dialogs: https://demoqa.com/modal-dialogs
- OOP concepts: https://practicetestautomation.com/practice-test-login/
- Day 6 Concepts: https://demoqa.com/automation-practice-form
- Day 7 Java Collections: https://practicetestautomation.com/practice-test-login/
- day 8 Wait Strategies: https://the-internet.herokuapp.com/dynamic_controls
- day 9 wWeb tables and stale element handling: https://demoqa.com/webtables
- day 10 WebTables and pagignations: https://datatables.net/examples/data_sources/ajax.html
- day11 Action menu hover: https://demoqa.com/menu
- day11 Action example with clicks: https://demoqa.com/buttons
- day11 filedownalod: https://demoqa.com/upload-download
- day11 fileuploadwithsendkeys: https://demo.guru99.com/test/upload/
- day11 fileUpload with robot: https://smallpdf.com/word-to-pdf

---

## 🛠️ Tools & Setup

- **Language**: Java
- **Framework**: Selenium WebDriver
- **Build Tool**: Maven
- **IDE**: Eclipse
- **Browser**: Chrome (via ChromeDriver)

---

## 📌 How to Run Tests

1. Open project in Eclipse
2. Right-click on desired test class (e.g., `Day3FormAutomationTest.java`) → `Run As` → `Java Application`
3. Observe execution in Chrome and check console output

---
## 📌 How to Run Day5 OOP Java classes
- Run main() method in LoginTest class
- Chrome browser will open and execute:
- Valid login using manual methods
- Valid login using constructor auto-fill
- Invalid login with error validation

---

## ✍️ Author

**Chandrika Guttikonda**  
_Automation Test Engineer | 3 Years Experience 