package gr.uoa.di.rent.config;

public class Constraint {

    /*Username Constraints * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * /
     * Front end: ^[a-z\d\.]{5,}$
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    public final static String USERNAME_PATTERN = "^[a-zA-Z\\d\\.]{5,}$";
    public final static String USERNAME_PATTERN_MESSAGE = "Username must consists at least 5 characters (a-z, A-Z, 0-9) and/or (\".\") between them!";
    public final static int USERNAME_MIN = 5;
    public final static int USERNAME_MAX = 20;

    /*Email Constraints * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    public final static int EMAIL_MIN = 6;
    public final static int EMAIL_MAX = 60;
    public final static String EMAIL_PATTERN_MESSAGE = "Invalid email pattern, e.g myemail@email.com";
    public final static String EMAIL_MIN_MAX_MESSAGE = "Email length must be between " + EMAIL_MIN + " and " + EMAIL_MAX + " characters!";

    /*Password Constraints * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * /
     * Front end: /(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$/
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    public final static int PASSWORD_MIN = 8;
    public final static int PASSWORD_MAX = 20;
    public final static String PASSWORD_PATTERN = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";
    public final static String PASSWORD_PATTERN_MESSAGE = "Valid passwords must be a mix of upper case, lower case, number/special characters!";
    public final static String PASSWORD_MIN_MAX_MESSAGE = "Password length must be between " + PASSWORD_MIN + " and " + PASSWORD_MAX + " characters!";

    /*Firstname Constraints * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * /
     * Front end: /^([A-ZΑ-Ω]){1}[^0-9]*$/
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    public final static String FIRSTNAME_PATTERN = "^([A-Za-zΑ-Ωα-ω]){1}[^0-9]*$";
    public final static int FIRSTNAME_MIN = 2;
    public final static int FIRSTNAME_MAX = 45;
    public final static String FIRSTNAME_PATTERN_MESSAGE = "A valid firstname must consist only of alphabet characters!";
    public final static String FIRSTNAME_MIN_MAX_MESSAGE = "Firstname length must be between " + FIRSTNAME_MIN + " and " + FIRSTNAME_MAX + " characters!";

    /*Lastname Constraints * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * /
     * Front end: /^([A-ZΑ-Ω]){1}[^0-9]*$/
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    public final static int LASTNAME_MAX = 45;
    public final static int LASTNAME_MIN = 2;
    public final static String LASTNAME_PATTERN = "^([A-Za-zΑ-Ωα-ω]){1}[^0-9]*$";
    public final static String LASTNAME_PATTERN_MESSAGE = "A valid lastname must consist only of alphabet characters!";
    public final static String LASTNAME_MIN_MAX_MESSAGE = "Firstname length must be between " + LASTNAME_MIN + " and " + LASTNAME_MAX + " characters!";

    public final static String BIRTHDAY_PATTERN = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$\n";
    public final static String BIRTHDAY_PATTERN_MESSAGE = "Birthday must be a date of format YYYY-MM-DD or yyyy-m-d!";

    /*Phone Constraints * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * /
     * Front end: /^(?=^.{10,10}$)[0-9]*$/
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    public final static int PHONE_MIN = 10;
    public final static int PHONE_MAX = 10;
    public final static String PHONE_PATTERN = "^(?=^.{10,10}$)[0-9]*$";
    public final static String PHONE_PATTERN_MESSAGE = "A valid phone must consist exactly 10 numbers!";
    public final static String PHONE_MIN_MAX_MESSAGE = "Phone length must be between " + PHONE_MIN + " and " + PHONE_MAX + " characters!";

    public final static String COMPANY_NAME_PATTERN = "^([A-Za-zΑ-Ωα-ω]){1}[^0-9]*$";
    public final static int COMPANY_NAME_MIN = 2;
    public final static int COMPANY_NAME_MAX = 45;
    public final static String COMPANY_NAME_PATTERN_MESSAGE = "A valid company name must consist only of alphabet characters!";
    public final static String COMPANY_NAME_MIN_MAX_MESSAGE = "Company name length must be between " + COMPANY_NAME_MIN + " and " + COMPANY_NAME_MAX + " characters!";

    public final static String COMPANY_ADDRESS_PATTERN = "^([A-Za-zΑ-Ωα-ω]){1}[^0-9]*$";
    public final static int COMPANY_ADDRESS_MIN = 2;
    public final static int COMPANY_ADDRESS_MAX = 45;
    public final static String COMPANY_ADDRESS_PATTERN_MESSAGE = "A valid company address must consist only of alphabet characters!";
    public final static String COMPANY_ADDRESS_MIN_MAX_MESSAGE = "Company address length must be between " + COMPANY_ADDRESS_MIN + " and " + COMPANY_ADDRESS_MAX + " characters!";

    public final static String TAX_NUMBER_PATTERN = "^[0-9]*$";
    public final static int TAX_NUMBER_MIN = 9;
    public final static int TAX_NUMBER_MAX = 9;
    public final static String TAX_NUMBER_PATTERN_MESSAGE = "A valid tax number must be 9 numbers!";
    public final static String TAX_NUMBER_MIN_MAX_MESSAGE = "Tax number length must be between " + TAX_NUMBER_MIN + " and " + TAX_NUMBER_MAX + " characters!";

    public final static String TAX_OFFICE_PATTERN = "^([A-Za-zΑ-Ωα-ω]){1}[^0-9]*$";
    public final static int TAX_OFFICE_MIN = 2;
    public final static int TAX_OFFICE_MAX = 45;
    public final static String TAX_OFFICE_PATTERN_MESSAGE = "A valid tax office must consist only of alphabet characters!";
    public final static String TAX_OFFICE_MIN_MAX_MESSAGE = "Tax office length must be between " + TAX_OFFICE_MIN + " and " + TAX_OFFICE_MAX + " characters!";

    public final static String PATRONYM_PATTERN = "^([A-Za-zΑ-Ωα-ω]){1}[^0-9]*$";
    public final static int PATRONYM_MIN = 2;
    public final static int PATRONYM_MAX = 45;
    public final static String PATRONYM_PATTERN_MESSAGE = "A valid patronym must consist only of alphabet characters!";
    public final static String PATRONYM_MIN_MAX_MESSAGE = "Tax patronym length must be between " + PATRONYM_MIN + " and " + PATRONYM_MAX + " characters!";

    public final static String ID_CARD_NUMBER_PATTERN = "^([A-Za-zΑ-Ωα-ω]){1}[^0-9]*$";
    public final static int ID_CARD_NUMBER_MIN = 2;
    public final static int ID_CARD_NUMBER_MAX = 45;
    public final static String ID_CARD_NUMBER_PATTERN_MESSAGE = "A valid id card number must consist only of alphabet characters!";
    public final static String ID_CARD_NUMBER_MIN_MAX_MESSAGE = "Id card number length must be between " + ID_CARD_NUMBER_MIN + " and " + ID_CARD_NUMBER_MAX + " characters!";

    public final static String ID_CARD_DATE_OF_ISSUE_PATTERN = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$\n";
    public final static String ID_CARD_DATE_OF_ISSUE_PATTERN_MESSAGE = "Id card date of issue must be a date of format YYYY-MM-DD or yyyy-m-d!";

    public final static String RESIDENCE_ADDRESS_PATTERN = "^([A-Za-zΑ-Ωα-ω]){1}[^0-9]*$";
    public final static int RESIDENCE_ADDRESS_MIN = 2;
    public final static int RESIDENCE_ADDRESS_MAX = 45;
    public final static String RESIDENCE_ADDRESS_PATTERN_MESSAGE = "A valid residence address must consist only of alphabet characters!";
    public final static String RESIDENCE_ADDRESS_MIN_MAX_MESSAGE = "Residence address length must be between " + RESIDENCE_ADDRESS_MIN + " and " + RESIDENCE_ADDRESS_MAX + " characters!";

    /*Locations Constraints*/
    public final static int ROUTE_MAX = 45;
    public final static int STREET_MAX = 45;
    public final static int LOCALITY_MAX = 45;
    public final static int COUNTRY_MAX = 45;
    public final static int POSTAL_CODE_MAX = 10;
    public final static int FORMATTED_ADRESS_MAX = 200;
    public final static int ADMINISTRATIVE_AREA_LEVEL_MAX = 50;

    public final static int TOKEN_MAX = 255;

    public final static int RATING_MIN = 0;
    public final static int RATING_MAX = 5;
    public final static String RATING_MIN_MAX_MESSAGE = "Rating value must be between " + RATING_MIN + " and " + RATING_MAX + "!";

}
