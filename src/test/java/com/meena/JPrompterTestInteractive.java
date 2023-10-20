package com.meena;

import com.meena.strategies.integer.InputInteger;
import com.meena.strategies.integer.InputIntegerInRange;

public class JPrompterTestInteractive {

  public static void main(String[] args) {
    Integer integer = new JPrompter<>(new InputInteger()).getInput();
    System.out.println(integer);

    integer = new JPrompter<>(new InputIntegerInRange(2, 5)).getInput();
    System.out.println(integer);
  }

}
