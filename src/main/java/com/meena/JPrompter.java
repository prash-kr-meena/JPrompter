package com.meena;

import com.meena.exceptions.InvalidInputException;
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


  /**
   * Get input until it is valid!
   *
   * @return result of the prompt
   */
  public T getInput() {
    strategy.displayPrompt(out);// displays the prompt
    while (!strategy.isValidInput(in)) {
      strategy.displayError(out);
      strategy.displayPrompt(out);
      in.nextLine(); // consume extra CR
    }
    return strategy.getInput(in);
  }


  /**
   * Get input and throw an exception if it is invalid, This is a single prompt method, unlike the getInput() method
   * which takes input until it is valid. It becomes harder to test such a method.
   * <p>
   * That is why all tests are testing against the getInputAndThrowIfInvalid() method.
   * <p>
   * I have used the getInput() method in the interactive test mode.
   *
   * @return result of the prompt
   *
   * @throws InvalidInputException
   *   if the input is invalid
   */

  public T getInputAndThrowIfInvalid() throws InvalidInputException {
    strategy.displayPrompt(out);// displays the prompt
    if (!strategy.isValidInput(in)) {
      strategy.displayError(out);
      throw new InvalidInputException();
    }
    return strategy.getInput(in);
  }

}
