
package messageapp;

public class Login {
    private String userName;
    private String password;
    private String phoneNumber;
    private String firstName;
    private String lastName;

    private boolean validUser = false;
    private boolean validPass = false;
    private boolean validPhone = false;

    public void storeNames(String first, String last) {
        firstName = first;
        lastName = last;
    }

    public boolean checkUserName(String username) {

        this.userName = username;

        if (username.contains("_") && username.length() <= 5) {
            validUser = true;
            return true;
        }

        System.out.println("Invalid username.");
        return false;
    }

    public boolean checkPassword(String password) {

        this.password = password;

        boolean upper = true;
        boolean number = false;
        boolean special = false;

        for (int i = 0; i < password.length(); i++) {

            char c = password.charAt(i);

            if (Character.isUpperCase(c)) {
                upper = true;
            }

            if (Character.isDigit(c)) {
                number = true;
            }

            if (!Character.isLetterOrDigit(c)) {
                special = true;
            }
        }

        if (password.length() >= 8 && upper && number && special) {
            validPass = true;
            return true;
        }

        System.out.println("Password incorrectly formatted.");
        return false;
    }

    public boolean checkCellPhoneNumber(String phone) {

        this.phoneNumber = phone;

        if (phone.matches("^\\+27\\d{9}$")) {
            validPhone = true;
            return true;
        }

        System.out.println("Phone number incorrectly formatted.");
        return false;
    }

    public String registerUser() {

        if (validUser && validPass && validPhone) {
            return "User registered successfully.";
        }

        return "Registration failed.";
    }

    public boolean loginUser(String username, String password) {

        return username.equals(userName)
                && password.equals(this.password);
    }
    
}
