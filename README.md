# Paris City Guide

An interactive City Guide application for Paris, developed using JavaFX and MySQL, that provides a centralized platform for users to explore Paris's cultural, educational, and business opportunities. The application features user registration, module selection, and dynamic data retrieval with a visually appealing and user-friendly interface.

## Features
### User Registration
- Allows users to sign in or register.
- Provides an option to write reviews via a review dialog.

### Module Selection
- Users can choose from the following modules:
  1. **Tourism Module:** Explore tourist attractions, historical sites, cultural events, restaurants, and accommodations.
  2. **Business Module:** Insights into the job market, business opportunities, economic trends, and networking events.
  3. **Student Module:** Information on schools, colleges, universities, courses, scholarships, and student organizations.

### Interactive Features
- Data retrieved dynamically from a MySQL database.
- Like and dislike functionality for items in the Tourism Module.
- Feedback dialog for submitting reviews.

## File Structure
- **`.vscode/`:** Contains project settings and launch configurations for Visual Studio Code.
- **`src/`:** Source code directory containing all the Java classes.
- **`bin/`:** Compiled `.class` files.

## How It Works
1. **User Registration:** Users can sign in or register using the `UserRegistrationApp` class.
2. **Database Connectivity:** `DataBaseConnector` handles all database interactions.
3. **Module Interaction:** Users can navigate to different modules via `ModuleSelectionWindow` and interact with:
   - **TourismModule:** Displays information about Paris's tourist attractions with options to like or dislike.
   - **BusinessModule:** Offers insights into business opportunities and trends.
   - **StudentModule:** Provides resources for students like courses, scholarships, and more.
4. **Feedback System:** Users can provide feedback or write reviews using `ReviewDialog`.

## Tools and Technologies Used
- **Programming Language:** Java
- **GUI Framework:** JavaFX
- **Database:** MySQL
- **IDE:** Visual Studio Code

## Setup Instructions
1. Clone the repository:
   ```bash
   git clone https://github.com/PratikChakrabortyaz/Paris-City-Guide.git
