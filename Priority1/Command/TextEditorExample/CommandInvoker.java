package Priority1.Command.TextEditorExample;

// Invoker - holds and executes commands
public class CommandInvoker {
    private Command command;
    public void setCommand(Command c) { this.command = c; }
    public void executeCommand() { if (command != null) command.execute(); }
}
