
# Feedback Fusion

[![Java + AWT](https://img.shields.io/badge/Language-Java%20%2B%20AWT-orange)](https://www.java.com/) 
[![License: MIT](https://img.shields.io/badge/License-MIT-green)](LICENSE)
[![GitHub stars](https://img.shields.io/github/stars/RohanBansal/FeedbackFusion?style=social)](https://github.com/RohanBansal/FeedbackFusion/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/RohanBansal/FeedbackFusion?style=social)](https://github.com/RohanBansal/FeedbackFusion/network/members)
[![GitHub issues](https://img.shields.io/github/issues/RohanBansal/FeedbackFusion?style=social)](https://github.com/RohanBansal/FeedbackFusion/issues)
[![GitHub license](https://img.shields.io/github/license/RohanBansal/FeedbackFusion)](https://github.com/RohanBansal/FeedbackFusion/blob/main/LICENSE)
[![GitHub last commit](https://img.shields.io/github/last-commit/RohanBansal/FeedbackFusion)](https://github.com/RohanBansal/FeedbackFusion/commits/main)

**Feedback Fusion** is a professional-grade Java AWT desktop application for managing feedback records.  
It provides a user-friendly GUI to perform standard CRUD operations (Create, Read, Update, Delete) and view feedback in a structured format.

---

## Table of Contents
- [Features](#features)
- [Screenshots](#screenshots)
- [Tech Stack](#tech-stack)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

---

## Features
- Create, read, update, and delete feedback records.
- Input fields include:
  - ID (for Update/Delete)
  - Category (Choice dropdown)
  - Rating (1–5)
  - Comments
- Displays feedback in a read-only table-like text area.
- Status label shows success and error messages.
- Optional background image for enhanced UI aesthetics.
- Semi-transparent panels for improved readability.

---

## Screenshots

*Add screenshots of the app here:* 
<img width="847" height="745" alt="feedback Fusion " src="https://github.com/user-attachments/assets/dd184676-4dc4-41b4-825d-1d50926f76ee" />


[Feedback Form]

---

## Tech Stack
- **Language:** Java + (AWT)
- **Database:** MySQL via JDBC
- **Image Handling:** `javax.imageio.ImageIO` for background images
- **IDE:** Eclipse / IntelliJ IDEA / NetBeans

---

## Getting Started

### Prerequisites
- Java JDK 8 or higher installed
- MySQL database configured
- MySQL JDBC driver (`mysql-connector-java-8.0.30.jar`) added to build path
- Optional: `resources/background.png` for background image

### Installation
1. Clone the repository:
```bash
git clone https://github.com/RohanBansal/FeedbackFusion.git
````

2. Open the project in Eclipse or your preferred IDE.
3. Add the MySQL JDBC driver to the project classpath (if not already added).
4. Configure the database connection in `src/com/feedbackfusion/repository/DBConnection.java`.
5. Ensure `resources/background.png` exists for the background image.

---

## Usage

1. Run the main class:

```bash
java com.feedbackfusion.app.Main
```

2. The Feedback Form window will open.
3. Use the form to:

   * Enter feedback and click **Create**
   * View all feedback using **Read All**
   * Update an existing record using **Update**
   * Delete a record using **Delete**
   * Clear the form fields using **Clear Fields**

---

## Project Structure

```
feedbackfusion/
│
├─ src/
│  ├─ com.feedbackfusion.app/
│  │   └─ Main.java
│  ├─ com.feedbackfusion.model/
│  │   └─ Feedback.java
│  ├─ com.feedbackfusion.presentation/
│  │   └─ FeedbackForm.java
│  ├─ com.feedbackfusion.repository/
│  │   ├─ DBConnection.java
│  │   └─ FeedbackRepository.java
│  ├─ com.feedbackfusion.service/
│  │   ├─ FeedbackService.java
│  │   └─ FeedbackValidator.java
│  └─ module-info.java
│
├─ resources/
│  ├─ background.png
│  └─ db.properties
│
└─ Referenced Libraries/
   └─ mysql-connector-java-8.0.30.jar
```

---

## Contributing

1. Fork the repository.
2. Create a new feature branch:

```bash
git checkout -b feature/YourFeature
```

3. Commit your changes:

```bash
git commit -m "Add feature"
```

4. Push to the branch:

```bash
git push origin feature/YourFeature
```

5. Open a Pull Request.

---

## License

This project is licensed under the MIT License.
See the [LICENSE](LICENSE) file for details.

```

