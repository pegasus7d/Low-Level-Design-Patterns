package Priority2.AbstractFactory.UIThemeExample;

// Abstract factory - creates family of UI components
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
