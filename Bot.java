package org.example;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "MyTestSlave_bot";
    }

    @Override
    public String getBotToken() {
        return "6861123034:AAG7tpYmIdD7ivC4JCjIkSj9Ab9HIio_S-s";
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update);
        update.getUpdateId();
        var msg = update.getMessage();
        var user = msg.getFrom();
        var id = user.getId();
        System.out.println(user.getUserName() + " said " + msg.getText());
        //sendText(-1248663382L, msg.getText());//-1248663382L
        sendText(-4030378543L, msg.getText());//-4030378543L
    }
    public void sendText(Long who, String text){
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString()) //Who are we sending a message to
                .text(text).build();    //Message content
        try {
            execute(sm);                        //Actually sending the message
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      //Any error will be printed here
        }
    }



}