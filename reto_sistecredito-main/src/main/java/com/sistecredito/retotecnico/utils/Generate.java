package com.sistecredito.retotecnico.utils;

import com.github.javafaker.Faker;
import com.sistecredito.retotecnico.models.*;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Generate {

    private static final Faker FAKER = new Faker(new Locale("es"));
    private Generate(){}
    public static Client newClient(){
        return new Client(
                user(),
                personal(),
                location(),
                familyReference(),
                occupation());    }

    public static Credit newCredit(){
        return new Credit(""+FAKER.number().numberBetween(100000,120000),"Mensual",""+FAKER.number().numberBetween(1,5));
    }

    private static Occupation occupation(){
        return new Occupation("Empleado",
                "$1,401.000 a $2,100.000",
                removeSpecialChars(FAKER.company().name()),
                removeSpecialChars("3123456789"),
                "Empleado Oficina");
    }
    private static Personal personal(){
        return new Personal(removeSpecialChars(FAKER.name().nameWithMiddle()),
                "Cédula de ciudadanía",
                removeSpecialChars(FAKER.idNumber().valid()),
                "3007741918", aRandomDate(),
                aRandomDate(), "2356123", "M");
    }
    private static User user(){
        return new User(FAKER.bothify("????##@yopmail.com"),
                "123456");
    }
    private static Location location(){
        return new Location("Medellin", "Buenos Aires");
    }

    private static String removeSpecialChars(String text){
        return text.replace(".", "").replace("-","");
    }

    public static Payment aPaymentPSE(){
        return new Payment("Pago mínimo", "Débito pse", "1059|BANCAMIA", "Persona Natural");
    }

    public static String aRandomDate(){
        String strDateFormat = "d-MMM-yyyy";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        return objSDF.format(FAKER.date().birthday());
    }

    private static FamilyReference familyReference(){
        return new FamilyReference(removeSpecialChars(FAKER.name().nameWithMiddle()),removeSpecialChars("3123456789"),
                "Madre");
    }
}
