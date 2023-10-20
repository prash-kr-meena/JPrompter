package com.meena.strategies;

import java.io.PrintStream;
import java.util.Scanner;

public interface PromptStrategy<T> {

  void displayPrompt(PrintStream out);

  T getInput(Scanner in);

  boolean isValidInput(Scanner in);

  void displayError(PrintStream out);

}
