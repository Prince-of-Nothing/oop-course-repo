package oop.practice;

import java.util.List;

public class Classification {

    public static int getClassification(Character individuals) {
        BooleanState isHumanoid = individuals.getIsHumanoid();
        String planet = individuals.getPlanet();
        Integer age = individuals.getAge();
        List<String> traits = individuals.getTraits();

        // Print out the current values for debugging
        System.out.println(" ID:" + individuals.getId() + "\n{" +
                "\nisHumanoid=" + isHumanoid +
                "\nplanet='" + planet + '\'' +
                "\nage=" + age +
                "\ntraits=" + traits);



        // Default classification value
        int classification = -1;

        // Handle Star Wars Classification
        if (isHumanoid == null || isHumanoid == BooleanState.FALSE) {
            if ("Kashyyyk".equalsIgnoreCase(planet) && (age > -1 && age<401)&& traits != null && traits.contains("HAIRY")&& traits.contains("TALL")) {
                return 1; // Wookie
            } else if ("Endor".equalsIgnoreCase(planet) && (age > -1 && age<61 )&& traits != null && traits.contains("HAIRY") && traits.contains("SHORT")) {
                return 1; // Ewok
            }
            if (age > -1 && age<201&&"Vogsphere".equalsIgnoreCase(planet)&&traits != null && traits.contains("BULKY")&& traits.contains("GREEN")){
                    return 3; // Likely a Vogon
                }
        } else if (isHumanoid != null && isHumanoid == BooleanState.TRUE) {
            if ("Asgard".equalsIgnoreCase(planet) && age > -1 && age<5001&& traits != null && traits.contains("BLONDE")&& traits.contains("TALL")) {
                return 2; // Asgardian
            } else if ("Betelgeuse".equalsIgnoreCase(planet) && age > -1&&age<101 && traits != null &&
                    (traits.contains("EXTRA_ARMS") || traits.contains("EXTRA_HEAD"))) {
                return 3; // Betelgeusian
            } else if ("Earth".equalsIgnoreCase(planet)) {
                if (traits != null) {//LOTR species
                    if (traits.contains("BLONDE") &&  age>-1&&traits.contains("POINTY_EARS")) {
                        return 4; // Elf
                    } else if (traits.contains("SHORT") && age>-1&&age<201&&traits.contains("BULKY")) {
                        return 4; // Dwarf
                    }
                }
            }
        }


    if (planet == null || planet.equalsIgnoreCase("UNKNOWN")) {
            if (isHumanoid == BooleanState.FALSE && traits != null && traits.contains("BULKY")) {
                return 3; // Likely Vogon
            } else if (isHumanoid == BooleanState.TRUE && traits != null && traits.contains("BULKY")){
                return 4;
            }
        }
        if (planet != null){
            if (planet.equalsIgnoreCase("Endor")){
                return 1;
            }
             if (planet.equalsIgnoreCase("KASHYYYK")){
                return 1;
            }
            if (planet.equalsIgnoreCase("ASGARD")){
                return 2;
            }
            if (planet.equalsIgnoreCase("BETELGEUSE")){
                return 3;
            }
            if (planet.equalsIgnoreCase("VOGSPHERE")){
                return 3;
            }
            if (planet.equalsIgnoreCase("EARTH")){
                return 4;
            }
        }

        // Handle generic traits
        if (traits != null) {
            if (traits.contains("GREEN")) {
                return 3; // Vogon
            } else if (traits.contains("HAIRY") ) {
                return 1; // General hairy being
            } else if ((traits.contains("Blonde")&& (isHumanoid == null || isHumanoid == BooleanState.TRUE))||(traits.contains("TALL")&&traits.contains("Blonde") )) {
                return 2; // Likely Asgardian
            } else if (traits.contains("EXTRA_ARMS") || traits.contains("EXTRA_HEAD")) {
                return 3;
            } else if (traits.contains("POINTY_EARS") ){ return 4;}
        }

        // Default classification if only humanoid status and age are available
        if (isHumanoid != null) {
            if (isHumanoid == BooleanState.TRUE && (age == null || age <= 200)) {
                return 3; // Default to Vogon for humanoids with no specific planet or traits
            }
        }

        //handle LOR cases 4 , 14
        if (planet.equalsIgnoreCase("Earth")){
            if( traits != null && traits.contains("BULKY") && traits.contains("SHORT")) {
                return 4;//case 4
            }
        } else if (isHumanoid != null & isHumanoid == BooleanState.TRUE && age > 5000) {
            return 4;// case 21
        }

        // Fallback for unspecified characters
        return -1; // Unspecified character
    }

}