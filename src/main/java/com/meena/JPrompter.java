package com.meena;

import com.meena.strategies.PromptStrategy;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Create prompts in Java
 */
public class JPrompter<T> {

  private final Scanner in;
  private final PrintStream out;
  private final PromptStrategy<T> strategy;


  /**
   * Create a Prompt using stdin/stdout for I/O
   *
   * @param strategy
   *   promptStrategy to use for prompting
   */
  public JPrompter(PromptStrategy<T> strategy) {
    this(System.in, System.out, strategy);
  }


  /**
   * Create a Prompt from two streams
   *
   * @param in
   *   Input
   * @param out
   *   Output
   * @param strategy
   *   promptStrategy to use for prompting
   */
  public JPrompter(InputStream in, PrintStream out, PromptStrategy<T> strategy) {
    this.in = new Scanner(in);
    this.out = out;
    this.strategy = strategy;
  }


  public T getInput() {
    strategy.displayPrompt(out);// displays the prompt
    while (!strategy.isValidInput(in)) {
      strategy.displayError(out);
      strategy.displayPrompt(out);
      in.nextLine(); // consume extra CR
    }
    return strategy.getInput(in);
  }

}
