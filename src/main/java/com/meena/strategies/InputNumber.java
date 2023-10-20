package com.meena.strategies;

import java.util.Scanner;

public class InputNumber extends AbstractPromptStrategy<Number> {

  public InputNumber() {
    super("Insert a number: ", "That is not a valid number!", true);
  }


  public InputNumber(String prompt, String errorPrompt, boolean promptInLine) {
    super(prompt, errorPrompt, promptInLine);
  }


  @Override
  public Number getInput(Scanner in) {
    return null;
  }


  @Override
  public boolean isValidInput(Scanner in) {
    return false;
  }

}
