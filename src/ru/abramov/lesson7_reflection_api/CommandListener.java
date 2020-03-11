package ru.abramov.lesson7_reflection_api;

import java.lang.reflect.Method;

public class CommandListener {

    @Command(name = "Hello", args = "", desc = "Please sey hello",
            showInHelp = false, aliases = {"Hi", "ola"})
    public void hello(String[] args) {
        try {
            Method helloVoid = this.getClass().getDeclaredMethod("hello");
            Command command = helloVoid.getAnnotation(Command.class);
            String s = command.name(); //привет
            System.out.println();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        // какой-то функционал
    }

    @Command(name = "Goodbye", args = "", desc = "", aliases = {"bye"})
    public void bye(String[] args) {
        // Функционал
    }

    @Command(name = "помощь", args = "", desc = "Выводить список команд", aliases = {"help", "команды"})
    public void help(String[] args) {
        StringBuilder sb = new StringBuilder("Список команд: \n");
        for (Method m : this.getClass().getDeclaredMethods()
        ) {
            if (m.isAnnotationPresent(Command.class)) {
                Command com = m.getAnnotation(Command.class);
                if (com.showInHelp()) { //если нужно показывать команду в списке
                    sb.append("Бот, ").
                            append(com.name()).
                            append(" ").
                            append(com.args()).
                            append(" - ").
                            append(com.desc()).
                            append("\n");
                }
            }
        }
    }

}
