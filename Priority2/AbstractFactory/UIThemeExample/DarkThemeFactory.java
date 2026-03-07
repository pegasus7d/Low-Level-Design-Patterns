package Priority2.AbstractFactory.UIThemeExample;

// Concrete factory - dark theme
// TODO: Same pattern for LightThemeFactory (LightButton, LightCheckbox)
public class DarkThemeFactory implements GUIFactory {
    public Button createButton() { return new DarkButton(); }
    public Checkbox createCheckbox() { return new DarkCheckbox(); }
}
