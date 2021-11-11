/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saidm
 */
public class convertisseur {
    int nbConversions ;
    
    
    
    
    public  double CelciusVersKelvin(double tCelcius) {
        double tKelvin = (tCelcius + 273.15);
        nbConversions=nbConversions+1 
        return tKelvin;
    }

    public  double KelvinVersCelcius(double tKelvin) { //fonction conversion avec un parametre réel
        double tCelcius = (tKelvin - 273.15);
        nbConversions=nbConversions+1 
        return tCelcius;
    }

    public double FahrenheitVersCelcius(double tFahrenheit) { //fonction conversion avec un parametre réel
        double tCelcius = (tFahrenheit - 32) / 1.8;
        nbConversions=nbConversions+1 
        return tCelcius;
    }

    public  double CelciusVersFahrenheit(double tCelcius) { //fonction conversion avec un parametre réel
        double tFahrenheit = (tCelcius + 32) * 1.8;
        nbConversions=nbConversions+1 
        return tFahrenheit;
    }

    public  double KelvinVersFahrenheit(double tKelvin) { //fonction conversion avec un parametre réel
        double tFahrenheit = ((tKelvin - 273.15) * 1.8) + 32;
        nbConversions=nbConversions+1 
        return tFahrenheit;
    }

    public  double FahrenheitVersKelvin(double tFahrenheit) { //fonction conversion avec un parametre réel
        double tKelvin = ((tFahrenheit - 32) / 1.8) + 273.15;
        nbConversions=nbConversions+1 

        return tKelvin;
    }


        // II.Convertisseur de temperature 

        Scanner sc = new Scanner(System.in); // fonction qui lit les entres de l'utilisateur 
        // rajout automatique de : import java.util.Scanner;
        System.out.println("Entrez une température en degré Celcius:");
        double tCelcius = sc.nextFloat();
        System.out.println("Cette même température en degré : " + (tCelcius + 273.15));
        double tKelvin;
        tKelvin = CelciusVersKelvin(tCelcius);
        System.out.println(tKelvin);

        //menu interactif de conversion
        System.out.println("Bonjour, saisissez une valeur :");
        double temp = sc.nextFloat();
        System.out.println("Saisissez la conversion que vous souhaiter effectuer :\n"
                + "1) De Celcius vers Kelvin\n"
                + "2) De Kelvin vers Celcius\n"
                + "3) Fahrenheit vers Celcius\n"
                + "4) Celcius vers Fahrenheit\n"
                + "5) Kelvin vers Fahrenheit\n"
                + "6) De Farenheit vers Kelvin");

        int choix = sc.nextInt();
        double tempf; // temperature finale convertie;

        switch (choix) {
            case 1:
                tempf = CelciusVersKelvin(temp);
                System.out.println(temp + " degrés Celcius est égal à " + tempf + " dégrés Kelvin");
            case 2:
                tempf = KelvinVersCelcius(temp);
                System.out.println(temp + " degrés Kelvin est égal à " + tempf + " dégrés Celcius");
            case 3:
                tempf = FahrenheitVersCelcius(temp);
                System.out.println(temp + " degrés Fahrenheit est égal à " + tempf + " dégrés Celcius");
            case 4:
                tempf = CelciusVersFahrenheit(temp);
                System.out.println(temp + " degrés Celcius est égal à " + tempf + " dégrés Fahrenheit");
            case 5:
                tempf = KelvinVersFahrenheit(temp);
                System.out.println(temp + " degrés Kelvin est égal à " + tempf + " dégrés Fahrenheit");
            case 6:
                tempf = FahrenheitVersKelvin(temp);
                System.out.println(temp + " degrés Fahrenheit est égal à " + tempf + " dégrés Kelvin");
        }

    }

public Convertisseur () {
 nbConversions = 0 ;
}
        
@Override
public String toString () {
 return "nb de conversions"+ nbConversions;
}
        
}
