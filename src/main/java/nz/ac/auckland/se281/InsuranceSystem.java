package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.PolicyType;

public class InsuranceSystem {

  ArrayList<Profile> profile = new ArrayList<Profile>();
  // create an array list of type Details to store the details of the policy
  ArrayList<Details> details = new ArrayList<Details>();

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).

  }

  public void printDatabase() {
    // check if there are any profiles in names arraylist
    if (profile.size() == 0) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");
      return;

    } else if (profile.size() == 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", "", ":");
      // size of the policy order
      int size = (profile.get(0).getPolicyOrder().size());

      // check if the isloaded a and had one policy
      if ((profile.get(0).getIsLoaded()) && (size == 1)) {
        MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
            "*** ",
            "1",
            profile.get(0).getName(),
            String.valueOf(profile.get(0).getAge()),
            String.valueOf(size),
            "y",
            String.valueOf(profile.get(0).getDiscountValue()));

        // check if the policy is home

        if (profile.get(0).getDetails().get(0).getPolicyType().equals("home")) {
          MessageCli.PRINT_DB_HOME_POLICY.printMessage(
              profile.get(0).getDetails().get(0).getAddress(),
              profile.get(0).getDetails().get(0).getSumInsured(),
              (String.valueOf(profile.get(0).getDetails().get(0).getPremiume())),
              (String.valueOf(profile.get(0).getDetails().get(0).getPremiume())));
        } else if ((profile
            .get(0)
            .getPolicyOrder()
            .get(0)
            .equals("car"))) { // check if the policy is car
          MessageCli.PRINT_DB_CAR_POLICY.printMessage(
              profile.get(0).getDetails().get(0).getMakeModel(),
              profile.get(0).getDetails().get(0).getSumInsured(),
              (String.valueOf(profile.get(0).getDetails().get(0).getPremiume())),
              (String.valueOf(
                  profile
                      .get(0)
                      .getDetails()
                      .get(0)
                      .getPremiume()))); // print the detials of the policy
        } else {
          // check if the policy is life
          MessageCli.PRINT_DB_LIFE_POLICY.printMessage(
              profile.get(0).getDetails().get(0).getSumInsured(),
              (String.valueOf(profile.get(0).getDetails().get(0).getPremiume())),
              (String.valueOf(
                  profile
                      .get(0)
                      .getDetails()
                      .get(0)
                      .getPremiume()))); // print the detials of the policy
        }

        return;
      } else if ((profile.get(0).getIsLoaded())
          && (size != 1)) { // if the profile has more than one polciy  print the number of policies
        MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
            "*** ",
            "1",
            profile.get(0).getName(),
            String.valueOf(profile.get(0).getAge()),
            String.valueOf(size),
            "ies",
            String.valueOf(profile.get(0).getDiscountValue()));

        if (size == 0) {
          return;
        } else if (size == 2) { // if the profile has two policies

          for (int i = 0; i < size; i++) {
            int discounted =
                (int) ((profile.get(0).getDetails().get(i).getPremiume()) * 0.9); // discount 10%
            if (profile
                .get(0)
                .getDetails()
                .get(i)
                .getPolicyType()
                .equals("home")) { // check the policy type is home
              MessageCli.PRINT_DB_HOME_POLICY.printMessage(
                  profile.get(0).getDetails().get(i).getAddress(),
                  profile.get(0).getDetails().get(i).getSumInsured(),
                  (String.valueOf(profile.get(0).getDetails().get(i).getPremiume())),
                  (String.valueOf(discounted)));
            } else if (profile
                .get(0)
                .getDetails()
                .get(i)
                .getPolicyType()
                .equals("car")) { // check the policy type is car
              MessageCli.PRINT_DB_CAR_POLICY.printMessage(
                  profile.get(0).getDetails().get(i).getMakeModel(),
                  profile.get(0).getDetails().get(i).getSumInsured(),
                  (String.valueOf(profile.get(0).getDetails().get(i).getPremiume())),
                  (String.valueOf(discounted)));
            } else {
              // check the policy type is life
              MessageCli.PRINT_DB_LIFE_POLICY.printMessage(
                  profile.get(0).getDetails().get(i).getSumInsured(),
                  (String.valueOf(profile.get(0).getDetails().get(i).getPremiume())),
                  (String.valueOf(discounted)));
            }
          }
        } else {
          for (int i = 0; i < size; i++) { // if the profile has more than two policies
            int discounted =
                (int) ((profile.get(0).getDetails().get(i).getPremiume()) * 0.8); // discount 20%
            if (profile
                .get(0)
                .getDetails()
                .get(i)
                .getPolicyType()
                .equals("home")) { // check the policy type is home
              MessageCli.PRINT_DB_HOME_POLICY.printMessage(
                  profile.get(0).getDetails().get(i).getAddress(),
                  profile.get(0).getDetails().get(i).getSumInsured(),
                  (String.valueOf(profile.get(0).getDetails().get(i).getPremiume())),
                  (String.valueOf(discounted)));
            } else if ((profile
                .get(0)
                .getDetails()
                .get(i)
                .getPolicyType()
                .equals("car"))) { // check the policy type is car
              MessageCli.PRINT_DB_CAR_POLICY.printMessage(
                  profile.get(0).getDetails().get(i).getMakeModel(),
                  profile.get(0).getDetails().get(i).getSumInsured(),
                  (String.valueOf(profile.get(0).getDetails().get(i).getPremiume())),
                  (String.valueOf(discounted)));
            } else {
              // check the policy type is life
              MessageCli.PRINT_DB_LIFE_POLICY.printMessage(
                  profile.get(0).getDetails().get(i).getSumInsured(),
                  (String.valueOf(profile.get(0).getDetails().get(i).getPremiume())),
                  (String.valueOf(discounted)));
            }
          }
        }
        return;
      } else if ((profile.get(0).getIsLoaded()
              == false) // if the profile is not loaded and has one policy
          && ((profile.get(0).getPolicyOrder().size() == 1))) {

        // print out the message
        MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
            "",
            "1",
            profile.get(0).getName(),
            String.valueOf(profile.get(0).getAge()),
            String.valueOf(size),
            "y",
            String.valueOf(profile.get(0).getDiscountValue()));
        /* check for the policy type and print the corresponding message */
        if (profile.get(0).getDetails().get(0).getPolicyType().equals("home")) {
          MessageCli.PRINT_DB_HOME_POLICY.printMessage(
              profile.get(0).getDetails().get(0).getAddress(),
              profile.get(0).getDetails().get(0).getSumInsured(),
              (String.valueOf(profile.get(0).getDetails().get(0).getPremiume())),
              (String.valueOf(profile.get(0).getDetails().get(0).getPremiume())));
        } else if ((profile.get(0).getPolicyOrder().get(0).equals("car"))) {
          MessageCli.PRINT_DB_CAR_POLICY.printMessage(
              profile.get(0).getDetails().get(0).getMakeModel(),
              profile.get(0).getDetails().get(0).getSumInsured(),
              (String.valueOf(profile.get(0).getDetails().get(0).getPremiume())),
              (String.valueOf(profile.get(0).getDetails().get(0).getPremiume())));
        } else {
          MessageCli.PRINT_DB_LIFE_POLICY.printMessage(
              profile.get(0).getDetails().get(0).getSumInsured(),
              (String.valueOf(profile.get(0).getDetails().get(0).getPremiume())),
              (String.valueOf(profile.get(0).getDetails().get(0).getPremiume())));
        }
        return;
      } else if ((profile.get(0).getIsLoaded()
              == false) // when the profile is unloaded and has more than one policy
          && ((profile.get(0).getPolicyOrder().size() != 1))) {
        // print out the message
        MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
            "",
            "1",
            profile.get(0).getName(),
            String.valueOf(profile.get(0).getAge()),
            String.valueOf(size),
            "ies",
            String.valueOf(profile.get(0).getDiscountValue()));

        /*check for the number of polcies and accordingly calculate
        the discount and check for type then print out the messae */
        if (profile.get(0).getPolicyOrder().size() == 0) {
          return;
        } else if (profile.get(0).getPolicyOrder().size() == 2) {

          for (int i = 0; i < size; i++) {
            int discounted = (int) ((profile.get(0).getDetails().get(i).getPremiume()) * 0.9);
            if (profile.get(0).getDetails().get(i).getPolicyType().equals("home")) {
              MessageCli.PRINT_DB_HOME_POLICY.printMessage(
                  profile.get(0).getDetails().get(i).getAddress(),
                  profile.get(0).getDetails().get(i).getSumInsured(),
                  (String.valueOf(profile.get(0).getDetails().get(i).getPremiume())),
                  (String.valueOf(discounted)));
            } else if (profile.get(0).getDetails().get(i).getPolicyType().equals("car")) {
              MessageCli.PRINT_DB_CAR_POLICY.printMessage(
                  profile.get(0).getDetails().get(i).getMakeModel(),
                  profile.get(0).getDetails().get(i).getSumInsured(),
                  (String.valueOf(profile.get(0).getDetails().get(i).getPremiume())),
                  (String.valueOf(discounted)));
            } else {
              MessageCli.PRINT_DB_LIFE_POLICY.printMessage(
                  profile.get(0).getDetails().get(i).getSumInsured(),
                  (String.valueOf(profile.get(0).getDetails().get(i).getPremiume())),
                  (String.valueOf(discounted)));
            }
          }
        } else {
          for (int i = 0; i < size; i++) {
            int discounted =
                (int)
                    ((profile.get(0).getDetails().get(i).getPremiume())
                        * 0.8); // calculate the discount
            if (profile.get(0).getDetails().get(i).getPolicyType().equals("home")) {
              MessageCli.PRINT_DB_HOME_POLICY.printMessage(
                  profile.get(0).getDetails().get(i).getAddress(),
                  profile.get(0).getDetails().get(i).getSumInsured(),
                  (String.valueOf(profile.get(0).getDetails().get(i).getPremiume())),
                  (String.valueOf(discounted)));
            } else if ((profile.get(0).getDetails().get(i).getPolicyType().equals("car"))) {
              MessageCli.PRINT_DB_CAR_POLICY.printMessage(
                  profile.get(0).getDetails().get(i).getMakeModel(),
                  profile.get(0).getDetails().get(i).getSumInsured(),
                  (String.valueOf(profile.get(0).getDetails().get(i).getPremiume())),
                  (String.valueOf(discounted)));
            } else {
              MessageCli.PRINT_DB_LIFE_POLICY.printMessage(
                  profile.get(0).getDetails().get(i).getSumInsured(),
                  (String.valueOf(profile.get(0).getDetails().get(i).getPremiume())),
                  (String.valueOf(discounted)));
            }
          }
        }
        return;
      }

    } else if (profile.size() > 1) { // when there is more than one profile in the database
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(
          String.valueOf(profile.size()), "s", ":"); // print out a header message
      for (int i = 0; i < profile.size(); i++) {
        // size of the policy order
        int size = (profile.get(i).getPolicyOrder().size());
        // check if the name isloded
        if ((profile.get(i).getIsLoaded()) && (size == 1)) {
          MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
              "*** ",
              String.valueOf(i + 1),
              profile.get(i).getName(),
              String.valueOf(profile.get(i).getAge()),
              String.valueOf(size),
              "y",
              String.valueOf(profile.get(i).getDiscountValue()));
          /*check for the policy time and print out the message accordingly  */
          if (profile.get(i).getDetails().get(0).getPolicyType().equals("home")) {
            MessageCli.PRINT_DB_HOME_POLICY.printMessage(
                profile.get(i).getDetails().get(0).getAddress(),
                profile.get(i).getDetails().get(0).getSumInsured(),
                (String.valueOf(profile.get(i).getDetails().get(0).getPremiume())),
                (String.valueOf(profile.get(i).getDetails().get(0).getPremiume())));
          } else if (profile.get(i).getDetails().get(0).getPolicyType().equals("car")) {
            MessageCli.PRINT_DB_CAR_POLICY.printMessage(
                profile.get(i).getDetails().get(0).getMakeModel(),
                profile.get(i).getDetails().get(0).getSumInsured(),
                (String.valueOf(profile.get(i).getDetails().get(0).getPremiume())),
                (String.valueOf(profile.get(i).getDetails().get(0).getPremiume())));
          } else {
            MessageCli.PRINT_DB_LIFE_POLICY.printMessage(
                profile.get(i).getDetails().get(0).getSumInsured(),
                (String.valueOf(profile.get(i).getDetails().get(0).getPremiume())),
                (String.valueOf(profile.get(i).getDetails().get(0).getPremiume())));
            ;
          }
        } else if ((profile.get(i).getIsLoaded())
            && (size
                != 1)) { // when one of the profiles is loaded and hase more or less than one policy
          // print out the apporiate message
          MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
              "*** ",
              String.valueOf(i + 1),
              profile.get(i).getName(),
              String.valueOf(profile.get(i).getAge()),
              String.valueOf(size),
              "ies",
              String.valueOf(profile.get(i).getDiscountValue()));
          /*by checking the numebr of policies for each profile we can calculate
          the discount nd print it out as part of the policy detials  */
          if (size == 0) {
            return;
          } else if (size == 2) {

            for (int j = 0; j < size; j++) {
              int discounted =
                  (int)
                      ((profile.get(i).getDetails().get(j).getPremiume())
                          * 0.9); // calculate the discount
              if (profile.get(i).getDetails().get(j).getPolicyType().equals("home")) {
                MessageCli.PRINT_DB_HOME_POLICY.printMessage(
                    profile.get(i).getDetails().get(j).getAddress(),
                    profile.get(i).getDetails().get(j).getSumInsured(),
                    (String.valueOf(profile.get(i).getDetails().get(j).getPremiume())),
                    (String.valueOf(discounted)));
              } else if (profile.get(i).getDetails().get(j).getPolicyType().equals("car")) {
                MessageCli.PRINT_DB_CAR_POLICY.printMessage(
                    profile.get(i).getDetails().get(j).getMakeModel(),
                    profile.get(i).getDetails().get(j).getSumInsured(),
                    (String.valueOf(profile.get(i).getDetails().get(j).getPremiume())),
                    (String.valueOf(discounted)));
              } else {
                MessageCli.PRINT_DB_LIFE_POLICY.printMessage(
                    profile.get(i).getDetails().get(j).getSumInsured(),
                    (String.valueOf(profile.get(i).getDetails().get(j).getPremiume())),
                    (String.valueOf(discounted)));
              }
            }
          } else {
            for (int j = 0; j < size; j++) {
              int discounted =
                  (int)
                      ((profile.get(i).getDetails().get(j).getPremiume())
                          * 0.8); // calculate the discount
              if (profile.get(i).getDetails().get(j).getPolicyType().equals("home")) {
                MessageCli.PRINT_DB_HOME_POLICY.printMessage(
                    profile.get(i).getDetails().get(j).getAddress(),
                    profile.get(i).getDetails().get(j).getSumInsured(),
                    (String.valueOf(profile.get(i).getDetails().get(j).getPremiume())),
                    (String.valueOf(discounted)));

              } else if (profile.get(i).getDetails().get(j).getPolicyType().equals("car")) {
                MessageCli.PRINT_DB_CAR_POLICY.printMessage(
                    profile.get(i).getDetails().get(j).getMakeModel(),
                    profile.get(i).getDetails().get(j).getSumInsured(),
                    (String.valueOf(profile.get(i).getDetails().get(j).getPremiume())),
                    (String.valueOf(discounted)));

              } else {
                MessageCli.PRINT_DB_LIFE_POLICY.printMessage(
                    profile.get(i).getDetails().get(j).getSumInsured(),
                    (String.valueOf(profile.get(i).getDetails().get(j).getPremiume())),
                    (String.valueOf(discounted)));
              }
            }
          }
        } else if ((profile.get(i).getIsLoaded()
                == false) // when one of the profiles is not loaded and has one policy
            && ((profile.get(i).getPolicyOrder().size() == 1))) {
          // print out the apporiate message
          MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
              "",
              String.valueOf(i + 1),
              profile.get(i).getName(),
              String.valueOf(profile.get(i).getAge()),
              String.valueOf(size),
              "y",
              String.valueOf(profile.get(i).getDiscountValue()));

          // check for the policy type and print out the apporiate message
          if (profile.get(i).getDetails().get(0).getPolicyType().equals("home")) {
            MessageCli.PRINT_DB_HOME_POLICY.printMessage(
                profile.get(i).getDetails().get(0).getAddress(),
                profile.get(i).getDetails().get(0).getSumInsured(),
                (String.valueOf(profile.get(i).getDetails().get(0).getPremiume())),
                (String.valueOf(profile.get(i).getDetails().get(0).getPremiume())));
          } else if (profile.get(i).getDetails().get(0).getPolicyType().equals("car")) {
            MessageCli.PRINT_DB_CAR_POLICY.printMessage(
                profile.get(i).getDetails().get(0).getMakeModel(),
                profile.get(i).getDetails().get(0).getSumInsured(),
                (String.valueOf(profile.get(i).getDetails().get(0).getPremiume())),
                (String.valueOf(profile.get(i).getDetails().get(0).getPremiume())));
          } else {
            MessageCli.PRINT_DB_LIFE_POLICY.printMessage(
                profile.get(i).getDetails().get(0).getSumInsured(),
                (String.valueOf(profile.get(i).getDetails().get(0).getPremiume())),
                (String.valueOf(profile.get(i).getDetails().get(0).getPremiume())));
            ;
          }
        } else if ((profile.get(i).getIsLoaded()
                == false) // if the profile is not loaded and has more than one policy
            && ((profile.get(i).getPolicyOrder().size() != 1))) {
          //  print out the apporiate message
          MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage(
              "",
              String.valueOf(i + 1),
              profile.get(i).getName(),
              String.valueOf(profile.get(i).getAge()),
              String.valueOf(size),
              "ies",
              String.valueOf(profile.get(i).getDiscountValue()));

          /*check the numer of polcies for each profile and then calculate
          the discount and print out the appropriate message */
          if (profile.get(i).getPolicyOrder().size() == 0) {

          } else if (profile.get(i).getPolicyOrder().size() == 2) {

            for (int j = 0; j < size; j++) {
              int discounted =
                  (int)
                      ((profile.get(i).getDetails().get(j).getPremiume())
                          * 0.9); // calculate the discount
              if (profile.get(i).getDetails().get(j).getPolicyType().equals("home")) {
                MessageCli.PRINT_DB_HOME_POLICY.printMessage(
                    profile.get(i).getDetails().get(j).getAddress(),
                    profile.get(i).getDetails().get(j).getSumInsured(),
                    (String.valueOf(profile.get(i).getDetails().get(j).getPremiume())),
                    (String.valueOf(discounted)));
              } else if (profile.get(i).getDetails().get(j).getPolicyType().equals("car")) {
                MessageCli.PRINT_DB_CAR_POLICY.printMessage(
                    profile.get(i).getDetails().get(j).getMakeModel(),
                    profile.get(i).getDetails().get(j).getSumInsured(),
                    (String.valueOf(profile.get(i).getDetails().get(j).getPremiume())),
                    (String.valueOf(discounted)));
              } else {
                MessageCli.PRINT_DB_LIFE_POLICY.printMessage(
                    profile.get(i).getDetails().get(j).getSumInsured(),
                    (String.valueOf(profile.get(i).getDetails().get(j).getPremiume())),
                    (String.valueOf(discounted)));
              }
            }
          } else {
            for (int j = 0; j < size; j++) { // when its more than 3 polcies
              int discounted =
                  (int)
                      ((profile.get(i).getDetails().get(j).getPremiume())
                          * 0.8); // calculate the discount
              if (profile.get(i).getDetails().get(j).getPolicyType().equals("home")) {
                MessageCli.PRINT_DB_HOME_POLICY.printMessage(
                    profile.get(i).getDetails().get(j).getAddress(),
                    profile.get(i).getDetails().get(j).getSumInsured(),
                    (String.valueOf(profile.get(i).getDetails().get(j).getPremiume())),
                    (String.valueOf(discounted)));

              } else if (profile.get(i).getDetails().get(j).getPolicyType().equals("car")) {
                MessageCli.PRINT_DB_CAR_POLICY.printMessage(
                    profile.get(i).getDetails().get(j).getMakeModel(),
                    profile.get(i).getDetails().get(j).getSumInsured(),
                    (String.valueOf(profile.get(i).getDetails().get(j).getPremiume())),
                    (String.valueOf(discounted)));

              } else {
                MessageCli.PRINT_DB_LIFE_POLICY.printMessage(
                    profile.get(i).getDetails().get(j).getSumInsured(),
                    (String.valueOf(profile.get(i).getDetails().get(j).getPremiume())),
                    (String.valueOf(discounted)));
              }
            }
          }
        }
      }
    }
  }

  public void createNewProfile(String userName, String age) {

    // converting the age string to an integer
    int userAge = Integer.parseInt(age);

    // converting the name to lower case
    String username = userName.toLowerCase();
    // converting the first letter to upper case
    username = username.substring(0, 1).toUpperCase() + username.substring(1);

    // checking if the name is already in the array list
    for (int i = 0; i < profile.size(); i++) {
      if (profile.get(i).getName().equals(username)) {
        MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(username);
        return;
      }
    }

    // checking if any name is loaded
    for (int j = 0; j < profile.size(); j++) {
      if (profile.get(j).getIsLoaded()) {
        String loadedName = profile.get(j).getName();
        MessageCli.CANNOT_CREATE_WHILE_LOADED.printMessage(loadedName);
        return;
      }
    }

    // checking if the name has at least 3 characters
    if (username.length() < 3) {
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(username);
      return;
    } else if (userAge < 0) { // checking if age is valid
      MessageCli.INVALID_AGE.printMessage(age, username);
      return;
    } else { // if the age and name are valid add them to the array list.
      profile.add(new Profile(username, userAge));
      MessageCli.PROFILE_CREATED.printMessage(username, age);
    }
  }

  public void loadProfile(String userName) {
    // converting the name to lower case
    String username = userName.toLowerCase();
    // converting the first letter to upper case
    username = username.substring(0, 1).toUpperCase() + username.substring(1);
    // initialsing a vraible that checks if the name is found
    int found = 0;
    // checking if the name is already in the array list
    for (int i = 0; i < profile.size(); i++) {
      if (profile.get(i).getName().equals(username)) {
        MessageCli.PROFILE_LOADED.printMessage(username);

        // check if any of the other profiles have isloaded set to true
        for (int j = 0; j < profile.size(); j++) {
          if (profile.get(j).getIsLoaded() == true) {
            // change the isLoaded variable to false
            profile.get(j).setIsLoaded(false);
          }
        }

        // change the isLoaded variable to true
        profile.get(i).setIsLoaded(true);

        found++;
        return;
      }
    }
    if (found == 0) {
      MessageCli.NO_PROFILE_FOUND_TO_LOAD.printMessage(username);
      return;
    }
  }

  public void unloadProfile() {
    // check if any of the profiles isloaded
    for (int j = 0; j < profile.size(); j++) {
      if (profile.get(j).getIsLoaded() == true) {
        // change the isLoaded variable to false
        profile.get(j).setIsLoaded(false);
        String loadedName = profile.get(j).getName();
        MessageCli.PROFILE_UNLOADED.printMessage(loadedName);
        return;
      }
    }
    MessageCli.NO_PROFILE_LOADED.printMessage();
  }

  public void deleteProfile(String userName) {
    // converting the name to lower case
    String username = userName.toLowerCase();
    // converting the first letter to upper case
    username = username.substring(0, 1).toUpperCase() + username.substring(1);

    // initialsing count for the deleted profiles
    int count = 0;

    // check if the name in the array list and delete it
    for (int i = 0; i < profile.size(); i++) {
      if ((profile.get(i).getName().equals(username)) && (profile.get(i).getIsLoaded() == false)) {
        profile.remove(i);
        MessageCli.PROFILE_DELETED.printMessage(username);
        count++;
        return;
      } else if ((profile.get(i).getName().equals(username))
          && (profile.get(i).getIsLoaded() == true)) {
        MessageCli.CANNOT_DELETE_PROFILE_WHILE_LOADED.printMessage(username);
        count++;
        return;
      }
    }

    if (count == 0) {
      MessageCli.NO_PROFILE_FOUND_TO_DELETE.printMessage(username);
      return;
    }
  }

  public void createPolicy(PolicyType type, String[] options) {
    // initialse a variable
    int count = 0;
    int loadedAge = 0;
    String loadedName = "";
    int result = 0;

    // check if any of the profiles isloaded
    for (int j = 0; j < profile.size(); j++) {
      if (profile.get(j).getIsLoaded() == true) {
        // get the name of the profile
        loadedName = profile.get(j).getName();
        // get the age of the profile
        loadedAge = profile.get(j).getAge();

        count++;

        // creating a home policy
        if (type == PolicyType.HOME) {
          // changing the type of varaibles in the string
          int sumInsured = Integer.parseInt(options[0]);
          String address = options[1];
          boolean rental = options[2].toLowerCase().charAt(0) == 'y';

          // creating a home policy names after the loaded profile
          HomePolicy homePolicy = new HomePolicy(sumInsured, address, rental);

          // calculating the base premium
          result = homePolicy.getBasePremium();
          profile.get(j).setSum(result);

          // store the details of the policy in the Detials Array
          profile.get(j).setDetials("home", options[0], options[1], "", result);

          // add the policy to the policyOrder array list
          profile.get(j).setPolicyOrder("home");

          // sent a message that policy is created
          MessageCli.NEW_POLICY_CREATED.printMessage("home", loadedName);
          return;

        } else if (type == PolicyType.CAR) {
          // changing the type of varaibles in the string
          int sumInsured = Integer.parseInt(options[0]);
          String make = options[1];
          String lisencePlate = options[2];
          boolean mechanicalBreakdown = options[3].toLowerCase().charAt(0) == 'y';

          // creating a car policy
          CarPolicy carPolicy =
              new CarPolicy(sumInsured, make, lisencePlate, mechanicalBreakdown, loadedAge);

          // calcualte the base permium
          result = carPolicy.getBasePremium();
          profile.get(j).setSum(result);

          // add the policy to the policyOrder array list
          profile.get(j).setPolicyOrder("car");

          // store the details of the policy in the Detials Array
          profile.get(j).setDetials("car", options[0], "", options[1], result);

          // sent a message that policy is created
          MessageCli.NEW_POLICY_CREATED.printMessage("car", loadedName);

          return;
        } else if (type == PolicyType.LIFE) {
          // changing the type of varaibles in the string
          int sumInsured = Integer.parseInt(options[0]);

          if (loadedAge > 100) {
            MessageCli.OVER_AGE_LIMIT_LIFE_POLICY.printMessage(loadedName);
            return;
          } else if (profile.get(j).getIsLife() == true) {
            // printout a message
            MessageCli.ALREADY_HAS_LIFE_POLICY.printMessage(loadedName);
            return;
          }

          // creating a life policy
          LifePolicy lifePolicy = new LifePolicy(sumInsured, loadedAge);

          // calcualte the base permium
          result = lifePolicy.getBasePremium();
          profile.get(j).setSum(result);

          // counting the number of life policies
          if (profile.get(j).getIsLife() == false) {
            profile.get(j).setIsLife(true);
          }

          // add the policy to the policyOrder array list
          profile.get(j).setPolicyOrder("life");

          // store the details of the policy in the Detials Array
          profile.get(j).setDetials("life", options[0], "", "", result);

          // sent a message that policy is created
          MessageCli.NEW_POLICY_CREATED.printMessage("life", loadedName);
        }
      }
    }

    if (count == 0) {
      MessageCli.NO_PROFILE_FOUND_TO_CREATE_POLICY.printMessage();
      return;
    }
  }
}
