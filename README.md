# PlantManagementSystem

# Plant Management System

## Overview

The Plant Management System is a Java-based application designed to assist users in managing their plant collections effectively. It offers functionalities for tracking care tasks, maintaining a comprehensive registry of plant species, and providing personalized plant recommendations based on specific environmental requirements. This system is ideal for plant enthusiasts, gardeners, and professionals in the horticultural field.

## Features

- **Plant Registration**: Users can register new plants, specifying detailed attributes such as:
  - Name
  - Family
  - Native Habitat
  - Light Requirements
  - Soil Type
  - Humidity Preference
  - Temperature Range
  - Watering Needs
  - Fertilization Schedule
  - Pruning Requirements
  - Pest Information

- **User Management**: Create and manage user profiles, allowing users to maintain a personalized list of their plants.

- **Task Management**: Schedule and display tasks related to plant care, including watering, fertilizing, and pruning.

- **Plant Recommendations**: Suggest suitable plants based on the user's specified light requirements, enhancing plant selection for different environments.

## Technologies Used

- **Java**: The primary programming language for developing the application.
- **Collections Framework**: Utilizes data structures like `ArrayList`, `HashMap`, and `PriorityQueue` for effective data management and quick access.
- **Object-Oriented Programming (OOP)**: The application is designed using OOP principles, encapsulating data and behaviors in classes.

## Classes Overview

1. **Plant**: 
   - Attributes: Represents various attributes of plants with getters and setters.
   - Methods: Includes a method for displaying plant information.

2. **User**: 
   - Attributes: Manages user-specific details including ID, name, role, and contact information.
   - Methods: Provides getters for user attributes.

3. **UserProfile**: 
   - Attributes: Contains a username and a list of associated plants.
   - Methods: Includes methods to add plants and display user profile information.

4. **Task**: 
   - Attributes: Represents a task with a description and due date.
   - Methods: Implements `Comparable` for sorting tasks by due date.

5. **PlantManagementSystem**: 
   - Attributes: Manages all functionalities, including lists of plants, users, user profiles, and a task queue.
   - Methods: Includes methods for registering plants, adding users, scheduling tasks, and recommending plants.

## Installation

To set up the Plant Management System on your local machine, follow these steps:

1. **Prerequisites**: Ensure you have the Java Development Kit (JDK) installed (version 8 or higher recommended).
   - You can download it from [Oracle's official site](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

2. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/plant-management-system.git
   cd plant-management-system
