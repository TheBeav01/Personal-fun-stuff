package modules;

import java.io.FileNotFoundException;

import javax.security.auth.login.LoginException;

import Utilities.Bot;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import settings.*;

public class Main {

	static JDA api;
	static Bot b;


	public static void main(String[] args) throws FileNotFoundException {
		b = new Bot();
		
		try {
		 api = new JDABuilder(AccountType.BOT)
					.setToken(Bot.getToken()).buildAsync();
		} catch (LoginException | IllegalArgumentException | RateLimitedException e) {
			e.printStackTrace();
		}
		b.setJDA(api);
		api.addEventListener(new VoiceAndPingListener(), new Settings(), new RoleColor(), new Names());
		api.getPresence().setGame(b.getGame());
	}
	
	public static JDA getJDA() {
		return api;
	}
	
	public static Bot getBot() {
		return b;
	}

}
