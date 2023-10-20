package com.meena;

import com.meena.strategies.InputInteger;

public class JPrompterTestInteractive {

  public static void main(String[] args) {
    Integer value = new JPrompter<>(new InputInteger()).getInput();
    System.out.println(value);
  }

}
