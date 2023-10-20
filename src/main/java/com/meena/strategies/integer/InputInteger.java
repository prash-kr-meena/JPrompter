package com.meena.strategies.integer;

import com.meena.strategies.AbstractPromptStrategy;
import java.util.Scanner;

public class InputInteger extends AbstractPromptStrategy<Integer> {

  // Default prompts
  public InputInteger() {
    super("Insert an integer: ", "That is not a valid integer!", true);
  }


  public InputInteger(String prompt, String errorPrompt, boolean promptInLine) {
    super(prompt, errorPrompt, promptInLine);
  }


  @Override
  public Integer getInput(Scanner in) {
    return in.nextInt();
  }


  @Override
  public boolean isValidInput(Scanner in) {
    return in.hasNextInt();
  }

}
