package org.wecancoeit.reviews;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class KdramaReviewsRepository {

    Map<Long, Kdrama> kdramaList = new HashMap<>();

    public KdramaReviewsRepository(){
        Kdrama cloy = new Kdrama(1L,"Crash Landing On You", "Romance Between a South Korean Heiress and a North Korean Military Officer","images/cloy.jpg","romance");
        Kdrama reply = new Kdrama(2L,"Reply 1988", "Story of five childhood friends", "images/reply1988.jpg", "Comedy/Romance");
        Kdrama goblin = new Kdrama(3L, "Goblin", "Story of a 939-year-old Goblin who fell in love with a mortal", "images/Goblin.jpg", "Romance");

        kdramaList.put(cloy.getId(), cloy);
        kdramaList.put(reply.getId(), reply);
        kdramaList.put(goblin.getId(), goblin);
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