package bo.edu.ucb.chatbot.bot;


import bo.edu.ucb.chatbot.bl.ActorSearchBl;
import bo.edu.ucb.chatbot.bl.BotActorSearchBl;
import bo.edu.ucb.chatbot.bl.BotFilmSearchBl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Component
public class FilmBotHandler extends TelegramLongPollingBot {

    private BotFilmSearchBl botFilmSearchBl;
    private  BotActorSearchBl botactorSearchBl;

    @Autowired
    public FilmBotHandler(BotFilmSearchBl botFilmSearchBl,BotActorSearchBl botactorSearchBl) {
        this.botFilmSearchBl = botFilmSearchBl;
        this.botactorSearchBl = botactorSearchBl;
    }

    @Override
    public String getBotUsername() {
        return  "Ikki_ucb_bot";
    }

    @Override
    public String getBotToken() {
        return "2009598523:AAHfQxO6a-UWTfMEcOOxfo5o6jOs1xsMLPI";
    }

    @Override
    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            String chatId = update.getMessage().getChatId().toString();
            String text = update.getMessage().getText();
            // dividir cadena split
            String[] cad = text.split("=");
            //Verificar tipo de peticion
            //solo titulo
            if(cad[0].equals("Titulo")){
                String title = cad[1];
                List<String> responses = botFilmSearchBl.processMessage(title);
                sendMessage(chatId, responses);
            }
            //solo actor
            else{
                String[] name=cad[1].split(" ");
                List<String> responses = BotActorSearchBl.processMessage1(name[0],name[1]);
                sendMessage(chatId, responses);
            }

        }
    }

    private void sendMessage( String chatId, String messageText) {
        SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
        message.setChatId(chatId);
        message.setText(messageText);
        try {
            execute(message); // Call method to send the message
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage( String chatId, List<String> messageText) {
        for ( String message: messageText) {
            sendMessage(chatId, message);
        }
    }
}
