package edu.miracosta.finalprojecttest.model.enviroment;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * This class handles all total running time in the game and the
 * in game day/night time.
 */
public class GameTime implements Parcelable {

    public static final int PASS_LRG = 30; //30 minutes passing in game
    public static final int PASS_MED= 15; //15 minutes passing in game
    public static final int PASS_SML = 5; //5 minutes passing in game
    public static final int MAX_DAY_MINUTES = 1440; // (24 hours) * (60 minutes) = 1440 minutes in a day
    public static final int DEFAULT_START_TIME = 360; // game by default starts at 06:00

    public static int GLOBAL_DAY_TIME;
    public static int GLOBAL_TOTAL_TIME;

    private int totalTime;
    private int dayTime;

    //We may need String versions of the time
    private String dayTimeFormatted;
    private String totalTimeFormatted;

    /**
     * Sets total time to 00:00
     * and sets day time to 00:00 (midnight).
     */
    public GameTime() {
        this.totalTime = 0;
        this.dayTime = 0;

        GLOBAL_DAY_TIME = this.dayTime;
        GLOBAL_TOTAL_TIME = this.totalTime;
    }

    public GameTime(int totalTime, int dayTime) {
        this.totalTime = totalTime;
        this.dayTime = dayTime;

        GLOBAL_TOTAL_TIME = totalTime;
        GLOBAL_DAY_TIME = dayTime;
    }

    public String getDayTimeFormatted() {
        int t = dayTime;
        int hours = t / 60; //since both are ints, you get an int
        int minutes = t % 60;
        dayTimeFormatted = String.format("%d:%02d", hours, minutes);

        return dayTimeFormatted;
    }

    public String getTotalTimeFormatted() {

        int days = totalTime/(24*60);
        int hours = (totalTime%(24*60)) / 60;
        int minutes = (totalTime%(24*60)) % 60;



        totalTimeFormatted = days + " Days : " + hours + " Hours : " + minutes + " Minutes";

        return totalTimeFormatted;
    }

    /**
     * Increments the total time and day time by the default value (30 minutes).
     */
    public void passTime(int time) {

        totalTime += time;
        dayTime += time;

        GLOBAL_DAY_TIME = dayTime;
        GLOBAL_TOTAL_TIME = totalTime;

        resetDayTime();
    }

    /**
     * If the day time exceeds the max time,
     * then set the daytime to itself minus the default MAX_DAY_MINUTES value (1440).
     * This SHOULD reset the day time to 00:00.
     */
    public void resetDayTime() {

        if (dayTime >= MAX_DAY_MINUTES) {

            dayTime = dayTime - MAX_DAY_MINUTES;

            GLOBAL_DAY_TIME = dayTime - MAX_DAY_MINUTES;
        }
    }

    @Override
    public String toString() {
        return "GameTime{" +
                "totalTime=" + totalTime +
                ", dayTime=" + dayTime +
                '}';
    }

    //////////GETTERS & SETTERS//////////


    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public int getDayTime() {
        return dayTime;
    }

    public void setDayTime(int dayTime) {
        this.dayTime = dayTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(totalTime);
        dest.writeInt(dayTime);
    }

    private GameTime(Parcel parcel) {
        totalTime = parcel.readInt();
        dayTime = parcel.readInt();
    }

    public static final Parcelable.Creator<GameTime> CREATOR = new Creator<GameTime>() {
        @Override
        public GameTime createFromParcel(Parcel source) {
            return new GameTime(source);
        }

        @Override
        public GameTime[] newArray(int size) {
            return new GameTime[size];
        }
    };
}
