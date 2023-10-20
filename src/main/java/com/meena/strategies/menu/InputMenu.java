package com.meena.strategies.menu;

import com.meena.strategies.integer.InputIntegerInRange;
import java.util.List;
import lombok.NonNull;

public class InputMenu extends InputIntegerInRange {

  private final List<String> menuOptions;


  public InputMenu(@NonNull List<String> menuOptions) {
    this("PLACE-HOLDER-MESSAGE", "That is not a valid option!", true, menuOptions);
    setPrompt(buildMenuString("Select an option: ", menuOptions));
  }


  public InputMenu(String prompt, String errorPrompt, boolean promptInLine, @NonNull List<String> menuOptions) {
    // Note:  It will result in a NullPointerException if menuOptions is null.
    //        But as Java requires us to write the super() call as the first statement in the constructor,
    //        we cannot check for null here.

    // passing min, max to utilize the functionality of InputIntegerInRange, to validate the input bw 'start' and 'end'
    super("PLACE-HOLDER-MESSAGE", errorPrompt, promptInLine, 1, menuOptions.size());
    setPrompt(buildMenuString(prompt, menuOptions));
    if (menuOptions.isEmpty()) {
      throw new IllegalArgumentException("Menu options cannot be null or empty");
    }
    this.menuOptions = menuOptions;
  }


  private String buildMenuString(String message, List<String> options) {
    StringBuilder menuBuilder = new StringBuilder("\n");
    menuBuilder.append(message);
    for (int i = 0; i < options.size(); i++) {
      menuBuilder.append("\n").append(i + 1).append(" - ").append(options.get(i));
    }
    menuBuilder.append("\n> ");
    return menuBuilder.toString();
  }


}
