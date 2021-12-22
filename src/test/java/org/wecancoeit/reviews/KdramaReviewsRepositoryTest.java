package org.wecancoeit.reviews;

import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KdramaReviewsRepositoryTest {

    private KdramaReviewsRepository underTest;
    private Kdrama kdramaOne = new Kdrama(1L, "kdrama one title", "description","imgUrl","genre");
    private Kdrama kdramaTwo = new Kdrama(2L, "kdrama two title", "description", "imgUrl", "genre");

    @Test
    public void shouldFindKdramaOne() {
        underTest = new KdramaReviewsRepository(kdramaOne);
        Kdrama foundKdrama = underTest.findOne(1L);
        assertEquals(kdramaOne, foundKdrama);
    }

    @Test
    public void shouldFindKdramaOneAndKdramaTwo() {
        underTest = new KdramaReviewsRepository(kdramaOne, kdramaTwo);
        Collection<Kdrama> foundKdramas = underTest.findAll();
        assertThat(foundKdramas).contains(kdramaOne, kdramaTwo);


    }
}
