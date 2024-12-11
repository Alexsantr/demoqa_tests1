package until;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class TestData {
    Faker faker = new Faker(new Locale("en"));

     public static void main(String[] args) {
         System.out.println(getRandomCity());

    }

 public
        String firstName = faker.name().firstName(), // Emory
         lastName = faker.name().lastName(),
         userEmail = faker.internet().emailAddress(),
         gender = faker.options().option("Male", "Female", "Other"),
         telephoneNumber = faker.phoneNumber().subscriberNumber(10),
         userBirthDay = String.format("%02d", faker.number().numberBetween(1, 28)),
         userBirthMonth = faker.options().option("January", "February", "March", "April",
                 "May", "June", "July", "August", "September", "October", "November", "December"),
         userBirthYear = String.format("%s", faker.number().numberBetween(1920, 2024)),
         subject = faker.options().option("Hindi", "English", "Maths", "Physics", "Chemistry", "Biology",
                 "Computer Science", "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History",
                 "Civics"),
         hobbies = faker.options().option("Sports", "Reading", "Music"),
         picture = faker.options().option("Test.jpg"),
         userAddress = faker.address().fullAddress(),
         userCity = getRandomCity();

    public static String getRandomCity() {
        String[] city = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

        return getRandomItemFromArray(city);
    }

    public static String getRandomItemFromArray(String[] array) {
       int index = getRandomInt(0,array.length - 1);
       return array[index];
}

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }


}








