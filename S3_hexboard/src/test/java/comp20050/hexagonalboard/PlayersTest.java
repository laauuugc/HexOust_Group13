package comp20050.hexagonalboard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {

    @Test
    void getname1() {
        Players p = new Players();
        assertEquals("", p.getname1());
    }

    @Test
    void getname2() {
        Players p = new Players();
        assertEquals("", p.getname2());
    }

    @Test
    void checkOnOkColors() {
        Players p = new Players();
        p.onOK();

        assertEquals("red", p.getplayer1Color());
        assertEquals("blue", p.getplayer2Color());
    }

}