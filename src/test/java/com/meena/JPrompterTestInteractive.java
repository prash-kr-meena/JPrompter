package com.meena;

import com.meena.strategies.integer.InputInteger;
import com.meena.strategies.integer.InputIntegerInRange;
import com.meena.strategies.menu.InputMenu;
import java.util.Arrays;

public class JPrompterTestInteractive {

  public static void main(String[] args) {
    Integer integer = new JPrompter<>(new InputInteger()).getInput();
    System.out.println(integer);

    integer = new JPrompter<>(new InputIntegerInRange(2, 5)).getInput();
    System.out.println(integer);

    integer = new JPrompter<>(new InputMenu(Arrays.asList("Option 1", "Option 2", "Option 3"))).getInput();
    System.out.println(integer);
  }

}
