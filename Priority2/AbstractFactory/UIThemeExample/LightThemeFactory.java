package Priority2.AbstractFactory.UIThemeExample;

// Concrete factory - light theme
public class LightThemeFactory implements GUIFactory {
    public Button createButton() { return new LightButton(); }
    public Checkbox createCheckbox() { return new LightCheckbox(); }
}
