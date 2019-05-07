package edu.miracosta.finalprojecttest.model.enviroment;
/**
 * Animal.java: A class that creates an animal object to describe their parameters.
 * @author Gabriel Bactol & Jacob Valenzuela
 * @since 4/23/19
 */

public class Tip
{
    private String tipName;
    private String tipDescription;
    private String tipImage;

    public Tip()
    {
        tipName = "";
        tipDescription = "";
        tipImage = "";
    }

    public Tip(String tipName, String tipsDescription, String tipImage) {
        this.tipName = tipName;
        this.tipDescription = tipDescription;
        this.tipImage = tipImage;
    }

    public String getTipName() {
        return tipName;
    }

    public void setTipName(String tipName) {
        this.tipName = tipName;
    }

    public String getTipDescription() {
        return tipDescription;
    }

    public void setTipDescription(String tipsDescription) {
        this.tipDescription = tipsDescription;
    }

    public String getTipImage() {
        return tipImage;
    }

    public void setTipImage(String tipImage) {
        this.tipImage = tipImage;
    }
}
