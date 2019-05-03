package edu.miracosta.finalprojecttest.model.enviroment;
/**
 * Plant.java: A class that creates an Plant object to describe their parameters.
 * @author Gabriel Bactol & Jacob Valenzuela
 * @since 4/23/19
 */
public class Plant
{
    private String plantName;
    private String plantDetails;
    private String plantImage;

    /**
     * Default constructor, in case there are no parameters given
     */
    public Plant() {
        this.plantName = "";
        this.plantDetails = "";
        this.plantImage = "";
    }

    /**
     * A full consturctor used to create an object with specific parameters passed in
     * @param plantName - The name of the plant
     * @param plantDetails - the details of the plant
     * @param plantImage - The image associated with the plant
     */
    public Plant(String plantName, String plantDetails, String plantImage) {
        this.plantName = plantName;
        this.plantDetails = plantDetails;
        this.plantImage = plantImage;
    }


    /**
     * An accessor to get the String within the variable plantName
     * @return the string within plantName
     */
    public String getPlantName() {
        return plantName;
    }

    /**
     * An mutator write into the plantName variable
     * @param plantName a String for the plantName variable
     */
    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    /**
     * An accessor to get the String within the variable plantDetails
     * @return the string within plantDetails
     */
    public String getPlantDetails() {
        return plantDetails;
    }

    /**
     * An mutator write into the plantDetails variable
     * @param plantDetails a String for the plantDetails variable
     */
    public void setPlantDetails(String plantDetails) {
        this.plantDetails = plantDetails;
    }

    /**
     * An accessor to get the String within the variable plantImage
     * @return the string within plantImage
     */
    public String getPlantImage() {
        return plantImage;
    }

    /**
     * An mutator write into the plantImage variable
     * @param plantImage a String for the plantImage variable
     */
    public void setPlantImage(String plantImage) {
        this.plantImage = plantImage;
    }
}
