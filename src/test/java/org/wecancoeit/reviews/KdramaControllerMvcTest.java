package org.wecancoeit.reviews;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(KdramaController.class)
public class KdramaControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private KdramaReviewsRepository kdramaRepo;

    @Mock
    private Kdrama kdramaOne;

    @Mock
    private Kdrama kdramaTwo;

    @Test
    public void shouldBeOkForAllKdramasInTheKdramaTemplate() throws Exception{
        mockMvc.perform(get("/kdramas")).andExpect(status().isOk())
                .andExpect(view().name("kdramasTemplate"));
    }

    @Test
    public void shouldFindAllKdramasInModel() throws Exception{
        Collection<Kdrama> allKdramasModel = Arrays.asList(kdramaOne, kdramaTwo);
        when(kdramaRepo.findAll()).thenReturn(allKdramasModel);
        mockMvc.perform(get("/kdramas"))
                .andExpect(model().attribute("kdramasModel", allKdramasModel));

    }

    @Test
    public void shouldBeOkForOneKdramaInTheKdramaTemplate() throws Exception{
        mockMvc.perform(get("/kdrama?id=1")).andExpect(status().isOk())
                .andExpect(view().name("kdramaTemplate"));
    }
    @Test
    public void shouldFindKdramaOneInModel() throws Exception{
        Long kdramaOneId = 1L;
        when(kdramaRepo.findOne(kdramaOneId)).thenReturn(kdramaOne);
        mockMvc.perform(get("/kdrama?id=1"))
                .andExpect(model().attribute("kdramaModel", kdramaOne));

    }
}
