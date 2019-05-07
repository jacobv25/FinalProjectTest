package edu.miracosta.finalprojecttest.model.enviroment;

public class Item {

    private String imageName;
    private String name;
    private int count;

    public Item(String imageName, String name, int count) {
        this.imageName = imageName;
        this.name = name;
        this.count = count;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
