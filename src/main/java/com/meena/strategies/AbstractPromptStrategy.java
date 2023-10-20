package com.meena.strategies;

import java.io.PrintStream;
import lombok.Setter;

public abstract class AbstractPromptStrategy<A> implements PromptStrategy<A> {

  // This setter is only required the InputMenu Class, as till Jdk 21, it is not allowed to call a method before calling super constructor
  @Setter // Don't abuse it
  private String prompt;
  private final String errorPrompt;
  private final boolean promptInLine;


  public AbstractPromptStrategy(String prompt, String errorPrompt, boolean promptInLine) {
    this.prompt = prompt;
    this.errorPrompt = errorPrompt;
    this.promptInLine = promptInLine;
  }


  @Override
  public void displayPrompt(PrintStream out) {
    if (promptInLine) {
      out.print(prompt);
    } else {
      out.println(prompt);
    }
  }


  @Override
  public void displayError(PrintStream out) {
    out.println(errorPrompt);
    out.println();
  }

}
