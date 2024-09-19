import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// Class representing a plant with various attributes
class Plant {
    String name;             // Name of the plant
    String family;           // Family classification of the plant
    String nativeHabitat;    // Natural habitat where the plant is found
    String light;            // Light requirements for the plant
    String soilType;         // Preferred soil type
    String humidity;         // Humidity preference
    String temperature;      // Temperature range the plant thrives in
    String wateringNeeds;    // Watering requirements
    String fertilizationSchedule; // Fertilization needs
    String pruningRequirements; // Pruning guidelines
    String pestInfo;         // Information about pests affecting the plant

    // Constructor to initialize a Plant object with its attributes
    public Plant(String name, String family, String nativeHabitat, String light,
                 String soilType, String humidity, String temperature,
                 String wateringNeeds, String fertilizationSchedule,
                 String pruningRequirements, String pestInfo) {
        this.name = name;
        this.family = family;
        this.nativeHabitat = nativeHabitat;
        this.light = light;
        this.soilType = soilType;
        this.humidity = humidity;
        this.temperature = temperature;
        this.wateringNeeds = wateringNeeds;
        this.fertilizationSchedule = fertilizationSchedule;
        this.pruningRequirements = pruningRequirements;
        this.pestInfo = pestInfo;
    }

    // Returns a string representation of the Plant object
    @Override
    public String toString() {
        return "Plant: " + name + ", Family: " + family + ", Habitat: " + nativeHabitat;
    }
}

// Class representing a user with their details
class User {
    private String userId;       // Unique identifier for the user
    private String name;          // Name of the user
    private String role;          // Role of the user (e.g., Manager, Staff)
    private String contactInfo;   // Contact information for the user

    // Constructor to initialize a User object
    public User(String userId, String name, String role, String contactInfo) {
        this.userId = userId;
        this.name = name;
        this.role = role;
        this.contactInfo = contactInfo;
    }

    // Getters for user attributes
    public String getUserId() { return userId; }
    public String getName() { return name; }
    public String getRole() { return role; }
    public String getContactInfo() { return contactInfo; }
}

// Class representing a user profile that contains a list of plants
class UserProfile {
    String username;           // Username of the profile
    List<Plant> plants;       // List of plants associated with the user

    // Constructor to initialize a UserProfile object
    public UserProfile(String username) {
        this.username = username;
        this.plants = new ArrayList<>(); // Initialize the list of plants
    }

    // Method to add a plant to the user's profile
    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    // Returns a string representation of the UserProfile
    @Override
    public String toString() {
        return "User: " + username + ", Plants: " + plants.size();
    }
}

// Class representing a task with a description and a due date
class Task implements Comparable<Task> {
    String description; // Description of the task
    String date;        // Due date for the task (format: "YYYY-MM-DD")

    // Constructor to initialize a Task object
    public Task(String description, String date) {
        this.description = description;
        this.date = date;
    }

    // Compares tasks based on their due date for priority
    @Override
    public int compareTo(Task other) {
        return this.date.compareTo(other.date); // Sort by date
    }

    // Returns a string representation of the Task
    @Override
    public String toString() {
        return "Task: " + description + " on " + date;
    }
}

// Main class representing the plant management system
public class PlantManagementSystem {
    List<Plant> plantRegistry;          // List of all registered plants
    List<User> users;                    // List of users in the system
    Map<String, Plant> plantLookup;      // Quick lookup for plants by name
    List<UserProfile> userProfiles;      // List of user profiles
    PriorityQueue<Task> taskQueue;       // Queue for managing scheduled tasks

    // Constructor to initialize the PlantManagementSystem
    public PlantManagementSystem() {
        plantRegistry = new ArrayList<>();
        users = new ArrayList<>();
        plantLookup = new HashMap<>();
        userProfiles = new ArrayList<>();
        taskQueue = new PriorityQueue<>();
    }

    // Method to register a new plant in the system
    public void registerPlant(Plant plant) {
        plantRegistry.add(plant);
        plantLookup.put(plant.name, plant); // Add to lookup for quick access
    }

    // Method to add a user to the system
    public void addUser(User user) {
        users.add(user);
    }

    // Method to create a user profile
    public void createUserProfile(String username) {
        userProfiles.add(new UserProfile(username));
    }

    // Method to display all registered plants
    public void displayPlants() {
        for (Plant plant : plantRegistry) {
            System.out.println(plant);
        }
    }

    // Method to find a plant by its name using the lookup map
    public Plant findPlantByName(String name) {
        return plantLookup.get(name); // O(1) access
    }

    // Method to add a task to the task queue
    public void addTask(String description, String date) {
        taskQueue.add(new Task(description, date));
    }

    // Method to display and remove all tasks from the queue
    public void displayTasks() {
        while (!taskQueue.isEmpty()) {
            System.out.println(taskQueue.poll());
        }
    }

    // Method to recommend plants based on light requirements
    public List<Plant> recommendPlants(String lightRequirement) {
        List<Plant> recommendations = new ArrayList<>();
        for (Plant plant : plantRegistry) {
            if (plant.light.equals(lightRequirement)) {
                recommendations.add(plant); // Add plant if it matches the light requirement
            }
        }
        return recommendations;
    }

    // Main method to run the plant management system
    public static void main(String[] args) {
        PlantManagementSystem pms = new PlantManagementSystem();

        // Registering plants with their details
        pms.registerPlant(new Plant("Snowdonia Buttercup", "Ranunculaceae",
                "Alpine meadows in Snowdonia, Wales", "Full sun to partial shade",
                "Regular watering; keep soil moist but not soggy",
                "Moderate", "Warm",
                "Water regularly", "Light fertilization during growing season",
                "Remove dead flowers", "Susceptible to root rot; monitor for aphids"));

        pms.registerPlant(new Plant("Attenborough's Pitcher Plant", "Nepenthaceae",
                "Forests of the Philippines", "Bright, indirect light",
                "Peat-based, well-draining soil", "High (60-80%)",
                "Warm, ideally 20-30 degrees Celsius (68-86 degrees Fahrenheit)", "Use distilled or rainwater; keep soil moist",
                "Light feeding with orchid fertilizer during growing season",
                "Remove dead leaves and pitchers", "Watch for fungal infections; mealybugs"));

        pms.registerPlant(new Plant("Rafflesia arnoldii", "Rafflesiaceae",
                "Rainforests of Sumatra and Borneo", "Low light; thrives in shaded areas",
                "No soil; parasitic on Tetrastigma vines", "High (80-100%)",
                "Warm, ideally 25-30 degrees Celsius (77-86 degrees Fahrenheit)", "Requires high moisture; often dependent on host plant",
                "No fertilization; obtains nutrients from host",
                "Minimal; relies on host plant's health", "Rarely affected; vulnerable to habitat destruction"));

        pms.registerPlant(new Plant("Welwitschia mirabilis", "Welwitschiaceae",
                "Namib Desert, Namibia and Angola", "Full sun",
                "Well-draining, sandy soil", "Low; adapted to arid conditions",
                "Varies; can tolerate extremes (0-40 degrees Celsius)", "Very low; survives on minimal rainfall",
                "Minimal; infrequent, if any",
                "Low; mostly self-sufficient", "Resistant to pests; susceptible to overwatering"));

        pms.registerPlant(new Plant("Corpse Flower", "Araceae",
                "Rainforests of Sumatra", "Bright, indirect light",
                "Rich, well-draining soil", "High (60-90%)",
                "Warm, ideally 20-30 degrees Celsius (68-86 degrees Fahrenheit)", "Keep soil consistently moist, but not soggy",
                "Monthly during growing season with balanced fertilizer",
                "Remove dead foliage and ensure good airflow", "Watch for root rot; susceptible to scale insects"));

        pms.registerPlant(new Plant("Titan Arum", "Araceae",
                "Tropical rainforests of Sumatra", "Indirect sunlight",
                "Moist, rich organic matter", "High (60-85%)",
                "Prefers 20-30 degrees Celsius (68-86 degrees Fahrenheit)", "Regular watering, keep soil moist",
                "High-nitrogen fertilizer every 2-3 weeks during growth",
                "Requires space to grow; prune old leaves", "Prone to fungal infections; monitor for pests"));

        // Adding users to the system
        pms.addUser(new User("U001", "Alice", "Manager", "alice@example.com"));
        pms.addUser(new User("U002", "Bob", "Staff", "bob@example.com"));

        // Create a user profile
        pms.createUserProfile("PlantLover");

        // Display registered plants
        System.out.println("Registered Plants:");
        pms.displayPlants();

        // Adding tasks for plant care
        pms.addTask("Water Snowdonia Buttercup", "2024-09-20");
        pms.addTask("Fertilize Attenborough's Pitcher Plant", "2024-09-22");

        // Display scheduled tasks
        System.out.println("\nScheduled Tasks:");
        pms.displayTasks();

        // Recommend plants based on light requirement
        System.out.println("\nRecommended plants for 'Bright, indirect light':");
        List<Plant> recommendations = pms.recommendPlants("Bright, indirect light");
        for (Plant plant : recommendations) {
            System.out.println(plant);
        }

        // Display registered users
        System.out.println("\nRegistered Users:");
        for (User user : pms.users) {
            System.out.println("User ID: " + user.getUserId() + ", Name: " + user.getName() + ", Role: " + user.getRole());
        }
    }
}

