package com.codeoftheweb.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(PlayerRepository playerRepository, GameRepository gameRepository, GamePlayerRepository gamePlayerRepository, ShipRepository shipRepository, SalvoRepository salvoRepository, ScoreRepository scoreRepository) {
		return (args) -> {
			Player player1 = new Player("jack@gmail.com");
			Player player2 = new Player("chloe@gmail.com");
			Player player3 = new Player("kim@gmail.com");
			Player player4 = new Player("david@gmail.com");

			playerRepository.save(player1);
			playerRepository.save(player2);
			playerRepository.save(player3);
			playerRepository.save(player4);

			Game game1 = new Game(LocalDateTime.now());
			Game game2 = new Game(LocalDateTime.now().plusHours(2));
			Game game3 = new Game(LocalDateTime.now());
			Game game4 = new Game(LocalDateTime.now().plusHours(2));

			gameRepository.save(game1);
			gameRepository.save(game2);
			gameRepository.save(game3);
			gameRepository.save(game4);

			GamePlayer gamePlayer1 = new GamePlayer(LocalDateTime.now(), player1, game1);
			GamePlayer gamePlayer2 = new GamePlayer(LocalDateTime.now(), player2, game1);
			GamePlayer gamePlayer3 = new GamePlayer(LocalDateTime.now(), player3, game2);
			GamePlayer gamePlayer4 = new GamePlayer(LocalDateTime.now(), player4, game2);
			GamePlayer gamePlayer5 = new GamePlayer(LocalDateTime.now(), player1, game3);
			GamePlayer gamePlayer6 = new GamePlayer(LocalDateTime.now(), player2, game4);
			GamePlayer gamePlayer7 = new GamePlayer(LocalDateTime.now(), player3, game3);
			GamePlayer gamePlayer8 = new GamePlayer(LocalDateTime.now(), player4, game4);

			gamePlayerRepository.save(gamePlayer1);
			gamePlayerRepository.save(gamePlayer2);
			gamePlayerRepository.save(gamePlayer3);
			gamePlayerRepository.save(gamePlayer4);
			gamePlayerRepository.save(gamePlayer5);
			gamePlayerRepository.save(gamePlayer6);
			gamePlayerRepository.save(gamePlayer7);
			gamePlayerRepository.save(gamePlayer8);

			Ship carrier = new Ship("Carrier", gamePlayer1, Arrays.asList("A1", "B1", "C1", "D1", "E1") );
			Ship battleship = new Ship("Battleship", gamePlayer1, Arrays.asList("A7", "A8", "A9", "A10"));
			Ship submarine = new Ship("Submarine", gamePlayer1, Arrays.asList("H10", "I10", "J10"));
			Ship destroyer = new Ship("Destroyer", gamePlayer1, Arrays.asList("G1", "G2", "G3"));
			Ship patrolBoat = new Ship("Patrol Boat", gamePlayer1, Arrays.asList("E6", "F6"));

			Ship carrier2 = new Ship("Carrier", gamePlayer2, Arrays.asList("C8", "D8", "E8", "F8", "G8") );
			Ship battleship2 = new Ship("Battleship", gamePlayer2, Arrays.asList("B1", "B2", "B3", "B4"));
			Ship submarine2 = new Ship("Submarine", gamePlayer2, Arrays.asList("H1", "I1", "J1"));
			Ship destroyer2 = new Ship("Destroyer", gamePlayer2, Arrays.asList("E1", "E2", "E3"));
			Ship patrolBoat2 = new Ship("Patrol Boat", gamePlayer2, Arrays.asList("I9", "J9"));

			Ship carrier3 = new Ship("Carrier", gamePlayer3, Arrays.asList("A1", "A2", "A3", "A4", "A5") );
			Ship battleship3 = new Ship("Battleship", gamePlayer3, Arrays.asList("C3", "C4", "C5", "C6"));
			Ship submarine3 = new Ship("Submarine", gamePlayer3, Arrays.asList("E10", "F10", "G10"));
			Ship destroyer3 = new Ship("Destroyer", gamePlayer3, Arrays.asList("F1", "F2", "F3"));
			Ship patrolBoat3 = new Ship("Patrol Boat", gamePlayer3, Arrays.asList("J5", "J6"));

			Ship carrier4 = new Ship("Carrier", gamePlayer4, Arrays.asList("A10", "B10", "C10", "D10", "E10") );
			Ship battleship4 = new Ship("Battleship", gamePlayer4, Arrays.asList("B1", "B2", "B3", "B4"));
			Ship submarine4 = new Ship("Submarine", gamePlayer4, Arrays.asList("J1", "J2", "J3"));
			Ship destroyer4 = new Ship("Destroyer", gamePlayer4, Arrays.asList("G1", "G2", "G3"));
			Ship patrolBoat4 = new Ship("Patrol Boat", gamePlayer4, Arrays.asList("E1", "E2"));

			shipRepository.save(carrier);
			shipRepository.save(battleship);
			shipRepository.save(submarine);
			shipRepository.save(destroyer);
			shipRepository.save(patrolBoat);

			shipRepository.save(carrier2);
			shipRepository.save(battleship2);
			shipRepository.save(submarine2);
			shipRepository.save(destroyer2);
			shipRepository.save(patrolBoat2);

			shipRepository.save(carrier3);
			shipRepository.save(battleship3);
			shipRepository.save(submarine3);
			shipRepository.save(destroyer3);
			shipRepository.save(patrolBoat3);

			shipRepository.save(carrier4);
			shipRepository.save(battleship4);
			shipRepository.save(submarine4);
			shipRepository.save(destroyer4);
			shipRepository.save(patrolBoat4);

			Salvo salvo1 = new Salvo(1, Arrays.asList("C8", "H1"), gamePlayer1);
			Salvo salvo2 = new Salvo(1, Arrays.asList("C1", "C5"), gamePlayer2);
			Salvo salvo3 = new Salvo(1, Arrays.asList("J8", "B10"), gamePlayer3);
			Salvo salvo4 = new Salvo(1, Arrays.asList("A1", "J7"), gamePlayer4);

			Salvo salvo5 = new Salvo(2, Arrays.asList("B4", "H7"), gamePlayer1);
			Salvo salvo6 = new Salvo(2, Arrays.asList("H6", "A9"), gamePlayer2);
			Salvo salvo7 = new Salvo(2, Arrays.asList("F5", "H5"), gamePlayer3);
			Salvo salvo8 = new Salvo(2, Arrays.asList("A7", "J2"), gamePlayer4);

			salvoRepository.save(salvo1);
			salvoRepository.save(salvo2);
			salvoRepository.save(salvo3);
			salvoRepository.save(salvo4);

			salvoRepository.save(salvo5);
			salvoRepository.save(salvo6);
			salvoRepository.save(salvo7);
			salvoRepository.save(salvo8);

			Score score1 = new Score(player1, game1, 1.0, LocalDateTime.now());
			Score score2 = new Score(player2, game1, 0.0, LocalDateTime.now());
			Score score3 = new Score(player3, game2, null, LocalDateTime.now());
			Score score4 = new Score(player4, game2, null, LocalDateTime.now());
			Score score5 = new Score(player1, game3, 0.0, LocalDateTime.now());
			Score score6 = new Score(player2, game4, 0.5, LocalDateTime.now());
			Score score7 = new Score(player3, game3, 1.0, LocalDateTime.now());
			Score score8 = new Score(player4, game4, 0.5, LocalDateTime.now());

			scoreRepository.save(score1);
			scoreRepository.save(score2);
			scoreRepository.save(score3);
			scoreRepository.save(score4);
			scoreRepository.save(score5);
			scoreRepository.save(score6);
			scoreRepository.save(score7);
			scoreRepository.save(score8);
		};
	}
}