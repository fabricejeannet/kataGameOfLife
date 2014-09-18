import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.logging.Logger;

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
    public void foundsNoNeighbourAroundARandomCellWithNoNeighbour() {

        int neighboursCount = gameOfLife.countlivingNeighbours(1, 4);

        assertThat(neighboursCount).isEqualTo(0);
    }

    @Test
    public void foundsOneNeighbourAroundARandomCellWithNoNeighbour() {

        gameOfLife.setLivingCell(0, 3);

        int neighboursCount = gameOfLife.countlivingNeighbours(1, 4);

        assertThat(neighboursCount).isEqualTo(1);
    }


    @Test
    public void foundsTwoNeighbourAroundARandomCellWithNoNeighbour() {

        gameOfLife.setLivingCell(0, 3);
        gameOfLife.setLivingCell(0, 4);

        int neighboursCount = gameOfLife.countlivingNeighbours(1, 4);

        assertThat(neighboursCount).isEqualTo(2);
    }


    @Test
    public void foundsThreeNeighbourAroundARandomCellWithNoNeighbour() {

        gameOfLife.setLivingCell(0, 3);
        gameOfLife.setLivingCell(0, 4);
        gameOfLife.setLivingCell(0, 5);

        int neighboursCount = gameOfLife.countlivingNeighbours(1, 4);

        assertThat(neighboursCount).isEqualTo(3);
    }

    @Test
    public void foundsFourNeighbourAroundARandomCellWithNoNeighbour() {

        gameOfLife.setLivingCell(0, 3);
        gameOfLife.setLivingCell(0, 4);
        gameOfLife.setLivingCell(0, 5);
        gameOfLife.setLivingCell(1, 5);

        int neighboursCount = gameOfLife.countlivingNeighbours(1, 4);

        assertThat(neighboursCount).isEqualTo(4);
    }

    @Test
    public void foundsFiveNeighbourAroundARandomCellWithNoNeighbour() {

        gameOfLife.setLivingCell(0, 3);
        gameOfLife.setLivingCell(0, 4);
        gameOfLife.setLivingCell(0, 5);
        gameOfLife.setLivingCell(1, 5);
        gameOfLife.setLivingCell(2, 5);

        int neighboursCount = gameOfLife.countlivingNeighbours(1, 4);

        assertThat(neighboursCount).isEqualTo(5);
    }

    @Test
    public void foundsSixNeighbourAroundARandomCellWithNoNeighbour() {

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
    public void foundsSevenNeighbourAroundARandomCellWithNoNeighbour() {

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
    public void foundsHeightNeighbourAroundARandomCellWithNoNeighbour() {

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
    public void foundsThreeNeighbourAroundCorner() {

        gameOfLife.setLivingCell(0, 1);
        gameOfLife.setLivingCell(1, 1);
        gameOfLife.setLivingCell(1, 0);

        int neighboursCount = gameOfLife.countlivingNeighbours(0, 0);

        assertThat(neighboursCount).isEqualTo(3);
    }


    @Test
    public void aCellWithFewerThanTwoNeighboursDies() {

        gameOfLife.setLivingCell(0, 0);
        gameOfLife.setLivingCell(0, 1);

        gameOfLife.computeNextGeneration();

        assertThat(gameOfLife.isAlive(0,0)).isFalse();
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
    public void aCellWithMoreThanThreNeighboursDies() {

        gameOfLife.setLivingCell(1, 4);
        gameOfLife.setLivingCell(0, 3);
        gameOfLife.setLivingCell(0, 4);
        gameOfLife.setLivingCell(0, 5);
        gameOfLife.setLivingCell(1, 5);

        gameOfLife.computeNextGeneration();

        assertThat(gameOfLife.isAlive(1,4)).isFalse();

    }


    @Test
    public void aDeadCellWithThreNeighboursGetsAlive() {

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
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };

       assertThat(Arrays.deepEquals(gameOfLife.grid, expectedGrid)).isTrue();
    }

    private GameOfLife gameOfLife;
}
