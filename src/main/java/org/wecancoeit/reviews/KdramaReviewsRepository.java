package org.wecancoeit.reviews;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class KdramaReviewsRepository {

    Map<Long, Kdrama> kdramaList = new HashMap<>();

    public KdramaReviewsRepository(){
        Kdrama action = new Kdrama(1L,"Action", "2021 Action Kdrama");
        Kdrama romanticComedy = new Kdrama(2L,"Rom-Com", "2021 Romantic Comedy Kdrama");
        Kdrama historical = new Kdrama(3L, "Historical", "2021 Historical Kdrama");

        kdramaList.put(action.getId(), action);
        kdramaList.put(romanticComedy.getId(), romanticComedy);
        kdramaList.put(historical.getId(), historical);
    }

    public KdramaReviewsRepository(Kdrama ...kdramasToAdd) {
        for(Kdrama kdrama: kdramasToAdd){
            kdramaList.put(kdrama.getId(), kdrama);
        }
    }

    public Kdrama findOne(long id) {
        return kdramaList.get(id);
    }

    public Collection<Kdrama> findAll() {
        return kdramaList.values();
    }
}