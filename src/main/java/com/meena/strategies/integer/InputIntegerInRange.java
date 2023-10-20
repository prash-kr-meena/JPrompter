package com.meena.strategies.integer;

import com.meena.strategies.AbstractPromptStrategy;
import java.util.Scanner;

public class InputIntegerInRange extends AbstractPromptStrategy<Integer> {

  private final int start;
  private final int end;


  public InputIntegerInRange(int start, int end) {
    this(String.format("Enter an integer bw [%d...%d] : ", start, end), "Invalid input!", true, start, end);
  }


  public InputIntegerInRange(String prompt, String errorPrompt, boolean promptInLine, int start, int end) {
    super(prompt, errorPrompt, promptInLine);
    if (start > end) {
      throw new IllegalArgumentException("Start must be less than end");
    }
    this.start = start;
    this.end = end;
  }


  @Override
  public Integer getInput(Scanner in) {
    // Note:  The nextInt() has already been called by the isValidInput() method of this class.
    //        so it is not available to be called again.
    return Integer.valueOf(in.match().group());
  }


  @Override
  public boolean isValidInput(Scanner in) {
    if (in.hasNextInt()) {
      int integer = in.nextInt();
      return integer >= start && integer <= end;
    }
    return false;
  }

}
