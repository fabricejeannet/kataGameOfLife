import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by fabricejeannet on 16/09/2014.
 */
public class Tests {

    @Before
    public void before(){
        gameOfLife = new GameOfLife(4,8);
    }


    @Test
    public void foundsNoLivingNeighboursInAnEmptyGrid() {

        int neighboursCount = gameOfLife.countlivingNeighbours(1, 4);

        assertThat(neighboursCount).isEqualTo(0);
    }

    @Test
    public void foundsOneLivingNeighbour() {

        gameOfLife.setLivingCell(0, 3);

        int neighboursCount = gameOfLife.countlivingNeighbours(1, 4);

        assertThat(neighboursCount).isEqualTo(1);
    }


    @Test
    public void foundsTwoLivingNeighbours() {

        gameOfLife.setLivingCell(0, 3);
        gameOfLife.setLivingCell(0, 4);

        int neighboursCount = gameOfLife.countlivingNeighbours(1, 4);

        assertThat(neighboursCount).isEqualTo(2);
    }


    @Test
    public void foundsThreeLivingNeighbours() {

        gameOfLife.setLivingCell(0, 3);
        gameOfLife.setLivingCell(0, 4);
        gameOfLife.setLivingCell(0, 5);

        int neighboursCount = gameOfLife.countlivingNeighbours(1, 4);

        assertThat(neighboursCount).isEqualTo(3);
    }

    @Test
    public void foundsFourLivingNeighbours() {

        gameOfLife.setLivingCell(0, 3);
        gameOfLife.setLivingCell(0, 4);
        gameOfLife.setLivingCell(0, 5);
        gameOfLife.setLivingCell(1, 5);

        int neighboursCount = gameOfLife.countlivingNeighbours(1, 4);

        assertThat(neighboursCount).isEqualTo(4);
    }

    @Test
    public void foundsFiveLivingNeighbours() {

        gameOfLife.setLivingCell(0, 3);
        gameOfLife.setLivingCell(0, 4);
        gameOfLife.setLivingCell(0, 5);
        gameOfLife.setLivingCell(1, 5);
        gameOfLife.setLivingCell(2, 5);

        int neighboursCount = gameOfLife.countlivingNeighbours(1, 4);

        assertThat(neighboursCount).isEqualTo(5);
    }

    @Test
    public void foundsSixLivingNeighbours() {

        gameOfLife.setLivingCell(0, 3);
        gameOfLife.setLivingCell(0, 4);
        gameOfLife.setLivingCell(0, 5);
        gameOfLife.setLivingCell(1, 5);
        gameOfLife.setLivingCell(2, 5);
        gameOfLife.setLivingCell(2, 4);

        int neighboursCount = gameOfLife.countlivingNeighbours(1, 4);

        assertThat(neighboursCount).isEqualTo(6);
    }


    @Test
    public void foundsSevenLivingNeighbours() {

        gameOfLife.setLivingCell(0, 3);
        gameOfLife.setLivingCell(0, 4);
        gameOfLife.setLivingCell(0, 5);
        gameOfLife.setLivingCell(1, 5);
        gameOfLife.setLivingCell(2, 5);
        gameOfLife.setLivingCell(2, 4);
        gameOfLife.setLivingCell(2, 3);

        int neighboursCount = gameOfLife.countlivingNeighbours(1, 4);

        assertThat(neighboursCount).isEqualTo(7);
    }

    @Test
    public void foundsHeightLivingNeighbours() {

        gameOfLife.setLivingCell(0, 3);
        gameOfLife.setLivingCell(0, 4);
        gameOfLife.setLivingCell(0, 5);
        gameOfLife.setLivingCell(1, 5);
        gameOfLife.setLivingCell(2, 5);
        gameOfLife.setLivingCell(2, 4);
        gameOfLife.setLivingCell(2, 3);
        gameOfLife.setLivingCell(1, 3);

        int neighboursCount = gameOfLife.countlivingNeighbours(1, 4);

        assertThat(neighboursCount).isEqualTo(8);
    }

    @Test
    public void foundsThreeLivingNeighboursForTheTopLeftCornerCell() {

        gameOfLife.setLivingCell(0, 1);
        gameOfLife.setLivingCell(1, 1);
        gameOfLife.setLivingCell(1, 0);

        int neighboursCount = gameOfLife.countlivingNeighbours(0, 0);

        assertThat(neighboursCount).isEqualTo(3);
    }

    @Test
    public void foundsThreeLivingNeighboursForTheBottomRightCornerCell() {

        gameOfLife.setLivingCell(3, 6);
        gameOfLife.setLivingCell(2, 6);
        gameOfLife.setLivingCell(2, 7);

        int neighboursCount = gameOfLife.countlivingNeighbours(3, 7);

        assertThat(neighboursCount).isEqualTo(3);
    }

    @Test
    public void aCellWithFewerThanTwoNeighboursDies() {

        gameOfLife.setLivingCell(0, 0);
        gameOfLife.setLivingCell(0, 1);

        gameOfLife.computeNextGeneration();

        assertThat(gameOfLife.isDead(0,0)).isTrue();
    }


    @Test
    public void aCellWithAtLeastTwoNeighboursLives() {

        gameOfLife.setLivingCell(0, 0);
        gameOfLife.setLivingCell(0, 1);
        gameOfLife.setLivingCell(1, 1);

        gameOfLife.computeNextGeneration();

        assertThat(gameOfLife.isAlive(0,0)).isTrue();
    }


    @Test
    public void aCellWithMoreThanThreeNeighboursDies() {

        gameOfLife.setLivingCell(1, 4);
        gameOfLife.setLivingCell(0, 3);
        gameOfLife.setLivingCell(0, 4);
        gameOfLife.setLivingCell(0, 5);
        gameOfLife.setLivingCell(1, 5);

        gameOfLife.computeNextGeneration();

        assertThat(gameOfLife.isDead(1,4)).isTrue();

    }


    @Test
    public void aDeadCellWithThreeNeighboursGetsAlive() {

        gameOfLife.setLivingCell(0, 3);
        gameOfLife.setLivingCell(0, 4);
        gameOfLife.setLivingCell(0, 5);

        gameOfLife.computeNextGeneration();

        assertThat(gameOfLife.isAlive(1,4)).isTrue();

    }

    @Test
    public void testAnHandMadeGrid() {

        gameOfLife.setLivingCell(1, 4);
        gameOfLife.setLivingCell(2, 3);
        gameOfLife.setLivingCell(2, 4);

        gameOfLife.computeNextGeneration();

        int [][] expectedGrid = new int[][]{
                {GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL},
                {GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.LIVING_CELL, GameOfLife.LIVING_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL},
                {GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.LIVING_CELL, GameOfLife.LIVING_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL},
                {GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL}
        };

       assertThat(Arrays.deepEquals(gameOfLife.grid, expectedGrid)).isTrue();
    }

    private GameOfLife gameOfLife;
}
