package edu.miracosta.finalprojecttest.model;
/**
 * Animal.java: A class that creates an animal object to describe their parameters.
 * @author Gabriel Bactol & Jacob Valenzuela
 * @since 4/23/19
 */

public class Animal
{
    private String animalName;
    private String animalDescription;
    private String animalImage;

    /**
     * Default constructor, in case there are no parameters given
     */
    public Animal() {
        this.animalName = "";
        this.animalDescription = "";
        this.animalImage = "";
    }

    /**
     * A full consturctor used to create an object with specific parameters passed in
     * @param animalName - The name of the animal
     * @param animalDescription - The description of the animal
     * @param animalImage - The image of the animal
     */
    public Animal(String animalName, String animalDescription, String animalImage) {
        this.animalName = animalName;
        this.animalDescription = animalDescription;
        this.animalImage = animalImage;
    }

    /**
     * An accessor to get the String within the variable animalName
     * @return the string within animalName
     */
    public String getAnimalName() {
        return animalName;
    }

    /**
     * An mutator write into the animalName variable
     * @param animalName a String for the animalName variable
     */
    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    /**
     * An accessor to get the String within the variable animalDescription
     * @return the string within animalDescription
     */
    public String getAnimalDescription() {
        return animalDescription;
    }

    /**
     * An mutator write into the animalDescription variable
     * @param animalDescription a String for the animalDescription variable
     */
    public void setAnimalDescription(String animalDescription) {
        this.animalDescription = animalDescription;
    }

    /**
     * An accessor to get the String within the variable animalImage
     * @return the string within animalImage
     */
    public String getAnimalImage() {
        return animalImage;
    }

    /**
     * An mutator write into the animalImage variable
     * @param animalImage a String for the animalImage variable
     */
    public void setAnimalImage(String animalImage) {
        this.animalImage = animalImage;
    }
}
