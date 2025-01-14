package blackjack.domain.game;

import blackjack.domain.betting.Betting;
import blackjack.domain.betting.BettingTable;
import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Participant;
import blackjack.domain.participant.Participants;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static blackjack.domain.CardConstant.*;
import static org.assertj.core.api.Assertions.*;

public class GameResultTest {
    private Dealer dealer;
    private Participants participants;
    private Map<Participant, Betting> resultBetting;
    private BettingTable table;
    private Participant pobi;


    @BeforeEach
    void setUp() {
        dealer = Dealer.from(new ArrayList<>());
        participants = Participants.of(dealer, List.of("pobi"));
        resultBetting = new HashMap<>();

        table = BettingTable.from(resultBetting);

        pobi = participants.getPlayers().get(0);
        table.addBetting(pobi, Betting.from(10000));
    }

    @Test
    @DisplayName("플레이어가 블랙잭일 때, 딜러의 값을 제대로 반환하는지 확인한다.")
    void getDealerResultTestByPlayerIsBlackjack() {
        dealer.drawCard(HEART_TEN);
        dealer.drawCard(HEART_EIGHT);
        dealer.drawCard(HEART_TWO);

        pobi.drawCard(DIAMOND_ACE);
        pobi.drawCard(DIAMOND_TEN);

        GameResult resultGame = GameResult.of(table, participants);

        assertThat(resultGame.getDealerResult()).isEqualTo(Betting.from(-15000));
    }

    @Test
    @DisplayName("플레이어가 승일 때, 딜러의 값을 제대로 반환하는지 확인한다.")
    void getDealerResultTestByPlayerIsWin() {
        dealer.drawCard(HEART_TEN);
        dealer.drawCard(HEART_SEVEN);
        dealer.drawCard(HEART_TWO);

        pobi.drawCard(DIAMOND_ACE);
        pobi.drawCard(DIAMOND_NINE);

        GameResult resultGame = GameResult.of(table, participants);

        assertThat(resultGame.getDealerResult()).isEqualTo(Betting.from(-10000));
    }

    @Test
    @DisplayName("플레이어가 무승부일 때, 딜러의 값을 제대로 반환하는지 확인한다.")
    void getDealerResultTestByPlayerIsTie() {
        dealer.drawCard(HEART_TEN);
        dealer.drawCard(HEART_EIGHT);
        dealer.drawCard(HEART_TWO);

        pobi.drawCard(DIAMOND_ACE);
        pobi.drawCard(DIAMOND_NINE);

        GameResult resultGame = GameResult.of(table, participants);

        assertThat(resultGame.getDealerResult()).isEqualTo(Betting.from(0));
    }

    @Test
    @DisplayName("플레이어가 패일 때, 딜러의 값을 제대로 반환하는지 확인한다.")
    void getDealerResultTestByPlayerIsLose() {
        dealer.drawCard(HEART_TEN);
        dealer.drawCard(HEART_EIGHT);
        dealer.drawCard(HEART_TWO);

        pobi.drawCard(DIAMOND_ACE);
        pobi.drawCard(DIAMOND_EIGHT);

        GameResult resultGame = GameResult.of(table, participants);

        assertThat(resultGame.getDealerResult()).isEqualTo(Betting.from(10000));
    }

    @Test
    @DisplayName("플레이어의 베팅 금액을 제대로 반환하는지 테스트")
    void getPlayerResultTest() {
        GameResult resultGame = GameResult.of(table, participants);

        assertThat(resultGame.getPlayerResult(pobi)).isEqualTo(Betting.from(0));
    }
}
