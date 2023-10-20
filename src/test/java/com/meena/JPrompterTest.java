package com.meena;

import static org.assertj.core.api.Assertions.assertThat;

import com.meena.exceptions.InvalidInputException;
import com.meena.strategies.integer.InputInteger;
import com.meena.strategies.integer.InputIntegerInRange;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JPrompterTest {

  void writeToSystemIn(String data) {
    ByteArrayInputStream in = new ByteArrayInputStream(data.getBytes());
    System.setIn(in);
  }


  void resetSystemIn() {
    System.setIn(System.in);
  }


  @Test
  void createJPromptInstance() {
    // because the final result of what you want to get from the input will be some sort of DataType like
    // int, double, float, string, character, list, set, map?? etc..
    // how do you deal with Menues?

    //    JPrompter<T> prompter = new JPrompter(PromptStrategy, InputParsingStrategy);
    //    JPrompter<T> prompter = new JPrompter(SinlelinePromptStrategy(string), StringParsingStrategy);
    //    JPrompter<T> prompter = new JPrompter(SinlelinePromptStrategy(string), CharacterSelectionParsingStrategy);
    //    JPrompter<T> prompter = new JPrompter(SinlelinePromptStrategy(string), MultiLineStringParsingStrategy);
    //    JPrompter<T> prompter = new JPrompter(SinlelinePromptStrategy(string), DoubleRangeParsingStrategy);
    //    JPrompter<T> prompter = new JPrompter(SinlelinePromptStrategy(string), IntegerInRangeParsingStrategy(min, max));
    //    JPrompter<T> prompter = new JPrompter(MultilinePromptStrategy(string), IntParsingStrategy);
    //    JPrompter<T> prompter = new JPrompter(MultilinePromptStrategy(string), DoubleParsingStrategy);
    //
    //    JPrompter<T> prompter = new JPrompter(ListMenuePromptStrategy(list), DoubleParsingStrategy);
    //    JPrompter<T> prompter = new JPrompter(MapMenuePromptStrategy(Map), StringParsingStrategy);
    //
    //    JPrompter<T> prompt =
    //      new JPrompter("how do you display the prompt message", "what is the logic to use to parse the input");
    //    T input = prompt.getInput();
    //
    //    T input = new JPrompter<T>("mesage", "logice").getInput();

    JPrompter<Integer> prompter = new JPrompter<>(new InputInteger());
    assertThat(prompter).isNotNull();

  }


  @Test
  void inputInteger() throws InvalidInputException {
    writeToSystemIn("1");
    JPrompter<Integer> prompter = new JPrompter<>(new InputInteger());
    Integer input = prompter.getInputAndThrowIfInvalid();
    assertThat(input).isNotNull();
    assertThat(input).isEqualTo(1);
    resetSystemIn();
  }


  @Test
  void inputIntegerInRangeWithStartGreaterThenEnd() {
    writeToSystemIn("1");
    Assertions.assertThrows(IllegalArgumentException.class, () -> new InputIntegerInRange(3, 1));
    resetSystemIn();
  }


  @Test
  void inputIntegerInRangeCorrectUserInput() throws InvalidInputException {
    writeToSystemIn("2");
    JPrompter<Integer> prompter = new JPrompter<>(new InputIntegerInRange(1, 3));
    Integer input = prompter.getInputAndThrowIfInvalid();
    assertThat(input).isBetween(1, 3);
    resetSystemIn();
  }


  @Test
  void inputIntegerInRangeInCorrectUserInput() {
    writeToSystemIn("4");
    JPrompter<Integer> prompter = new JPrompter<>(new InputIntegerInRange(1, 3));
    Assertions.assertThrows(InvalidInputException.class, prompter::getInputAndThrowIfInvalid);
    resetSystemIn();
  }


}