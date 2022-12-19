package com.example.quizapp;

public class ModelClass {
    int question;
    int optionOne;
    int optionTwo;
    int optionThree;
    int optionFour;
    int image;
    int optionCorrect;

    /*
    Constructor of ModelClass,
    This constructor contain every think.
    Like Question, Option, CorrectOption and Image.
     */
    public ModelClass(int question, int optionOne, int optionTwo, int optionThree, int optionFour, int image, int optionCorrect) {
        this.question = question;
        this.optionOne = optionOne;
        this.optionTwo = optionTwo;
        this.optionThree = optionThree;
        this.optionFour = optionFour;
        this.image = image;
        this.optionCorrect = optionCorrect;
    }

    /*
    Here is the Getter
    methods of all the Variables
     */
    public int getQuestion() {
        return question;
    }

    public int getOptionOne() {
        return optionOne;
    }

    public int getOptionTwo() {
        return optionTwo;
    }

    public int getOptionThree() {
        return optionThree;
    }

    public int getOptionFour() {
        return optionFour;
    }

    public int getImage() {
        return image;
    }

    public int getOptionCorrect() {
        return optionCorrect;
    }
}
