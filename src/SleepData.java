/**************************
 * @file SleepData.java
 * @brief This program implements a Comparable interface for my chosen Sleep Data theme, which are the objects of csv data that make up my BST - compareTo, toString, and equals methods within this
 * @author John Kaelber
 * @date October 23, 2024
 **************************/
public class SleepData implements Comparable<SleepData> {
    //User ID, Age, Gender, Sleep Quality, Bedtime, Wake-up Time, Daily Steps, Calories Burned, Physical Activity, Dietary Habits, Sleep Disorders, Medication Usage
    private Integer userID; //1
    private Integer age; //2
    private String gender; //3
    private Integer sleepQuality; //4
    private String bedTime; //5
    private String wakeUpTime; //6
    private Integer dailySteps; //7
    private Integer caloriesBurned; //8
    private String physicalActivity; //9
    private String dietaryHabits; //10
    private String sleepDisorders; //11
    private String medicationUsage; //12

    //default constructor
    public SleepData() {
        this.userID = null;
        this.age = null;
        this.gender = null;
        this.sleepQuality = null;
        this.bedTime = null;
        this.wakeUpTime = null;
        this.dailySteps = null;
        this.caloriesBurned = null;
        this.physicalActivity = null;
        this.dietaryHabits = null;
        this.sleepDisorders = null;
        this.medicationUsage = null;
    }

    //Constructor for Sleep Data
    public SleepData(Integer userID, Integer age, String gender, Integer sleepQuality, String bedTime, String wakeUpTime, Integer dailySteps, Integer caloriesBurned, String physicalActivity, String dietaryHabits, String sleepDisorders, String medicationUsage) {
        this.userID = userID;
        this.age = age;
        this.gender = gender;
        this.sleepQuality = sleepQuality;
        this.bedTime = bedTime;
        this.wakeUpTime = wakeUpTime;
        this.dailySteps = dailySteps;
        this.caloriesBurned = caloriesBurned;
        this.physicalActivity = physicalActivity;
        this.dietaryHabits = dietaryHabits;
        this.sleepDisorders = sleepDisorders;
        this.medicationUsage = medicationUsage;
    }
    @Override
    //updated compareTo method for comparing Sleepers by their user IDs
    public int compareTo(SleepData o) { //updated to return corresponding negative, positive, 0 per instructions
        if(this.userID<o.userID){
            return -1;
        }
        else if(this.userID>o.userID){
            return 1;
        }
        return 0;
    }
    @Override
    public String toString() {//format of my choosing to represent the data as a String
        return "User Id: " +userID + " Age: " +age + " Gender: " + gender + " Sleep Quality: " + sleepQuality + " Bed Time: " + bedTime + " Wake-Up Time: " + wakeUpTime + " Daily Steps: " + dailySteps + " Calories Burned: " + caloriesBurned + " Physical Activity: " + physicalActivity + " Dietary Habits: " + dietaryHabits + " Sleep Disorders: " + sleepDisorders + " Medication Usage: " + medicationUsage;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SleepData sleepData = (SleepData) o;
        return userID.equals(sleepData.userID);//do the users' IDs equal one another??? well, use this overridden method to see
    }
    //getters & setters
    public Integer getUserID() {
        return userID;
    }
    public void setUserID(Integer userID) {}

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {}

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {}

    public Integer getSleepQuality() {
        return sleepQuality;
    }
    public void setSleepQuality(Integer sleepQuality) {}

    public String getBedTime() {
        return bedTime;
    }
    public void setBedTime(String bedTime) {}

    public String getWakeUpTime() {
        return wakeUpTime;
    }
    public void setWakeUpTime(String wakeUpTime) {}

    public Integer getDailySteps() {
        return dailySteps;
    }
    public void setDailySteps(Integer dailySteps) {}

    public Integer getCaloriesBurned() {
        return caloriesBurned;
    }
    public void setCaloriesBurned(Integer caloriesBurned) {}

    public String getPhysicalActivity() {
        return physicalActivity;
    }
    public void setPhysicalActivity(String physicalActivity) {}

    public String getDietaryHabits() {
        return dietaryHabits;
    }
    public void setDietaryHabits(String dietaryHabits) {}

    public String getSleepDisorders() {
        return sleepDisorders;
    }
    public void setSleepDisorders(String sleepDisorders) {}

    public String getMedicationUsage() {
        return medicationUsage;
    }
    public void setMedicationUsage(String medicationUsage) {}

}